package com.muze.core.app.group.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.group.model.GroupModel;

public interface GroupDao{
	
	public PageList<GroupModel> getGroups(@Param("org_query_id") String org_query_id, PageBounds pageBounds);
	
	public int addGroup(Map<String, String> map);
	
	public int updateGroup(Map<String, String> map);
 
	public int delGroupDoc(String group_id);
	
	public int delGroup(String group_id);
}
