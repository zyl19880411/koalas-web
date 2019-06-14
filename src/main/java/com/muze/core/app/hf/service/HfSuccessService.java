package com.muze.core.app.hf.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.CommonDao;
import com.muze.core.app.common.service.AbstractService;
import com.muze.core.app.hforder.model.HfOrder;
import com.muze.core.app.hfsucess.dao.HfSuccessMapper;
import com.muze.core.app.hfsucess.model.HfSuccess;
import com.muze.core.app.login.model.UserModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HfSuccessService extends AbstractService<HfSuccess,Long> {


    @Autowired
    HfSuccessMapper hfSuccessMapper;

    @Autowired
    CommonDao commonDao;

    @Autowired
    public void setHfSuccessMapper(HfSuccessMapper hfSuccessMapper) {
        super.setBaseDao(hfSuccessMapper);
    }

    @Transactional(readOnly = true)
    public PageList<HfSuccess> selectResult(HfOrder hfOrder, PageBounds pageBounds) {
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

        return hfSuccessMapper.selectResult(hfOrder,pageBounds);
    }

}
