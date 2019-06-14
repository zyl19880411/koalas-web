package com.muze.core.app.hferror.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.BaseDao;
import com.muze.core.app.hferror.model.HfOrderError;
import com.muze.core.app.hforder.model.HfOrder;

public interface HfOrderErrorMapper extends BaseDao<HfOrderError,Long> {

    public PageList<HfOrder> selectResult(HfOrder request, PageBounds pageBounds);

}