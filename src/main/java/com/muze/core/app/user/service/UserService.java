package com.muze.core.app.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.CommonDao;
import com.muze.core.app.user.dao.UserDao;
import com.muze.core.app.user.model.UserGroupsModel;
import com.muze.core.app.user.model.UserModel;
import com.muze.core.app.user.model.UserRolesModel;
import com.muze.core.app.utils.Encodes;
import com.muze.core.app.utils.RandomIDUtil;

@Service
public class UserService {

	@Autowired
	UserDao userPersistence;

	@Autowired
	CommonDao commonDao;

	@Transactional
	public PageList<UserModel> getUser(String userName, String tel,
			String loginName, PageBounds pageBounds) {

		String org_query_id = commonDao.getUserOrg(loginName);

		return userPersistence.getUserAll(userName, tel, org_query_id,
				pageBounds);
	}

	public List<Map<String, String>> getOrg(String loginName) {
		String org_query_id = commonDao.getUserOrg(loginName);

		return commonDao.getOrg(org_query_id);
	}

	@Transactional
	public String addORSaveUser(Map<String, String> map) {

		String passWord = map.get("permissionPassword").toString();
		try {
			map.put("permissionPassword", Encodes.encode(passWord));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (map.get("addOrSave").equals("userAdd")) {
			// 判断登录名是否已经使用
			if (userPersistence.getLoginCount(map.get("permissionLoginName")) != 0) {
				return "addContains";
			}

			// 添加用户
			String randomID = RandomIDUtil.getRandomID(32);

			while (userPersistence.getDocCount(randomID) != 0) {
				randomID = RandomIDUtil.getRandomID(32);
			}
			map.put("randomID", randomID);
			userPersistence.addUser(map);

			// 添加用户机构关联信息
			String random_ORG_DOC = RandomIDUtil.getRandomID(32);
			while (userPersistence.getDoc_Org_count(random_ORG_DOC) != 0) {
				random_ORG_DOC = RandomIDUtil.getRandomID(32);
			}
			map.put("random_ORG_DOC", random_ORG_DOC);
			userPersistence.add_org_user(map);
			return "addSuccess";
		} else if (map.get("addOrSave").equals("userUpd")) {
			userPersistence.updUser(map);
			return "updateSuccess";
		}
		return "other";
	}

	// 删除用户
	@Transactional
	public String delUser(String randomId) {
		userPersistence.delUser(randomId);
		userPersistence.del_group_user(randomId);
		userPersistence.del_org_user(randomId);
		userPersistence.del_role_user(randomId);
		return "success";
	}

	// 用户角色
	@Transactional
	public PageList<Map<String, String>> userRoles(String randomId,
			PageBounds pageBounds) {
		return userPersistence.get_user_roles(randomId, pageBounds);
	}

	// 用户角色添加
	@Transactional
	public void saveUserRoles(Map<String, List<UserRolesModel>> map,
			String doc_id) {
		// 先删除角色权限
		if (map.get("all").size() != 0) {
			userPersistence.del_role_user_forupdate(doc_id, map.get("all"));
		}

		// 添加角色权限
		if (map.get("rows").size() != 0) {
			userPersistence.saveUserRoles(map.get("rows"));
		}
	}

	// 用户团队
	@Transactional
	public PageList<Map<String, String>> userGroups(String randomId,
			PageBounds pageBounds) {
		return userPersistence.get_user_groups(randomId, pageBounds);
	}

	// 用户团队添加
	@Transactional
	public void saveUserGroups(Map<String, List<UserGroupsModel>> map,
			String doc_id) {

		// 先删除角色权限
		if (map.get("all").size() != 0)
			userPersistence.del_group_user_forupdate(doc_id, map.get("all"));
		// 添加角色权限
		if (map.get("rows").size() != 0) {
			userPersistence.saveUserGroups(map.get("rows"));
		}
	}

}
