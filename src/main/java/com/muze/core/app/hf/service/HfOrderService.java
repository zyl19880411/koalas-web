package com.muze.core.app.hf.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.CommonDao;
import com.muze.core.app.common.service.AbstractService;
import com.muze.core.app.hferror.model.HfOrderError;
import com.muze.core.app.hflisten.model.HfListen;
import com.muze.core.app.hforder.dao.HfOrderMapper;
import com.muze.core.app.hforder.model.HfOrder;
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
public class HfOrderService extends AbstractService<HfOrder,Long> {

    @Autowired
    HfOrderMapper hfOrderMapper;

    @Autowired
    CommonDao commonDao;

    @Autowired
    public void setHfOrderMapper(HfOrderMapper hfOrderMapper) {
        super.setBaseDao(hfOrderMapper);
    }


    @Transactional (readOnly = true)
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

        return hfOrderMapper.selectResult(hfOrder,pageBounds);
    }

    @Transactional (readOnly = true)
    public boolean checkExtsis(String code){
         return hfOrderMapper.selectByCode (code)>0;
    }

    @Transactional (readOnly = true)
    public boolean checkExtsisForUpdate(String code,long id){
        return hfOrderMapper.selectByCodeForUpdate (code,id)>0;
    }


    @Transactional
    public int updateOrder(HfOrder hfOrder){
        return hfOrderMapper.updateOrder ( hfOrder );
    }

    @Transactional
    public void delOrder(long id){
        hfOrderMapper.delOrder(id);
        hfOrderMapper.delErrOrder(id);
        hfOrderMapper.dellistenerOrder(id);
        hfOrderMapper.delsuccessOrder(id);
    }

    @Transactional
    public void OrderListen(HfListen hfListen){
        //主表改成试听
        hfOrderMapper.updateOrder2Lis (hfListen.getOrderId ());
        //试听表添加
        hfOrderMapper.insertOrderLinsten (hfListen);
    }

    @Transactional
    public String OrderSuccess(HfSuccess hfSuccess){

        //检验单号是否重复
        if(hfOrderMapper.checkSuccesContract(hfSuccess.getContractNumbe())>0){
            return "successContains";
        }

        //主表改成试听
        hfOrderMapper.updateOrder2success ( hfSuccess.getOrderId () );
        //成单表添加
        hfOrderMapper.insertOrderSuceess ( hfSuccess );

        return "addSuccess";
    }

    @Transactional
    public void Orderintroduction(HfOrder hfOrder){
          hfOrderMapper.updateOrderintroduction(hfOrder);
     }

    @Transactional
    public void OrderError(HfOrderError hfOrderError){
        hfOrderMapper.updateOrderError(hfOrderError);
        hfOrderMapper.insertOrderError(hfOrderError);
    }
}
