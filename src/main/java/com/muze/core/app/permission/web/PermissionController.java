package com.muze.core.app.permission.web;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.permission.model.PermissionModel;
import com.muze.core.app.permission.service.PermissionService;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.ConstantUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.RequestUtil;

/**
 * *********************基本信息说明********************************
 * 类名        :PermissionController.java
 * 项目名称 :com.muze.core.app.doc.web
 * 类说明     :权限管理页面
 * 创建时间 :2015年12月4日
 * 作         者:张玉龙
 * 版         本:v1
 ***************************修改历史********************************
 * 1、none
 * 修改人    :张玉龙
 * 修改时间:2015年12月4日
 ************************主要方法说明********************************
 * 1、getPage:权限页面跳转
 * 2、getPermission:获取权限信息
 * 3、add跳转到权限添加页面
 * 4、save权限修改页面跳转、
 * 5、addorSave权限添加删除
 * 6、del权限删除
 * 7、icon初始化查询菜单页面
 * 8、selecticon分页查询页面
 *******************************************************************
 */
@Controller
@RequestMapping("/PermissionController")
public class PermissionController extends BaseController{

	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;

	@Autowired
	private PermissionService permissionService;

	// 页面转向
	@RequiresPermissions("permission:manage")
	@RequestMapping("/getPage")
	public String getPage(Map<String, Object> model) {
		List<Map<String, String>> list = commonService.getbtnPermission(BtnPermissionUtil.Permission.PAGE);
		model.put("list", list);
		return PageURLUtil.permission.PAGE;
	}

	// 查询菜单
	@RequiresPermissions("permission:manage:select")
	@RequestMapping("/getPermission")
	@ResponseBody
	public String getPermission(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String loginName = (String) session.getAttribute(
				ConstantUtil.LOGIN_USER);

		List<PermissionModel> list = permissionService.getPermission(loginName);
		JSONObject json = new JSONObject();
		json.put("total", list.size());
		json.put("rows", list);
		return json.toString();
	}

	//菜单添加修改界面
	@RequiresPermissions("permission:manage:insert")
	@RequestMapping("/add")
	public String add(Map<String, String> model,
			HttpServletRequest request, HttpServletResponse response) {
		model.put("AddOrSave", "add");
		model = RequestUtil.putModelMap(request, model);
		return PageURLUtil.permission.PERRMISSION_ADD_SAVE;
	}
	
	//菜单添加修改界面
	@RequiresPermissions("permission:manage:update")
	@RequestMapping("/save")
	public String save(Map<String, String> model,
			HttpServletRequest request, HttpServletResponse response) {
		model.put("AddOrSave", "save");
		model = RequestUtil.putModelMap(request, model);
		return PageURLUtil.permission.PERRMISSION_ADD_SAVE;
	}
	
	//菜单添加界面
	@RequiresPermissions(value ={"permission:manage:insert","permission:manage:update"},logical=Logical.OR)
	@RequestMapping("/addorSave")
	@ResponseBody
	public String addOrsave(Map<String, String> model,
			HttpServletRequest request, HttpServletResponse response) {
 
		 return permissionService.addOrsave(RequestUtil
				.getRequestParamMap(request));
	}

	//菜单删除界面
	@RequiresPermissions("permission:manage:delete")
	@RequestMapping("/del")
	@ResponseBody
	public String del(Map<String, String> model,
			HttpServletRequest request, HttpServletResponse response,@RequestBody List<String> perrmission) {
 
		 return permissionService.deletePerrmission(perrmission);
	}
	
	//图标
	@RequestMapping("/icon")
	public String icon(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
	 
		 PageBounds pageBounds = new PageBounds(1,500);
		
		 List<String> list = permissionService.getIcon(pageBounds);
		 model.put("list",list);
	
	     return PageURLUtil.permission.PERRMISSION_ICON_PAGE;
	 }
	
	//图标
	@RequestMapping("/selecticon")
	@ResponseBody
	public String selecticon(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
	 
		 PageBounds pageBounds = new PageBounds(Integer.parseInt(request.getParameter("page")),Integer.parseInt(request.getParameter("rows")));
		 List<String> list = permissionService.getIcon(pageBounds);

		 JSONObject json = new JSONObject();
		 json.put("list", list.toString());
		 return json.toString();
		 
	 }
}
