package com.muze.core.app.utils;

//返回参数路径
public class PageURLUtil {

	// 登录相关
	public static class login {

		// 登录界面
		public static final String USER_LOGIN = "login/login";

		// 业务界面
		public static final String INDEX = "login/index";

		// 转向登录界面
		public static final String FORWARD_LOGIN = "forward:/login/userLogin.do";

		// 转向登录界面
		public static final String REDIRECT_LOGIN = "redirect:/login/userLogin.do";
	}

	// 用户相关
	public static class user {

		// 用户界面
		public static final String PAGE = "doctor/user";

		// 用户添加修改界面
		public static final String USER_ADD_SAVE = "doctor/userAddOrSave";

		// 用户角色界面
		public static final String USER_ROLE = "doctor/userRoles";

		// 用户角色界面
		public static final String USER_GROUP = "doctor/userGroups";
	}

	// 角色相关
	public static class role {

		// 角色界面
		public static final String PAGE = "role/role";

		// 角色修改
		public static final String ROLE_ADD_SAVE = "role/roleAddOrSave";

		// 角色修改
		public static final String ROLE_PERRMISSION = "role/rolePermission";
	}

	// 菜单相关
	public static class permission {

		// 菜单界面
		public static final String PAGE = "permission/permission";

		// 菜单添加
		public static final String PERRMISSION_ADD_SAVE = "permission/perAddOrSave";

		// 图标界面
		public static final String PERRMISSION_ICON_PAGE = "permission/iconPage";
	}

	// 机构相关
	public static class org {

		// 机构查询界面
		public static final String PAGE = "org/org";

		// 机构修改画面
		public static final String ORG_ADD_SAVE = "org/orgAddOrSave";

		// 机构修改画面
		public static final String ORG_PERRMISSION = "org/orgPerrmission";
	}

	// 团队相关
	public static class group {
		// 无权限路径
		public static final String PAGE = "group/group";

		// 添加修改界面
		public static final String GROUP_ADD_SAVE = "group/groupAddOrSave";
	}

	// 定时任务相关
	public static class task {

		// 定时任务主页面
		public static final String PAGE = "task/task";

		// 定时任务主添加页面跳转
		public static final String ADD = "task/taskAdd";
	}

	// 错误路径
	public static class error {
		// 无权限路径
		public static final String UNAUTHORIZED = "error/Unauthorized";
	}
	
	// 定时任务相关
	public static class taskTime {

		// 定时任务主页面
		public static final String PAGE = "task/taskTime";

	}
	
	// 定时任务相关
	public static class taskLog {

		// 定时任务主页面
		public static final String PAGE = "task/taskLog";

	}

	// 主页相关
	public static class Index {
		public static final String PAGE = "index/home";
	}
}