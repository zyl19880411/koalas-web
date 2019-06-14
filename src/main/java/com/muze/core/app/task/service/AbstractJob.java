package com.muze.core.app.task.service;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.muze.core.app.common.service.SpringContextUtil;
import com.muze.core.app.task.model.TaskModel;

public abstract class AbstractJob implements Job{

	@Override
	public void execute(JobExecutionContext jobexecutioncontext)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		
		TaskModel taskModel = (TaskModel) jobexecutioncontext.getJobDetail().getJobDataMap().get("task");
		TaskLogService taskLogService = SpringContextUtil.getBean("taskLogService");
		taskLogService.before(taskModel);
		
		try {
			doJob();
			taskLogService.after(taskModel, "1","Sueecss");
		} catch (Exception e) {
			StringWriter sw = new StringWriter();  
            PrintWriter pw = new PrintWriter(sw);  
            e.printStackTrace(pw); 
			taskLogService.after(taskModel, "0",sw.toString());
		}
	}
	
	public abstract void doJob() throws Exception;

}
