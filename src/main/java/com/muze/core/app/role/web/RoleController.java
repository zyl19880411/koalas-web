package com.muze.core.app.role.web;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.role.model.RoleModel;
import com.muze.core.app.role.model.RolePermissionModel;
import com.muze.core.app.role.service.RoleService;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.ConstantUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.RequestUtil;

/**
 * *********************基本信息说明********************************
 * 类名        :RoleController.java
 * 项目名称 :com.muze.core.app.doc.web
 * 类说明     :角色管理界面
 * 创建时间 :2015年12月8日
 * 作         者:张玉龙
 * 版         本:v1
 ***************************修改历史********************************
 * 1、none
 * 修改人    :张玉龙
 * 修改时间:2015年12月8日
 ************************主要方法说明********************************
 * 1、getPage:获取页面信息
 * 2、getRoles:获取分页权限信息
 * 3、add:添加页面转向
 * 4、save:保存页面转向
 * 5、addOrsave:添加或者删除方法
 * 6、del:删除角色
 * 7、rolePermission角色权限页面跳转
 * 8、getRolePermission获取角色权限
 * 9、saveRolePermission:保存角色权限
 *******************************************************************
 */
@Controller
@RequestMapping("/RoleController")
public class RoleController extends BaseController {

	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;

	@Autowired
	private RoleService roleService;

	// 页面转向
	@RequiresPermissions("role:manage")
	@RequestMapping("/getPage")
	public String getPage(Map<String, Object> model) {
		List<Map<String, String>> list = commonService.getbtnPermission(BtnPermissionUtil.Role.PAGE);
		model.put("list", list);
		return PageURLUtil.role.PAGE;
	}

	// 角色查询
	@RequiresPermissions("role:manage:select")
	@RequestMapping("/getRoles")
	@ResponseBody
	public String getRoles(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {

		PageBounds pageBounds = new PageBounds(Integer.parseInt(request
				.getParameter("page")), Integer.parseInt(request
				.getParameter("rows")));
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String loginName = (String) session.getAttribute(
				ConstantUtil.LOGIN_USER);

		PageList<RoleModel> list = roleService.getRoles(loginName, pageBounds);
		JSONObject json = new JSONObject();

		json.put("total", list.getPaginator().getTotalCount());
		json.put("rows", list);

		return json.toString();
	}

	// 页面转向
	@RequiresPermissions("role:manage:insert")
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response,
			Map<String, String> model) {
		model.put("roleAddOrSave", "add");
		return PageURLUtil.role.ROLE_ADD_SAVE;
	}

	// 页面转向
	@RequiresPermissions("role:manage:update")
	@RequestMapping("/save")
	public String save(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> model) {
		model.put("roleAddOrSave", "save");
		model = RequestUtil.putModelMap(request, model);
		return PageURLUtil.role.ROLE_ADD_SAVE;
	}

	// 添加或者修改
	@RequiresPermissions(value ={"role:manage:insert","role:manage:update"},logical=Logical.OR)
	@RequestMapping("/addOrsave")
	@ResponseBody
	public String addOrsave(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> model) {
		return roleService.addORSaveRole(RequestUtil
				.getRequestParamMap(request));
	}

	// 删除
	@RequiresPermissions("role:manage:delete")
	@RequestMapping("/del")
	@ResponseBody
	public String del(@RequestParam("role_id") String role_id,
			HttpServletRequest request, HttpServletResponse response,
			Map<String, String> model) {
		return roleService.delRole(role_id);
	}
	
	//角色权限
	@RequiresPermissions("role:manage:author")
	@RequestMapping("/rolePermission")
	public String rolePermission(@RequestParam("role_id") String role_id,  HttpServletRequest request, HttpServletResponse response,
			Map<String, String> model) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute(ConstantUtil.ROLE_ID, role_id);
		return PageURLUtil.role.ROLE_PERRMISSION;
	}
	
	//角色权限查询
	@RequiresPermissions("role:manage:author")
	@RequestMapping("/getRolePermission")
	@ResponseBody
	public String getRolePermission(HttpServletRequest request, HttpServletResponse response,
			Map<String, String> model) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		List<RolePermissionModel> list = roleService.getRolePermission(String.valueOf(session.getAttribute(ConstantUtil.ROLE_ID)));
		JSONObject json = new JSONObject();
		json.put("total", list.size());
		json.put("rows", list);
		return json.toString();
	}
	
	//角色权限查询
	@RequiresPermissions("role:manage:author")
	@RequestMapping("/saveRolePermission")
	@ResponseBody
	public String saveRolePermission(HttpServletRequest request, HttpServletResponse response,
			Map<String, String> model,@RequestBody List<String> list) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		roleService.saveRolePermission(list, String.valueOf(session.getAttribute(ConstantUtil.ROLE_ID)));
		
		return "success";
	}
}