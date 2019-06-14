package com.muze.core.app.task.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.task.model.QuartzLogModel;
import com.muze.core.app.task.service.TaskLogService;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.PageURLUtil;

@Controller
@RequestMapping("/TaskLogController")
public class TaskLogController extends BaseController{

	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;
	
	@Autowired
	private TaskLogService taskLogService;
	
	// 页面转向
	@RequiresPermissions("6BaW3y0Rrhdzhgu3v0By5YNQFRJbGL")
	@RequestMapping("/getPage")
	public String getPage(Map<String, Object> model) {
		List<Map<String, String>> list = commonService.getbtnPermission(BtnPermissionUtil.Task.LOG_PAGE);
		model.put("list", list);
		return PageURLUtil.taskLog.PAGE;
	}
	
	// 日志查询
	@RequiresPermissions("YvnGzo6dzDpF7jVdhxqWQpt1dj0KMQ")
	@RequestMapping("/getAllTaskLog")
	@ResponseBody
	public String getAllTaskLog(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {

		PageBounds pageBounds = new PageBounds(Integer.parseInt(request
				.getParameter("page")), Integer.parseInt(request
				.getParameter("rows")));

		PageList<QuartzLogModel> list = taskLogService.getAllTaskLogs(pageBounds);
		JSONObject json = new JSONObject();

		json.put("total", list.getPaginator().getTotalCount());
		json.put("rows", list);

		return json.toString();
	}

}
