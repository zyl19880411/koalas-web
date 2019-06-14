package com.muze.core.app.task.web;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.muze.core.app.utils.PageURLUtil;

@Controller
@RequestMapping("/TaskTimeController")
public class TaskTimeController {

	// 页面转向
	@RequiresPermissions("erXB5KpUr8RqhYTowymorSqxMnZxzz")
	@RequestMapping("/getPage")
	public String getPage(Map<String, Object> model) {
		return PageURLUtil.taskTime.PAGE;
	}

}
