package com.muze.core.app.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muze.core.app.common.dao.CommonDao;

@Service
public class CommonService {

	@Autowired
	private CommonDao commonDao;
	
	public List<Map<String, String>> getbtnPermission(String parent_id) {
		return commonDao.getbtnPermission(parent_id);
	}

}
