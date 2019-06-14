package com.muze.core.app.permission.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.muze.core.app.permission.model.PermissionModel;

public interface PermissionDao {

	public List<PermissionModel> getPermission(@Param("org_id") String org_id);
	
	public int insertPermission(Map<String, String> map);
	
	public int insertOrgPer(Map<String, String> map);
	
	public int insertRolePer(Map<String, String> map);
	
	public int getFristPerPosition();
	
	public int getsecondPerPosition(Map<String, String> map);
	
	public int getthirdPerPosition(Map<String, String> map);
	
	public int getnullsecondPerPosition(Map<String, String> map);
	
	public int updatePermission(Map<String, String> map);
	
	public int delPermission(@Param("list") List<String> list);
	
	public int delOrgPermission(@Param("list") List<String> list);
	
	public int delRolePermission(@Param("list") List<String> list);
	
	public List<String> getIcon(PageBounds pageBounds);
}
