package com.muze.core.app.user.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.user.model.UserGroupsModel;
import com.muze.core.app.user.model.UserModel;
import com.muze.core.app.user.model.UserRolesModel;
import com.muze.core.app.user.service.UserService;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.ConstantUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.RequestUtil;

/**
 * *********************基本信息说明********************************
 * 类名        :UserController.java
 * 项目名称 :com.muze.core.app.doc.web
 * 类说明     :这个类的目的是去对数据进行删除
 * 创建时间 :2015年12月8日
 * 作         者:张玉龙
 * 版         本:v1
 ***************************修改历史********************************
 * 1、none
 * 修改人    :张玉龙
 * 修改时间:2015年12月8日
 ************************主要方法说明********************************
 * 1、getPage用户页面转向
 * 2、userAdd用户添加页面转向
 * 3、userUpd用户修改页面转向
 * 4、userRole用户角色页面转向
 * 5、userGroup用户团队页面转向
 * 6、getUsers获取分页用户信息
 * 7、getOrg获取当前用户机构和子机构
 * 8、addORSaveUser添加或保存用户信息
 * 9、delUser删除用户信息
 * 10、userRoles获取用户角色
 * 11、saveUserRoles保存用户角色
 * 12、userGroups获取用户团队
 * 13、saveUserGroups保存用户团队
 *******************************************************************
 */
@Controller
@RequestMapping("/UserController")
public class UserController extends BaseController{

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;

	// 页面转向
	@RequiresPermissions("user:manage")
	@RequestMapping("/getPage")
	public String getPage(Map<String, Object> model) {
		List<Map<String, String>> list = commonService.getbtnPermission(BtnPermissionUtil.User.PAGE);
		model.put("list", list);
		return PageURLUtil.user.PAGE;
	}

	// 用户添加页面转向
	@RequiresPermissions("user:manage:insert")
	@RequestMapping("/userAdd")
	public String userAdd(Map<String, Object> model) {
		model.put("userAddOrSave", "add");
		return PageURLUtil.user.USER_ADD_SAVE;
	}

	// 用户修改页面转向
	@RequiresPermissions("user:manage:update")
	@RequestMapping("/userUpd")
	public String userUpd(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> model) {
		model.put("userAddOrSave", "save");
		model = RequestUtil.putModelMap(request, model);
		System.out.println(model);
		return PageURLUtil.user.USER_ADD_SAVE;
	}

	// 用户角色页面转向
	@RequiresPermissions("user:manage:roles")
	@RequestMapping("/userRole")
	public String userRole(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("doc_id") String doc_id, Map<String, String> model) {
		model.put("doc_id", doc_id);
		return PageURLUtil.user.USER_ROLE;
	}

	// 用户团队页面转向
	@RequiresPermissions("user:manage:group")
	@RequestMapping("/userGroup")
	public String userGroup(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("doc_id") String doc_id, Map<String, String> model) {
		model.put("doc_id", doc_id);
		return PageURLUtil.user.USER_GROUP;
	}
		
	// 查询用户功能
	@RequiresPermissions("user:manage:select")
	@RequestMapping("/getUsers")
	@ResponseBody
	public String getUsers(@RequestParam("userName") String userName,
			@RequestParam("tel") String tel, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("param" + request.getQueryString());

		PageBounds pageBounds = new PageBounds(Integer.parseInt(request
				.getParameter("page")), Integer.parseInt(request
				.getParameter("rows")));

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		String loginName = (String) session.getAttribute(
				ConstantUtil.LOGIN_USER);

		PageList<UserModel> list = userService.getUser(userName, tel, loginName,
				pageBounds);
		JSONObject json = new JSONObject();

		json.put("total", list.getPaginator().getTotalCount());
		json.put("rows", list);

		return json.toString();
	}

	// 查询所有组织机构
	@RequiresAuthentication
	@RequestMapping("/getOrg")
	@ResponseBody
	public String getOrg(HttpServletRequest request,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		String loginName = (String) session.getAttribute(
				ConstantUtil.LOGIN_USER);
		List<Map<String, String>> list = userService.getOrg(loginName);

		JSONArray jsonarray = JSONArray.fromObject(list);
		return jsonarray.toString();
	}

	// 添加用户
	@RequiresPermissions(value ={"user:manage:insert","user:manage:update"},logical=Logical.OR)
	@RequestMapping("/addORSaveUser")
	@ResponseBody
	public String addORSaveUser(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(RequestUtil.getRequestParamMap(request));
		return userService.addORSaveUser(RequestUtil
				.getRequestParamMap(request));
	}

	// 删除用户
	@RequiresPermissions("user:manage:delete")
	@RequestMapping("/delUser")
	@ResponseBody
	public String delUser(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("doc_id") String doc_id) {
		return userService.delUser(doc_id);
	}

	// 用户角色
	@RequiresPermissions("user:manage:roles")
	@RequestMapping("/getuserRoles")
	@ResponseBody
	public String userRoles(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("doc_id") String doc_id) {
		PageBounds pageBounds = new PageBounds(Integer.parseInt(request
				.getParameter("page")), Integer.parseInt(request
				.getParameter("rows")));

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		session.setAttribute(ConstantUtil.USER_UPDATE_ID, doc_id);

		PageList<Map<String, String>> list = userService.userRoles(doc_id,
				pageBounds);

		JSONObject json = new JSONObject();

		json.put("total", list.getPaginator().getTotalCount());
		json.put("rows", list);

		return json.toString();
	}

	// 用户角色添加
	@RequiresPermissions("user:manage:roles")
	@RequestMapping("/saveUserRoles")
	@ResponseBody
	public String saveUserRoles(HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody Map<String,List<UserRolesModel>> map) {
		
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		userService.saveUserRoles(map, session
				.getAttribute(ConstantUtil.USER_UPDATE_ID).toString());
		return "saveUserRolesSuccess";

	}

	// 用户 团队
	@RequiresPermissions("user:manage:group")
	@RequestMapping("/getuserGroups")
	@ResponseBody
	public String userGroups(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("doc_id") String doc_id) {
		PageBounds pageBounds = new PageBounds(Integer.parseInt(request
				.getParameter("page")), Integer.parseInt(request
				.getParameter("rows")));

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		session.setAttribute(ConstantUtil.USER_UPDATE_ID, doc_id);

		PageList<Map<String, String>> list = userService.userGroups(doc_id,
				pageBounds);

		JSONObject json = new JSONObject();

		json.put("total", list.getPaginator().getTotalCount());
		json.put("rows", list);

		return json.toString();
	}
	
	// 用户团队添加
	@RequiresPermissions("user:manage:group")
	@RequestMapping("/saveUserGroups")
	@ResponseBody
	public String saveUserGroups(HttpServletRequest request,
			HttpServletResponse response,@RequestBody  Map<String,List<UserGroupsModel>> map) throws InterruptedException {
         
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		userService.saveUserGroups(map, session.getAttribute(ConstantUtil.USER_UPDATE_ID).toString());
		return "saveUserGroupsSuccess";
	}
}
