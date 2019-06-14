package com.muze.core.app.org.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.login.model.UserModel;
import com.muze.core.app.org.model.OrgModel;
import com.muze.core.app.org.model.OrgPermissionModel;
import com.muze.core.app.org.service.OrgService;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.ConstantUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.RequestUtil;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * *********************基本信息说明********************************
 * 类名        :OrgController.java
 * 项目名称 :com.muze.core.app.doc.web
 * 类说明     :机构管理页面
 * 创建时间 :2015年12月4日
 * 作         者:张玉龙
 * 版         本:v1
 ***************************修改历史********************************
 * 1、none
 * 修改人    :张玉龙
 * 修改时间:2015年12月4日
 ************************主要方法说明********************************
 * 1、getPage页面转向
 * 2、orgPerrmission获取机构权限
 * 3、getOrg查询机构信息
 * 4、add 机构添加
 * 5、save修改添加页面转向
 * 6、getOrgPerrmission获取机构权限数据
 * 7、saveOrgPerrmission保存机构权限
 * 8、ftl:静态模板
 * 9、ftlHTML:生成静态页面
 *******************************************************************
 */
@Controller
@RequestMapping("/OrgController")
public class OrgController extends BaseController{

	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;

	@Autowired
	private OrgService orgService;

	/**
	 * *********************基本信息说明********************************
	 * 方法名     :getPage
	 * 方法说明 :跳转机构管理页面
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、model:页面参数对象
	 * 创建时间 :2015年12月10日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月10日
	 ************************方法功能说明********************************
	 * 1、获取菜单信息跳转到机构管理页面
	 *******************************************************************
	 */
	@RequiresPermissions("org:manage")
	@RequestMapping("/getPage")
	public String getPage(Map<String, Object> model) {
		List<Map<String, String>> list = commonService.getbtnPermission(BtnPermissionUtil.Org.PAGE);
		Session session = SecurityUtils.getSubject().getSession();
		UserModel userDto = (UserModel) session.getAttribute("user");
		model.put("list", list);
		model.put("userType", userDto.getType());
		return PageURLUtil.org.PAGE;
	}

	/**
	 * *********************基本信息说明********************************
	 * 方法名     :orgPerrmission
	 * 方法说明 :获取机构权限信息
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、request:消息对象
	 * 2、response:响应对象
	 * 3、model:参数对象
	 * 创建时间 :2015年12月10日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月10日
	 ************************方法功能说明********************************
	 * 1、由机构ID获取权限信息
	 *******************************************************************
	 */
	@RequiresPermissions("org:manage:author")
	@RequestMapping("/orgPerrmission")
	public String orgPerrmission(Map<String, String> model,
			HttpServletRequest request, HttpServletResponse response) {
		RequestUtil.putModelMap(request, model);
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute(ConstantUtil.ORG_ID,
				request.getParameter("org_id"));
		return PageURLUtil.org.ORG_PERRMISSION;
	}

	// 查询机构
	@RequiresPermissions("org:manage:select")
	@RequestMapping("/getOrg")
	@ResponseBody
	public String getOrg(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String loginName = (String) session.getAttribute(
				ConstantUtil.LOGIN_USER);

		List<OrgModel> list = orgService.getOrg(loginName);
		JSONObject json = new JSONObject();
		json.put("total", list.size());
		json.put("rows", list);
		return json.toString();
	}

	// 机构添加页面转向
	@RequiresPermissions("org:manage:insert")
	@RequestMapping("/add")
	public String add(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) {
		model.put("orgAddOrSave", "add");
		model.put("org_id", request.getParameter("org_id"));
		return PageURLUtil.org.ORG_ADD_SAVE;
	}

	// 修改添加页面转向
	@RequiresPermissions("org:manage:update")
	@RequestMapping("/save")
	public String save(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> model) {
		model.put("orgAddOrSave", "save");
		model.put("org_id", request.getParameter("org_id"));
		RequestUtil.putModelMap(request, model);
		return PageURLUtil.org.ORG_ADD_SAVE;
	}

	// 机构添加页面转向
	@RequiresPermissions(value={"org:manage:insert","org:manage:update"},logical=Logical.OR)
	@RequestMapping("/addorSave")
	@ResponseBody
	public String addorSave(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) {
		return orgService
				.addORSaveUser(RequestUtil.getRequestParamMap(request));
	}

