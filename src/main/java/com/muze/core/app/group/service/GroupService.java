package com.muze.core.app.group.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.CommonDao;
import com.muze.core.app.group.dao.GroupDao;
import com.muze.core.app.group.model.GroupModel;
import com.muze.core.app.utils.RandomIDUtil;

@Service
public class GroupService {

	@Autowired
	CommonDao commonDao;
	
	@Autowired
	GroupDao groupDao;
	
	@Transactional
	public PageList<GroupModel> getGroups(String loginName, PageBounds pageBounds) {

		String org_query_id = commonDao.getUserOrg(loginName);

		return groupDao.getGroups(org_query_id, pageBounds);
	}
	
	@Transactional
	public String addOrSave(Map<String, String> map){
		
		if (map.get("addOrSave").equals("add")) {
			// 添加用户
			String randomId = RandomIDUtil.getRandomID(32);
			map.put("randomId", randomId);
			groupDao.addGroup(map);
			return "addSuccess";
		} else if (map.get("addOrSave").equals("save")) {
			groupDao.updateGroup(map);
			return "updateSuccess";
		}
		return "other";
		
	}
	
	@Transactional
	public void del(String group_id){
		groupDao.delGroupDoc(group_id);
		groupDao.delGroup(group_id);
	}
}
