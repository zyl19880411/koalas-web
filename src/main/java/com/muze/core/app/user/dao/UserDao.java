package com.muze.core.app.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.user.model.UserGroupsModel;
import com.muze.core.app.user.model.UserModel;
import com.muze.core.app.user.model.UserRolesModel;

public interface UserDao {

	public PageList<UserModel> getUserAll(@Param("doc_name") String userName, @Param("tel") String tel, @Param("org_query_id") String org_query_id, PageBounds pageBounds);
	
	public int addUser(Map<String, String> map);

	public int add_org_user(Map<String, String> map);
	
	public int getDocCount(@Param("random_ID") String random_ID);
	
	public int getDoc_Org_count(@Param("random_ID") String random_ID);
	
	public int getLoginCount(@Param("permissionLoginName") String loginName);

	public int updUser(Map<String, String> map);
	
	public int delUser(@Param("random_ID") String random_ID);
	
	public int del_org_user(@Param("random_ID") String random_ID);
	
	public int del_role_user(@Param("random_ID") String random_ID);
	
	public int del_group_user(@Param("random_ID") String random_ID);

	public PageList<Map<String,String>> get_user_roles(@Param("random_ID") String random_ID, PageBounds pageBounds);
	
	public int saveUserRoles(@Param("list") List<UserRolesModel> list);
	
	public PageList<Map<String,String>> get_user_groups(@Param("random_ID") String random_ID, PageBounds pageBounds);

	public int saveUserGroups(@Param("list") List<UserGroupsModel> list);
	
    public int del_group_user_forupdate(@Param("random_ID") String random_ID, @Param("all") List<UserGroupsModel> list);
	
	public int del_role_user_forupdate(@Param("random_ID") String random_ID, @Param("all") List<UserRolesModel> list);
}
