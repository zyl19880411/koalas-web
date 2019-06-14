package com.muze.core.app.task.service;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.task.dao.TaskDao;
import com.muze.core.app.task.model.TaskModel;
import com.muze.core.app.utils.ConstantUtil;

@Service
public class TaskService {
	
	@Autowired
	private Scheduler scheduler;
	
	@Autowired
	private TaskDao taskDao;
	
	@Transactional(readOnly=true)
	public PageList<TaskModel> getTasks(PageBounds pageBounds) {
          return taskDao.getTasks(pageBounds);
	}
	
	public String add(TaskModel taskModel){
		
		@SuppressWarnings("rawtypes")
		Class job = null;
		try {
			job = Class.forName(taskModel.getTask_url());
		} catch (ClassNotFoundException e1) {
			return "notexists";
		}
		
		if(!AbstractJob.class.isAssignableFrom(job)){
			return "typeError";
		}

		@SuppressWarnings("unchecked")
		JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(taskModel.getTask_id(), ConstantUtil.TASK_GROUP).withDescription(taskModel.getTask_name()).build();
		jobDetail.getJobDataMap().put("task", taskModel);
 
		//表达式调度构建器（可判断创建SimpleScheduleBuilder）
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskModel.getTask_expression());
		
		//按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(taskModel.getTask_id(), ConstantUtil.TASK_GROUP).withSchedule(scheduleBuilder).withDescription(taskModel.getTask_name()).build();
		try {
			
			if(scheduler.checkExists(JobKey.jobKey(taskModel.getTask_id(), ConstantUtil.TASK_GROUP))){
				return "Jobexists";
			}
			if(scheduler.checkExists(TriggerKey.triggerKey(taskModel.getTask_id(), ConstantUtil.TASK_GROUP))){
				return "Triggerexists";
			}
			scheduler.scheduleJob(jobDetail, trigger);
 
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 修改触发器时间
	 * @param name 任务名
	 * @param group 任务组
	 * @param cron cron表达式
	 */
	public String modifyTrigger(String name,String cron){
		try {  
            TriggerKey key = TriggerKey.triggerKey(name, ConstantUtil.TASK_GROUP);  
            //Trigger trigger = scheduler.getTrigger(key);  
              
            CronTrigger newTrigger = (CronTrigger) TriggerBuilder.newTrigger()  
                    .withIdentity(key)  
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))  
                    .build();
            scheduler.rescheduleJob(key, newTrigger); 
            return "success";
        } catch (SchedulerException e) {  
        	return "error";
        }  
		
	}
	
	/**
	 * 暂停任务
	 * @param name 任务名
	 * @param group 任务组
	 */
	public void stopJob(String name){
		JobKey key = new JobKey(name, ConstantUtil.TASK_GROUP);
		try {
			scheduler.pauseJob(key);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 恢复任务
	 * @param name 任务名
	 * @param group 任务组
	 */
	public void restartJob(String name){
		JobKey key = new JobKey(name,ConstantUtil.TASK_GROUP);
		try {
			scheduler.resumeJob(key);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 立马执行一次任务
	 * @param name 任务名
	 * @param group 任务组
	 */
	public void startNowJob(String name){
		JobKey jobKey = JobKey.jobKey(name, ConstantUtil.TASK_GROUP);
		try {
			scheduler.triggerJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除任务
	 * @param name 任务名
	 * @param group 任务组
	 */
	public void delJob(String name){
		JobKey key = new JobKey(name,ConstantUtil.TASK_GROUP);
		try {
			scheduler.deleteJob(key);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
