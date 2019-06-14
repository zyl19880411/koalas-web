package com.muze.core.app.common.dao;

import java.io.Serializable;

public interface BaseDao<T, ID extends Serializable> {
	
	int deleteByPrimaryKey(ID id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKeyWithBLOBs(T record);

	int updateByPrimaryKey(T record);
	
}
