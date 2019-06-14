package com.muze.core.app.task.dao;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.BaseDao;
import com.muze.core.app.task.model.QuartzLogModel;
import com.muze.core.app.task.model.TaskModel;


public interface TaskLogDao extends BaseDao<QuartzLogModel, Integer>{

	public int insertBefore(@Param("taskModel") TaskModel taskModel);
	
	public int updateAfter(@Param("taskModel") TaskModel taskModel, @Param("task_result") String task_result, @Param("task_running_message") String task_running_message);

	public PageList<QuartzLogModel> getAllTaskLogs(PageBounds pageBounds);

}
