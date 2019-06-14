package com.muze.core.app.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.service.AbstractService;
import com.muze.core.app.task.dao.TaskLogDao;
import com.muze.core.app.task.model.QuartzLogModel;
import com.muze.core.app.task.model.TaskModel;

@Service
public class TaskLogService extends AbstractService<QuartzLogModel, Integer> {

	@Autowired
	TaskLogDao taskLogDao;

	@Autowired
	public void setTaskLogDao(TaskLogDao taskLogDao) {
		super.setBaseDao(taskLogDao);
	}

	@Transactional
	public void before(TaskModel taskModel) {
		taskLogDao.insertBefore(taskModel);
	}

	@Transactional
	public void after(TaskModel taskModel, String flag, String message) {
		taskLogDao.updateAfter(taskModel, flag, message);
	}
	
	@Transactional(readOnly=true)
	public PageList<QuartzLogModel> getAllTaskLogs(PageBounds pageBounds) {
          return taskLogDao.getAllTaskLogs(pageBounds);
	}

}
