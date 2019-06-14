package com.muze.core.app.org.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.muze.core.app.org.model.OrgModel;
import com.muze.core.app.org.model.OrgPermissionModel;

public interface OrgDao {
	
	public List<OrgModel> getOrg(@Param("org_query_id") String org_query_id, @Param("org_id") String org_id);

	public int insertOrg(Map<String, String> map);
	
	public int updOrg(Map<String, String> map);
	
	public List<String> getChildOrgId(@Param("org_query_id") String org_query_id);
	
	public List<String> selectDelGroup(@Param("list") List<String> org_id);
	
	public int delGroup(@Param("list") List<String> org_id);

	public int delDocGroup(@Param("list") List<String> group_id);

	public List<String> selectDelDoc(@Param("list") List<String> org_id);
	
	public int delDoc(@Param("list") List<String> doc_id);
	
	public int delDocRole(@Param("list") List<String> doc_id);
	
	public int delDocOrg(@Param("list") List<String> doc_id);
	
	public List<String> selectDelRole(@Param("list") List<String> org_id);
	
    public int delRole(@Param("list") List<String> org_id);
	
	public int delRolePerrmission(@Param("list") List<String> role_id);
	
	public int delOrgPerrmission(@Param("list") List<String> org_id);
	
	public int delOrg(@Param("org_query_id") String org_query_id);
	
	public List<OrgPermissionModel> getOrgPerrmission(@Param("parentID") String parentID, @Param("org_id") String org_id);
	
	public int setOrgPerrmission(@Param("org_id") String org_id);
	
	public int saveOrgPerrmisssion(List<Map<String, String>> insertList);
	
	public int setChildOrgPerrmission(@Param("org_id") String org_id, @Param("list") List<String> perrmission_ID);
	
	public List<String> getRoleByOrgID(@Param("org_id") String org_id);
	
	public int setChildRolePerrmission(@Param("role_id") String role_id, @Param("list") List<String> perrmission_ID);
	
	public int setRolePerrmission(@Param("role_id") String role_id);
}