	// 机构删除
	@RequiresPermissions("org:manage:delete")
	@RequestMapping("/del")
	@ResponseBody
	public String del(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model) {
		orgService.delOrg(request.getParameter("org_id"));
		return "delSuccess";
	}

	// 查询机构权限
	@RequiresPermissions("org:manage:author")
	@RequestMapping("/getOrgPerrmission")
	@ResponseBody
	public String getOrgPerrmission(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		List<OrgPermissionModel> list = orgService
				.getOrgPerrmission(
						String.valueOf(session.getAttribute(
								ConstantUtil.ORG_ID)),
						request.getParameter("parentid"));
		JSONObject json = new JSONObject();
		json.put("total", list.size());
		json.put("rows", list);
		return json.toString();
	}

	// 保存机构权限
	@RequiresPermissions("org:manage:author")
	@RequestMapping("/saveOrgPerrmission")
	@ResponseBody
	public String saveOrgPerrmission(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model,
			@RequestBody List<String> list) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		orgService.saveOrgPerrmission(
				String.valueOf(session.getAttribute(
						ConstantUtil.ORG_ID)), list);
		return "success";
	}

	// 静态模板
	@RequestMapping("/ftl")
	public String ftl(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model) throws URISyntaxException {

		List<ValueObject> pList = new ArrayList<ValueObject>();
		ValueObject val = null;

		val = new ValueObject();
		val.setFname("张玉龙");
		val.setGname("玉龙");
		val.setEmail("492926917@qq.com");
		val.setManager("m&an<ager");
		pList.add(val);

		val = new ValueObject();
		val.setFname(String.valueOf(new Random().nextInt()));
		val.setGname(String.valueOf(new Random().nextInt()));
		val.setEmail(String.valueOf(new Random().nextInt()));
		val.setManager(String.valueOf(new Random().nextInt()));
		pList.add(val);
		model.put("people", pList);
		
		//file:/D:/workspacezylNew/com.muze.core.app.doc/target/classes/
		System.out.println(this.getClass().getResource("/"));
		//D:\workspacezylNew\com.muze.core.app.doc\src\main\webapp\
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		//D:\workspacezylNew\com.muze.core.app.doc\src\main\webapp
		System.out.println(request.getSession().getServletContext().getRealPath(""));
		//D:\workspacezylNew\com.muze.core.app.doc
		System.out.println(System.getProperty("user.dir"));
		
		//file:/D:/workspacezylNew/com.muze.core.app.doc/target/classes/com/muze/core/app/org/web/
		System.out.println(this.getClass().getResource("") );

		return "templateJSP";
	}

	// 静态页面
	@RequestMapping("/ftlHTML")
	public String ftlHTML(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) throws IOException {

		Configuration freeMarkerCfg = new Configuration();
		Template template = null;
		
		// freeMarkerCfg.setClassForTemplateLoading(getClass(), "");
		freeMarkerCfg.setObjectWrapper(new DefaultObjectWrapper());
		
		File file =new File(request.getSession().getServletContext().getRealPath("/") + "WEB-INF/views/ftl/");
		freeMarkerCfg.setDirectoryForTemplateLoading(file);
		
		//freeMarkerCfg.setCacheStorage(new freemarker.cache.MruCacheStorage(2, 4));
		
		try {
			template = freeMarkerCfg.getTemplate("templateHTML.ftl");
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
		
		String reqFileName = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/views/ftl/";
		String randomId = null;
		try {

				Map<String, Object> parameters = new HashMap<String, Object>();

				List<ValueObject> pList = new ArrayList<ValueObject>();
				ValueObject val = null;

				val = new ValueObject();
				val.setFname("Yao");
				val.setGname("Yao");
				val.setEmail("test@mail.com");
				val.setManager("m&an<ager");
				pList.add(val);

				val = new ValueObject();
				val.setFname("J");
				val.setGname("Jeremy");
				val.setEmail("test1@mail.com");
				val.setManager("m&an<ager");
				pList.add(val);
				parameters.put("people", pList);
				randomId = String.valueOf(new Random().nextInt(10000));
				OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(reqFileName + randomId+ ".jsp"), "UTF-8");
				template.process(parameters, writer);
				writer.flush();

		} catch (IOException e) {
			e.printStackTrace();// TODO
		} catch (TemplateException e) {
			e.printStackTrace();// TODO
		}

		return "ftl/"+randomId;
	}
}
