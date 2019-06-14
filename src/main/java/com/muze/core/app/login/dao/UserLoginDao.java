package com.muze.core.app.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.muze.core.app.login.model.LoginModel;
import com.muze.core.app.login.model.UserModel;


public interface UserLoginDao {
	
	//查询菜单权限信息
	public List<LoginModel> getUserInfo(@Param("userCode") String userCode);
	
	//查询这个用户基本信息
	public UserModel getUser(@Param("userCode") String userCode);
	
	//查询这个用户权限信息
	public List<String> getUserPermissions(@Param("userCode") String userCode);

}
