package com.muze.core.app.hf.web;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.hf.service.HfSuccessService;
import com.muze.core.app.hforder.model.HfOrder;
import com.muze.core.app.hfsucess.model.HfSuccess;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * *********************基本信息说明********************************
 * 类名        :HfOrderController.java
 * 项目名称 :com.muze.core.app.hf.web
 * 类说明     :海丰教育成单页面操作
 * 创建时间 :2018年6月18日21:16:32
 * 作         者:张玉龙
 * 版         本:v1
 */
@Controller
@RequestMapping("/success")
public class HfOrderSuccessController extends BaseController {

    @Autowired
    @Qualifier("commonService")
    private CommonService commonService;

    @Autowired
    private HfSuccessService hfSuccessService;

    @RequiresPermissions("0VKIhs4xjiGISsEh23tYTr66vbAuV5")
    @RequestMapping("/all")
    public String getPage(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrderSuccess.PAGE);
        model.put("list", list);
        return PageURLUtil.HfSuccessListen.PAGE;
    }

    @RequiresPermissions("JajayAP2guEdZfvb7xZjGUDp8Izz6E")
    @RequestMapping("/now")
    public String now(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrderSuccess.PAGE_DAY);
        model.put("list", list);
        return PageURLUtil.HfSuccessListen.PAGE_DAY;
    }

    @RequiresPermissions("iHOcp7UkhNonuuWDLylF16eT8rdPur")
    @RequestMapping("/currweak")
    public String currweak(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrderSuccess.PAGE_WEEK);
        model.put("list", list);
        return PageURLUtil.HfSuccessListen.PAGE_WEEK;
    }


    @RequiresPermissions("QqD5yzNEobuxvTs4TIG4snVM630WHq")
    @RequestMapping("/currmonth")
    public String currmonth(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrderSuccess.PAGE_MONTH);
        model.put("list", list);
        return PageURLUtil.HfSuccessListen.PAGE_MONTH;
    }


    @RequiresPermissions("ON4vtmTRSmLavrux1CxcIAlEIN3Lg8")
    @RequestMapping("/getSuccessAll")
    @ResponseBody
    public String getSuccessAll(HfOrder hfOrder,HttpServletRequest request) {
        return getOrder(hfOrder, request);
    }

    @RequiresPermissions("ZST3iiSBiAZYbSif1AqafxSx7qhbPl")
    @RequestMapping("/getSuccessDay")
    @ResponseBody
    public String getSuccessDay(HfOrder hfOrder,HttpServletRequest request) {
        return getOrder(hfOrder, request);
    }

    @RequiresPermissions("XmMByrXTH2au3InrRZeiFO6NJWCSki")
    @RequestMapping("/getSuccessWeek")
    @ResponseBody
    public String getSuccessWeek(HfOrder hfOrder,HttpServletRequest request) {
        return getOrder(hfOrder, request);
    }

    @RequiresPermissions("3B5me5VQZM2YmTaWlZvMf8DMD3kqqp")
    @RequestMapping("/getSuccessMonth")
    @ResponseBody
    public String getSuccessMonth(HfOrder hfOrder,HttpServletRequest request) {
        return getOrder(hfOrder, request);
    }

    private String getOrder(HfOrder hfOrder, HttpServletRequest request) {
        PageBounds pageBounds = new PageBounds(Integer.parseInt(request
                .getParameter("page")), Integer.parseInt(request
                .getParameter("rows")));

        PageList<HfSuccess> list = hfSuccessService.selectResult(hfOrder,pageBounds);
        JSONObject json = new JSONObject();

        json.put("total", list.getPaginator().getTotalCount());
        json.put("rows", list);
        return json.toString();
    }

    @RequiresPermissions("fkL5SsC6zeinjTilggKibfD4q0WVEl")
    @RequestMapping("/exportSuccessAll")
    public void exportSuccessAll(HfOrder hfOrder,
                                  HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"全部成单数据");
    }

    @RequiresPermissions("EbhaN2o0ErW5XqIPkqioCAKAltVAb4")
    @RequestMapping("/exportSuccessDay")
    public void exportSuccessDay(HfOrder hfOrder,
                                 HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"当日成单数据");
    }

    @RequiresPermissions("1ZLRFtJOXluXbzh3PUgJdVIRK8eqnh")
    @RequestMapping("/exportSuccessWeek")
    public void exportSuccessWeek(HfOrder hfOrder,
                                 HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"本周成单数据");
    }

    @RequiresPermissions("0TvGuHIEGE23SUVPjTqD1qLTHDKRXq")
    @RequestMapping("/exportSuccessMonth")
    public void exportSuccessMonth(HfOrder hfOrder,
                                  HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"本月成单数据");
    }

    private void export(HfOrder hfOrder, HttpServletResponse respone,String title) throws IOException {
        PageBounds pageBounds = new PageBounds(1,Integer.MAX_VALUE);
        PageList<HfSuccess> list = hfSuccessService.selectResult(hfOrder,pageBounds);


        List<List<String>> l = new ArrayList<>();

        for (HfSuccess HfListenTemp_:list){

            List<String> temp_ = new ArrayList<>();

            //订单相关
            HfOrder hfOrderTemp_ = HfListenTemp_.getHfOrder();

            temp_.add(hfOrderTemp_.getStudentName());
            temp_.add(hfOrderTemp_.getStudentPhone());
            temp_.add(hfOrderTemp_.getDocName());
            temp_.add(hfOrderTemp_.getOrgName());
            temp_.add(hfOrderTemp_.getStudentId());

            temp_.add(HfListenTemp_.getContractNumbe());
            temp_.add(String.valueOf(HfListenTemp_.getClassHour()));
            temp_.add(HfListenTemp_.getOrderMoney().toString());
            temp_.add(HfListenTemp_.getGift());
            temp_.add(HfListenTemp_.getPayStatus());

             //成单时间
            Date c1 = HfListenTemp_.getcTime();
            SimpleDateFormat c_t1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cstr1 = c_t1.format(c1);
            temp_.add(cstr1);

            //支付时间
            Date c2 = HfListenTemp_.getPayTime();
            SimpleDateFormat c_t2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cstr2 = c_t1.format(c2);
            temp_.add(cstr2);

            //关单录音时间
            if(HfListenTemp_.getCloseVTime() != null){
                Date c3 = HfListenTemp_.getCloseVTime();
                SimpleDateFormat c_t3= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String cstr3 = c_t1.format(c3);
                temp_.add(cstr3);
            } else{
                temp_.add("");
            }


            //高考年份
            Date gaokaoYear = hfOrderTemp_.getGaokaoYear();
            if(gaokaoYear != null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(gaokaoYear);
                String m ="00" + String.valueOf(calendar.get(Calendar.MONTH)+1);
                m = m.substring(m.length()-2);
                temp_.add(String.valueOf(calendar.get(Calendar.YEAR)) + "-" + m);
            } else{
                temp_.add("");
            }

            temp_.add(hfOrderTemp_.getChannel());
            temp_.add(hfOrderTemp_.getIfSuccess()?"成单":"未成单");
            temp_.add(hfOrderTemp_.getIfError()?"有效":"无效数据");
            temp_.add(hfOrderTemp_.getIfIntroduction()?"转介绍":"非转介绍");
            //转介绍类型
            String IntroductionType = hfOrderTemp_.getIntroductionType();
            String introductionTypeName= null;
            if("1".equals(IntroductionType)){
                introductionTypeName = "公司员工转介绍";
            }else if("2".equals(IntroductionType)){
                introductionTypeName = "用户转介绍";
            } else{
                introductionTypeName = "";
            }
            temp_.add(introductionTypeName);

            String introductionId = hfOrderTemp_.getIntroductionId();
            temp_.add(introductionId);

            //录入时间
            Date c = HfListenTemp_.getcTime();
            SimpleDateFormat c_t= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cstr = c_t.format(c);
            temp_.add(cstr);

            l.add(temp_);
        }

        List<String> headerList = Lists.newArrayList();

        headerList.add("学生姓名");
        headerList.add("家长电话");
        headerList.add("跟进人");
        headerList.add("所属组别");
        headerList.add("编号");

        headerList.add("成单合同编号");
        headerList.add("课时");
        headerList.add("成单金额");
        headerList.add("赠品");
        headerList.add("支付方式");
        headerList.add("成单时间");
        headerList.add("支付时间");
        headerList.add("关单录音时间");

        headerList.add("高考年份");
        headerList.add("渠道");
        headerList.add("是否已经成单");
        headerList.add("数据是否有效");
        headerList.add("是否是转介绍");
        headerList.add("转介绍类型");
        headerList.add("转介绍人");
        headerList.add("邀约时间");

        ExportExcel ee = new ExportExcel(title, headerList);
        for (int i = 0; i < l.size(); i++) {
            Row row = ee.addRow();
            for (int j = 0; j < l.get(i).size(); j++) {
                ee.addCell(row, j, l.get(i).get(j));
            }
        }
        ee.write(respone,title+ ".xlsx");
        ee.dispose();
    }

}
