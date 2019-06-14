package com.muze.core.app.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muze.core.app.login.dao.UserLoginDao;
import com.muze.core.app.login.model.LoginModel;
import com.muze.core.app.login.model.UserModel;

@Service
public class UserLoginService {

	@Autowired
	private UserLoginDao uploadDataPersistence;

	// 菜单栏权限信息查询
	public List<LoginModel> getUserInfo(String userCode) {
		return uploadDataPersistence.getUserInfo(userCode);
	}

	// 查询这个用户基本信息
	public UserModel getUser(String userCode) {
		return uploadDataPersistence.getUser(userCode);
	}

	// 查询这个用户权限信息
	public List<String> getUserPermissions(String userCode) {
		return uploadDataPersistence.getUserPermissions(userCode);
	}

}
