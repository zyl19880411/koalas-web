package com.muze.core.app.task.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.task.model.TaskModel;

public interface TaskDao {

	public PageList<TaskModel> getTasks(PageBounds pageBounds);
}
