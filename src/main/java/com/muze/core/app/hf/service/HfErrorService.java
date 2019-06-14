package com.muze.core.app.hf.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.CommonDao;
import com.muze.core.app.common.service.AbstractService;
import com.muze.core.app.hferror.model.HfOrderError;
import com.muze.core.app.hforder.model.HfOrder;
import com.muze.core.app.login.model.UserModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import  com.muze.core.app.hferror.dao.HfOrderErrorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HfErrorService extends AbstractService<HfOrderError,Long> {

    @Autowired
    HfOrderErrorMapper HfOrderErrorMapper;

    @Autowired
    CommonDao commonDao;

    @Autowired
    public void setHfOrderErrorMapper(HfOrderErrorMapper hfOrderErrorMapper) {
       super.setBaseDao(hfOrderErrorMapper);
    }

    @Transactional(readOnly = true)
    public PageList<HfOrder> selectResult(HfOrder hfOrder, PageBounds pageBounds) {
        Session session =SecurityUtils.getSubject().getSession();
        UserModel userDto = (UserModel) session.getAttribute("user");

        String docid = userDto.getId();
        String quertID = commonDao.getQueryIdByDocId(docid);

        List<String> list = new ArrayList<>();
        if("n".equals(hfOrder.getHforderisme())){
            list=commonDao.getDocIdListByQueryId(quertID);
        }
        list.add(docid);
        hfOrder.setDocids(list);

        return HfOrderErrorMapper.selectResult(hfOrder,pageBounds);
    }
}
