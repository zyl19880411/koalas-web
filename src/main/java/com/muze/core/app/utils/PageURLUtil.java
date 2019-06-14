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

	// 海风新增任务相关
	public static class Hf {

		//新增订单主页面
		public static final String PAGE = "hf/hfOrder";

		//新增订单主页面日
		public static final String PAGE_DAY = "hf/hfOrderDay";

		//新增订单主页面周
		public static final String PAGE_WEEK = "hf/hfOrderWeek";

		//新增订单主页面月
		public static final String PAGE_MONTH = "hf/hfOrderMonth";

		//新增订单主页面年
		public static final String PAGE_YEAR= "hf/hfOrderYear";

		//新增修改页面
		public static final String ORDER_ADD_SAVE = "hf/hfOrderAddOrSave";

		//试听页面
		public static final String ORDER_LISTEN = "hf/hfOrderListen";

		//成单页面
		public static final String ORDER_SUCCESS = "hf/hfOrderSuccess";

		//转介绍
		public static final String ORDER_INTRODUCTION = "hf/introduction";

		//转介绍
		public static final String ORDER_ERROR = "hf/hfOrderError";
	}

	// 海风试听相关
	public static class HfListen {
		public static final String PAGE = "hflisten/hflisten";
		public static final String PAGE_CREAT_BYDAY = "hflisten/hflistenCreatByDay";
		public static final String PAGE_DAY = "hflisten/hflistenDay";
		public static final String PAGE_NEXT_DAY = "hflisten/hflistenNextDay";
		public static final String PAGE_WEEK_DAY = "hflisten/hflistenWeekDay";
		public static final String PAGE_MONTH_DAY = "hflisten/hflistenMonthDay";
		public static final String PAGE_JUMP = "hflisten/hflistenJump";
	}

	// 海风成单相关
	public static class HfSuccessListen {
		public static final String PAGE = "hfsuccess/hfsuccessAll";
		public static final String PAGE_DAY = "hfsuccess/hfsuccessDay";
		public static final String PAGE_WEEK = "hfsuccess/hfsuccessWeek";
		public static final String PAGE_MONTH = "hfsuccess/hfsuccessMonth";
	}

	// 海风成单相关
	public static class HfErrorListen {
		public static final String PAGE = "hferror/hferrorPhone";
		public static final String PAGE_LISTEN = "hferror/hferrorListen";
		public static final String PAGE_NO_LISTEN = "hferror/hferrorNoListen";

	}

	// 海风主页相关
	public static class HfHome {
		public static final String PAGE = "hfhome/hfhome";
	}
}