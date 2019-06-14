package com.muze.core.app.permission.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.muze.core.app.common.dao.CommonDao;
import com.muze.core.app.permission.dao.PermissionDao;
import com.muze.core.app.permission.model.PermissionModel;
import com.muze.core.app.utils.RandomIDUtil;

@Service
public class PermissionService {
	
	@Autowired
	CommonDao commonDao;
	
	@Autowired
	PermissionDao permissionDao;
	
	@Transactional
	public List<PermissionModel> getPermission(String loginName){
		
		String org_id = commonDao.getOrgIdByLoginName(loginName);
		
		return permissionDao.getPermission(org_id);
	}

	@Transactional
	public String addOrsave(Map<String,String> map){
		
		if(map.get("addOrSave").equals("add")){
			
			map.put("randomId",RandomIDUtil.getRandomID(32));
			map.put("perCode",RandomIDUtil.getRandomID(30));
			//获取权限位置
			String elementType = map.get("elementType").toString();
			if(elementType.equals("1")){
				map.put("sort", String.valueOf(permissionDao.getFristPerPosition()));
			}
			else if(elementType.equals("2")){
				int pos = permissionDao.getsecondPerPosition(map);
				if(pos!=-1){
					map.put("sort", String.valueOf(pos));
				}else{
					map.put("sort", String.valueOf(permissionDao.getnullsecondPerPosition(map) + 50));
				}
				
			}
			else if(elementType.equals("3")){
				int pos = permissionDao.getthirdPerPosition(map);
				if(pos!=-1){
					map.put("sort", String.valueOf(pos));
				}
				else{
					map.put("sort", String.valueOf(permissionDao.getnullsecondPerPosition(map) + 1));
				}
				
			}
			//添加权限表
			permissionDao.insertPermission(map);
			
			//添加机构权限表
			map.put("randomOrgPerId",RandomIDUtil.getRandomID(32));
			permissionDao.insertOrgPer(map);
			
			//添加角色权限表
			map.put("randomRolePerId",RandomIDUtil.getRandomID(32));
			permissionDao.insertRolePer(map);

			return "addSuccess";
		}
		else{
			permissionDao.updatePermission(map);
			return "updSuccess";
		}
	}
	
    public  String deletePerrmission(List<String> list){
    	permissionDao.delPermission(list);
    	permissionDao.delOrgPermission(list);
    	permissionDao.delRolePermission(list);
    	return "delSuccess";   	
    }
    
    public List<String> getIcon(PageBounds pageBounds){
    	return permissionDao.getIcon(pageBounds);
    }
	
}
