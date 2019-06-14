package com.muze.core.app.group.web;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.group.model.GroupModel;
import com.muze.core.app.group.service.GroupService;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.ConstantUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.RequestUtil;

/**
 * *********************基本信息说明********************************
 * 类名        :GroupController.java
 * 项目名称 :com.muze.core.app.doc.web
 * 类说明     :团队页面操作
 * 创建时间 :2015年12月2日
 * 作         者:张玉龙
 * 版         本:v1
 ***************************修改历史********************************
 * 1、none
 * 修改人    :张玉龙
 * 修改时间:2015年12月2日
 ************************主要方法说明********************************
 * 1、getPage:获取菜单信息
 * 2、getGroups:查询团队分页信息
 * 3、add:跳转到添加页面
 * 4、save:保存页面跳转
 * 5、addOrsave:添加或修改团队
 * 6、del:根据团队ID删除团队信息
 *******************************************************************
 */
@Controller
@RequestMapping("/GroupController")
public class GroupController extends BaseController{

	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;
	
	@Autowired
	private GroupService groupService;
 
	/**
	 * *********************基本信息说明********************************
	 * 方法名     :getPage
	 * 方法说明 :获取菜单信息
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、Map<String, Object> model:反回信息参数Map
	 * 创建时间 :2015年12月2日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月2日
	 ************************方法功能说明********************************
	 * 1、获取菜单的信息,菜单code,菜单名，菜单权限等。
	 * 2、反回给页面
	 *******************************************************************
	 */
	@RequiresPermissions("6BplAE8uWWQA7ETSXFtLGf70J65bmh")
	@RequestMapping("/getPage")
	public String getPage(Map<String, Object> model) {
		List<Map<String, String>> list = commonService
				.getbtnPermission(BtnPermissionUtil.Group.PAGE);
		model.put("list", list);
		return PageURLUtil.group.PAGE;
	}

	/**
	 * *********************基本信息说明********************************
	 * 方法名     :getGroups
	 * 方法说明 :查询团队分页信息
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、Map<String, Object> model:返回信息类
	 * 2、HttpServletRequest request:消息头
	 * 3、HttpServletResponse response：响应头
	 * 创建时间 :2015年12月2日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月2日
	 ************************方法功能说明********************************
	 * 1、获取PageBounds对象，设置分页信息，每页条数
	 * 2、从session里获取登录名称，并且获取查询内容，封装给PageList对象
	 * 3、封装JSONObject对象返回给前台页面
	 *******************************************************************
	 */
	@RequiresPermissions("Hz7ZZOVovdP4Z68VTpOg5Kl1HHCTAU")
	@RequestMapping("/getGroups")
	@ResponseBody
	public String getGroups(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {

		PageBounds pageBounds = new PageBounds(Integer.parseInt(request
				.getParameter("page")), Integer.parseInt(request
				.getParameter("rows")));

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		String loginName = (String) session.getAttribute(
				ConstantUtil.LOGIN_USER);
		
		PageList<GroupModel> list = groupService.getGroups(loginName, pageBounds);
		
		JSONObject json = new JSONObject();

		json.put("total", list.getPaginator().getTotalCount());
		json.put("rows", list);

		return json.toString();
	}
	
	/**
	 * *********************基本信息说明********************************
	 * 方法名     :add
	 * 方法说明 :跳转到添加页面
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、Map<String, Object> model:返回信息类
	 * 2、HttpServletRequest request:消息头
	 * 3、HttpServletResponse response：响应头
	 * 创建时间 :2015年12月2日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月2日
	 ************************方法功能说明********************************
	 * 1、添加groupAddOrSave标记
	 * 2、返回添加页面
	 *******************************************************************
	 */
	@RequiresPermissions("YnDXa8yI6Q0hR5G3npQsOSgwrTCRFY")
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response,
			Map<String, String> model){
		model.put("groupAddOrSave", "add");
		return PageURLUtil.group.GROUP_ADD_SAVE;
	}
	
	/**
	 * *********************基本信息说明********************************
	 * 方法名     :save
	 * 方法说明 :保存页面跳转
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、Map<String, Object> model:返回信息类
	 * 2、HttpServletRequest request:消息头
	 * 3、HttpServletResponse response：响应头
	 * 创建时间 :2015年12月2日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月2日
	 ************************方法功能说明********************************
	 * 1、添加groupAddOrSave标记
	 * 2、返回添加页面
	 *******************************************************************
	 */
	@RequiresPermissions("3Jw2ySpkDQycZCqk7tT0ckkZIiUmHP")
	@RequestMapping("/save")
	public String save(HttpServletRequest request, HttpServletResponse response,
			Map<String, String> model){
		model.put("groupAddOrSave", "save");
		model = RequestUtil.putModelMap(request, model);
		return PageURLUtil.group.GROUP_ADD_SAVE;
	}
	
	
	/**
	 * *********************基本信息说明********************************
	 * 方法名     :addOrsave
	 * 方法说明 :添加或修改团队
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、Map<String, Object> model:返回信息类
	 * 2、HttpServletRequest request:消息头
	 * 3、HttpServletResponse response：响应头
	 * 创建时间 :2015年12月2日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月2日
	 ************************方法功能说明********************************
	 * 1、调用RequestUtil.getRequestParamMap(request)封装request对象
	 * 2、添加团队对象。
	 * 3、返回添加flag
	 *******************************************************************
	 */
	@RequiresPermissions(value ={"YnDXa8yI6Q0hR5G3npQsOSgwrTCRFY","3Jw2ySpkDQycZCqk7tT0ckkZIiUmHP"},logical=Logical.OR)
	@RequestMapping("/addOrsave")
	@ResponseBody
	public String addOrsave(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> model) {
		return groupService.addOrSave(RequestUtil.getRequestParamMap(request));
				
	}
	
	/**
	 * *********************基本信息说明********************************
	 * 方法名     :del
	 * 方法说明 :根据团队ID删除团队信息
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、Map<String, Object> model:返回信息类
	 * 2、HttpServletRequest request:消息头
	 * 3、HttpServletResponse response：响应头
	 * 4、group_id:团队ID
	 * 创建时间 :2015年12月2日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月2日
	 ************************方法功能说明********************************
	 * 1、根据团队ID删除团队信息
	 * 2、返回参数结果
	 *******************************************************************
	 */
	@RequiresPermissions("18VDNThUQw32qhdPuPkC5ClxdJrM4F")
	@RequestMapping("/del")
	@ResponseBody
	public String del(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> model,@RequestParam("group_id") String group_id) {
		groupService.del(group_id);
		return "success";
				
	}
		
}