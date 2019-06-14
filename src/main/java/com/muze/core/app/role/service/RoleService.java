package com.muze.core.app.role.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.CommonDao;
import com.muze.core.app.role.dao.RoleDao;
import com.muze.core.app.role.model.RoleModel;
import com.muze.core.app.role.model.RolePermissionModel;
import com.muze.core.app.utils.RandomIDUtil;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	CommonDao commonDao;
	
	@Transactional
	public PageList<RoleModel> getRoles(String loginName, PageBounds pageBounds) {

		String org_query_id = commonDao.getUserOrg(loginName);

		return roleDao.getRoleAll(org_query_id, pageBounds);
	}
	
	@Transactional
	public PageList<RoleModel> addRoles(String loginName, PageBounds pageBounds) {

		String org_query_id = commonDao.getUserOrg(loginName);

		return roleDao.getRoleAll(org_query_id, pageBounds);
	}
	
	@Transactional
	public String addORSaveRole(Map<String, String> map) {

		if (map.get("addOrSave").equals("add")) {
			// 添加用户
			String randomId = RandomIDUtil.getRandomID(32);
			map.put("randomId", randomId);
			roleDao.addRole(map);
			return "addSuccess";
		} else if (map.get("addOrSave").equals("save")) {
			roleDao.updRole(map);
			return "updateSuccess";
		}
		return "other";
	}
	
	@Transactional
	public String delRole(String randomId){
		roleDao.delRole(randomId);
		roleDao.delRoleDoc(randomId);
		roleDao.delRolePermission(randomId);
		return "success";
	}
	
	@Transactional
	public List<RolePermissionModel> getRolePermission(String randomId){
		return roleDao.getRolePermission(randomId);
	}
	
	@Transactional
	public void saveRolePermission(List<String> list,String roleId){
		roleDao.delRolePermission(roleId);
		if(list.size() >0){
			
			List<Map<String,String>> listAll = new ArrayList<Map<String,String>>();
 
		    for (int i = 0; i < list.size(); i++) {
		    	Map<String,String> map = new HashMap<String, String>();
		    	map.put("RandomId", RandomIDUtil.getRandomID(32));
		    	map.put("PerMissionId",list.get(i));
		    	listAll.add(map);
			}
			
			roleDao.saveRolePermission(listAll,roleId);
		}
		
	}

}
