package com.muze.core.app.hfsucess.dao;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.BaseDao;
import com.muze.core.app.hflisten.model.HfListen;
import com.muze.core.app.hforder.model.HfOrder;
import com.muze.core.app.hfsucess.model.HfSuccess;

public interface HfSuccessMapper extends BaseDao<HfSuccess,Long> {

    public PageList<HfSuccess> selectResult(HfOrder request, PageBounds pageBounds);

}