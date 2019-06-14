package com.muze.core.app.role.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.role.model.RoleModel;
import com.muze.core.app.role.model.RolePermissionModel;

public interface RoleDao {

	public PageList<RoleModel> getRoleAll(@Param("org_query_id") String org_query_id, PageBounds pageBounds);
	
	public int addRole(Map<String, String> map);
	
	public int updRole(Map<String, String> map);
	
	public int delRole(@Param("randomId") String randomId); 
	
	public int delRoleDoc(@Param("randomId") String randomId);
	
	public int delRolePermission(@Param("randomId") String randomId);
	
	public List<RolePermissionModel> getRolePermission(@Param("randomId") String randomId);
	
	public int saveRolePermission(@Param("list") List<Map<String, String>> listAll, @Param("roleId") String roleId);
}
