package com.muze.core.app.common.service;

import java.io.Serializable;

import com.muze.core.app.common.dao.BaseDao;

public abstract class AbstractService<T, ID extends Serializable> implements BaseService<T, ID> {

	public BaseDao<T, ID> d;
	
	public void setBaseDao(BaseDao<T, ID> d){
		this.d = d;
	}

	public int deleteByPrimaryKey(ID id){
		return d.deleteByPrimaryKey(id);
	}

	public  int insert(T record){
		return d.insert(record);
	}

	public int insertSelective(T record){
		return d.insertSelective(record);
	}

	public  T selectByPrimaryKey(ID id){
		return d.selectByPrimaryKey(id);
	}

	public  int updateByPrimaryKeySelective(T record){
		return d.updateByPrimaryKeySelective(record);
	}
	
	public  int updateByPrimaryKeyWithBLOBs(T record){
		return d.updateByPrimaryKeyWithBLOBs(record);
	}
	
	public  int updateByPrimaryKey(T record){
		return d.updateByPrimaryKey(record);
	}

}
