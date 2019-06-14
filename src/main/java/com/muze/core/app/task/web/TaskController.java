package com.muze.core.app.task.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.CronExpression;
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
import com.muze.core.app.task.model.TaskModel;
import com.muze.core.app.task.service.TaskService;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.RandomIDUtil;

@Controller
@RequestMapping("/TaskController")
public class TaskController extends BaseController{

	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;
	
	@Autowired
	private TaskService taskService;
	
	// 页面转向
	@RequiresPermissions("ZJC6uZIVuDmc302fEOD52vTcKjrPFx")
	@RequestMapping("/getPage")
	public String getPage(Map<String, Object> model) {
		List<Map<String, String>> list = commonService.getbtnPermission(BtnPermissionUtil.Task.PAGE);
		model.put("list", list);
		return PageURLUtil.task.PAGE;
	}
	
	// 定时任务查询
	@RequiresPermissions("pSEjPU8BDmNUcxQ2eO7BmyQiqEwGW5")
	@RequestMapping("/getTasks")
	@ResponseBody
	public String getTasks(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {

		PageBounds pageBounds = new PageBounds(Integer.parseInt(request
				.getParameter("page")), Integer.parseInt(request
				.getParameter("rows")));

		PageList<TaskModel> list = taskService.getTasks(pageBounds);
		JSONObject json = new JSONObject();

		json.put("total", list.getPaginator().getTotalCount());
		json.put("rows", list);

		return json.toString();
	}

	//添加页面转向
	@RequiresPermissions("v3nktKBz7VBOeeJkjOIsO3gy2XGDrw")
	@RequestMapping("/addReturn")
	public String addReturn(Map<String, Object> model) {
		return PageURLUtil.task.ADD;
	}

	//添加功能
	@RequiresPermissions("v3nktKBz7VBOeeJkjOIsO3gy2XGDrw")
	@RequestMapping("/add")
	@ResponseBody
	public String add(Map<String, Object> model, HttpServletRequest request,HttpServletResponse response,TaskModel taskModel) {
		taskModel.setTask_id(RandomIDUtil.getRandomID(32));
		return taskService.add(taskModel);

	}

	//修改功能
	@RequiresPermissions("UG200PZbtzbyR1rnvKYpTCwfNuNSyA")
	@RequestMapping("/upd")
	@ResponseBody
	public String upd(Map<String, Object> model, HttpServletRequest request,HttpServletResponse response,@RequestParam("task_id") String task_id,@RequestParam("cronExpression") String cronExpression) {
		if(!CronExpression.isValidExpression(cronExpression)){
			return "expressionerror";
		}
		return taskService.modifyTrigger(task_id, cronExpression);
	}
	
	//暂停功能
	@RequiresPermissions("nDDJ1ShBZXcZgELrwZmBPrV5xzKVi1")
	@RequestMapping("/pause")
	@ResponseBody
	public String pause(Map<String, Object> model, HttpServletRequest request,HttpServletResponse response,@RequestParam("task_id") String task_id) {
		taskService.stopJob(task_id);
        return "success";
	}
	
	//恢复功能
	@RequiresPermissions("nhaFOnZOwgfZZB42SL003Z1q5MzAMQ")
	@RequestMapping("/resume")
	@ResponseBody
	public String resume(Map<String, Object> model, HttpServletRequest request,HttpServletResponse response,@RequestParam("task_id") String task_id) {
		taskService.restartJob(task_id);
        return "success";
	}
	
	//执行一次
	@RequiresPermissions("RG8dznqVWmTagRqVdYhESy7sWphmbL")
	@RequestMapping("/startOne")
	@ResponseBody
	public String startOne(Map<String, Object> model, HttpServletRequest request,HttpServletResponse response,@RequestParam("task_id") String task_id) {
		taskService.startNowJob(task_id);
        return "success";
	}
	
	//删除
	@RequiresPermissions("C6vRbdgEqTEK7EEtUWVd8RL707QxJW")
	@RequestMapping("/del")
	@ResponseBody
	public String del(Map<String, Object> model, HttpServletRequest request,HttpServletResponse response,@RequestParam("task_id") String task_id) {
		taskService.delJob(task_id);
        return "success";
	}

}
