package com.muze.core.app.org.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muze.core.app.common.dao.CommonDao;
import com.muze.core.app.org.dao.OrgDao;
import com.muze.core.app.org.model.OrgModel;
import com.muze.core.app.org.model.OrgPermissionModel;
import com.muze.core.app.utils.RandomIDUtil;

@Service
public class OrgService {

	@Autowired
	private OrgDao orgDao;

	@Autowired
	CommonDao commonDao;

	@Transactional
	public List<OrgModel> getOrg(String loginName) {

		String org_query_id = commonDao.getUserOrg(loginName);
        String org_id = commonDao.getOrgIdByLoginName(loginName);
		return orgDao.getOrg(org_query_id, org_id);
	}

	@Transactional
	public String addORSaveUser(Map<String, String> map) {

		if (map.get("addOrSave").equals("add")) {
			String queryID;
			while (commonDao.getOrgQueryIDcount(queryID = (commonDao
					.getQueryIdByOrgId(map.get("parentid")) + RandomIDUtil
					.getRandomID(3))) == 0) {
				map.put("id", RandomIDUtil.getRandomID(32));
				map.put("queryID",queryID);
				orgDao.insertOrg(map);
				break;
			}
			return "addSuccess";
		}
		else{
			orgDao.updOrg(map);
			return "updSuccess";
		}
	}
	
	@Transactional
	public void delOrg(String org_id){
		String query_id = commonDao.getQueryIdByOrgId(org_id);
		List<String> _org_id = orgDao.getChildOrgId(query_id);

		//查询查询机构下的团队ID
		List<String> _group_id = orgDao.selectDelGroup(_org_id);
		
		//删除团队用户
		if(_group_id.size()>0)
		orgDao.delDocGroup(_group_id);
		
		//删除团队
		orgDao.delGroup(_org_id);
		
		//查询机构下所有用户ID
		List<String> _doc_id = orgDao.selectDelDoc(_org_id);
		
		//删除用户表
		if(_doc_id.size()>0)
		orgDao.delDoc(_doc_id);
		
		//删除用户角色表
		if(_doc_id.size()>0)
		orgDao.delDocRole(_doc_id);
		
		//删除用户机构表
		if(_doc_id.size()>0)
		orgDao.delDocOrg(_doc_id);
		
		//查询机构下的角色ID
		List<String> _role_id = orgDao.selectDelRole(_org_id);
		
		//删除角色表
		orgDao.delRole(_org_id);
		
		//删除角色权限表
		if(_role_id.size()>0)
		orgDao.delRolePerrmission(_role_id);
		
		//删除权限机构表
		orgDao.delOrgPerrmission(_org_id);
		
		//删除机构表
		orgDao.delOrg(query_id);
	}
	
	@Transactional
	public List<OrgPermissionModel> getOrgPerrmission(String org_id,String parentID){
		
		return orgDao.getOrgPerrmission(parentID, org_id);
	}
	
	@Transactional
	public void saveOrgPerrmission(String org_id,List<String> list){
		
		//当前机构处理
		List<Map<String,String>> insertList = new ArrayList<Map<String,String>>();
		orgDao.setOrgPerrmission(org_id);
		for(String orgPer:list){
			Map<String,String> insertMap = new HashMap<String, String>();
			insertMap.put("org_id", org_id);
			insertMap.put("perrmission_id", orgPer);
			insertMap.put("id",RandomIDUtil.getRandomID(32));
			insertList.add(insertMap);
		}
		if(insertList.size()>0)
		orgDao.saveOrgPerrmisssion(insertList);
		
		//子机构处理
		String query_id = commonDao.getQueryIdByOrgId(org_id);
		List<String> listChildOrgId = orgDao.getChildOrgId(query_id);
		
		//轮循子机构
		for(String childOrgId:listChildOrgId){
			if(!childOrgId.equals(org_id)){
				//删除父机构删除了的，但是子机构存在权限
				
				//当父机构清空时,同时清空子机构
				if(list.size()==0){
					orgDao.setOrgPerrmission(childOrgId);
				} else{
					orgDao.setChildOrgPerrmission(childOrgId, list);
				}
			}
			
			//查询机构对应的角色
			List<String> roleList = orgDao.getRoleByOrgID(childOrgId);
			
			for(String role_id:roleList){
				if(list.size()==0){
					orgDao.setRolePerrmission(role_id);
				}else{
					orgDao.setChildRolePerrmission(role_id, list);
				}
			}
		}
	}
}
