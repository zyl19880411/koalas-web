package com.muze.core.app.hf.web;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.hf.service.HfListenService;
import com.muze.core.app.hf.service.HfOrderService;
import com.muze.core.app.hferror.model.HfOrderError;
import com.muze.core.app.hflisten.model.HfListen;
import com.muze.core.app.hforder.model.HfOrder;
import com.muze.core.app.hfsucess.model.HfSuccess;
import com.muze.core.app.login.model.UserModel;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.RequestUtil;
import com.muze.core.app.utils.excel.ExportExcel;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * *********************基本信息说明********************************
 * 类名        :HfOrderController.java
 * 项目名称 :com.muze.core.app.hf.web
 * 类说明     :海丰教育新增订单页面操作
 * 创建时间 :2018年6月18日21:16:32
 * 作         者:张玉龙
 * 版         本:v1
 */
@Controller
@RequestMapping("/listener")
public class HfOrderListenController extends BaseController {

    @Autowired
    @Qualifier("commonService")
    private CommonService commonService;

    @Autowired
    private HfListenService hfListenService;

    @RequiresPermissions("0VKIhs4xjiGISsEh23tYTr66vbAuV5")
    @RequestMapping("/all")
    public String getPage(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfListen.PAGE);
        model.put("list", list);
        return PageURLUtil.HfListen.PAGE;
    }


    @RequiresPermissions("4UzDMzTpqaQcsiFQGmalKHegCKkmGk")
    @RequestMapping("/allnow")
    public String allnow(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfListen.PAGE_CREATBYDAY);
        model.put("list", list);
        return PageURLUtil.HfListen.PAGE_CREAT_BYDAY;
    }

    @RequiresPermissions("H62TQlIvht8lhZt3vZVmjtcUTAPghW")
    @RequestMapping("/daying")
    public String daying(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfListen.PAGE_DAY);
        model.put("list", list);
        return PageURLUtil.HfListen.PAGE_DAY;
    }

    @RequiresPermissions("7wcKn6xJXZUW00hmNJ5mrIpXhrHXMg")
    @RequestMapping("/nextDay")
    public String nextDay(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfListen.PAGE_NEXT_DAY);
        model.put("list", list);
        return PageURLUtil.HfListen.PAGE_NEXT_DAY;
    }

    @RequiresPermissions("5eRfr78aloCKg6bZtruEWvFISLulUU")
    @RequestMapping("/currWeak")
    public String currWeak(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfListen.PAGE_WEEK_DAY);
        model.put("list", list);
        return PageURLUtil.HfListen.PAGE_WEEK_DAY;
    }

    @RequiresPermissions("r3k7klVOfygxxAarHZyd1VTBuw4lSx")
    @RequestMapping("/currMonth")
    public String currMonth(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfListen.PAGE_MONTH_DAY);
        model.put("list", list);
        return PageURLUtil.HfListen.PAGE_MONTH_DAY;
    }


    @RequiresPermissions("bc3gnERtASqfaFcKuHOxlBfbyx0DWR")
    @RequestMapping("/destroy")
    public String destroy(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfListen.PAGE_JUMP);
        model.put("list", list);
        return PageURLUtil.HfListen.PAGE_JUMP;
    }

    @RequiresPermissions("sGZfkPDdtm37absEv1xtFZrbXHWT3u")
    @RequestMapping("/getListen")
    @ResponseBody
    public String getListen(HfOrder hfOrder,HttpServletRequest request) {

        return getLis(hfOrder, request);
     }

    @RequiresPermissions("MMft2HtpfPhvK4KyCa0tarycjHWfSo")
    @RequestMapping("/getListenDay")
    @ResponseBody
    public String getListenDay(HfOrder hfOrder,HttpServletRequest request) {

        return getLis(hfOrder, request);
    }

    @RequiresPermissions("DSLYpYOuAcffdjjs7TFbLF65RENcDr")
    @RequestMapping("/exportDay")
    public void exportDay(HfOrder hfOrder,
                                  HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"今日试听数据");

    }

    @RequiresPermissions("kkIVbDN7ABsTzEbakzRdWXfFLxT0hh")
    @RequestMapping("/getListenNextDay")
    @ResponseBody
    public String getListenNextDay(HfOrder hfOrder,HttpServletRequest request) {

        return getLis(hfOrder, request);
    }

    @RequiresPermissions("78FaAmmPDf2HcTFS2l73VGuNG8MQcD")
    @RequestMapping("/exportNextDay")
    public void exportNextDay(HfOrder hfOrder,
                          HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"明天试听数据");

    }

    @RequiresPermissions("lEFNgCS3hkgVSori5wYu0rgsiqxUlE")
    @RequestMapping("/getListenWeekDay")
    @ResponseBody
    public String getListenWeekDay(HfOrder hfOrder,HttpServletRequest request) {

        return getLis(hfOrder, request);
    }

    @RequiresPermissions("TycAPy4335eBxyj7J8wZBXj3p54eAn")
    @RequestMapping("/exportWeekDay")
    public void exportWeekDay(HfOrder hfOrder,
                              HttpServletRequest request,HttpServletResponse respone) throws IOException {
        export(hfOrder, respone,"本周试听数据");
    }

    @RequiresPermissions("ZhqN5xqZz07Cl2e0ZpswZ6PbUppv2F")
    @RequestMapping("/getListenMonthDay")
    @ResponseBody
    public String getListenMonthDay(HfOrder hfOrder,HttpServletRequest request) {

        return getLis(hfOrder, request);
    }

    @RequiresPermissions("n8KHUQqFBw5z1os42QF5HsqSisr2a0")
    @RequestMapping("/exportMonthDay")
    public void exportMonthDay(HfOrder hfOrder,
                              HttpServletRequest request,HttpServletResponse respone) throws IOException {
        export(hfOrder, respone,"当月试听数据");
    }

    @RequiresPermissions("uGqSpUpGXjzUSS5c2P7a6khRS6IAM2")
    @RequestMapping("/getListenJump")
    @ResponseBody
    public String getListenJump(HfOrder hfOrder,HttpServletRequest request) {

        return getLis(hfOrder, request);
    }

    @RequiresPermissions("wVaIaudvcZN2G0mrCREAdqJjp4alZc")
    @RequestMapping("/exportJump")
    public void exportJump(HfOrder hfOrder,
                               HttpServletRequest request,HttpServletResponse respone) throws IOException {
        export(hfOrder, respone,"跳票数据");
    }

    @RequiresPermissions("H7UZoCxXHHQMRPJslAGeDgyiyuCLhe")
    @RequestMapping("/getListenCreateByDay")
    @ResponseBody
    public String getListenCreateByDay(HfOrder hfOrder,HttpServletRequest request) {

        return getLis(hfOrder, request);
    }

    @RequiresPermissions("sgfGdVqfJJzWNxYbfiA5CQt0vjmwIn")
    @RequestMapping("/exportCreateByDay")
    public void exportCreateByDay(HfOrder hfOrder,
                                  HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"今日邀约试听数据");

    }


    private String getLis(HfOrder hfOrder, HttpServletRequest request) {
        PageBounds pageBounds = new PageBounds(Integer.parseInt(request
                .getParameter("page")), Integer.parseInt(request
                .getParameter("rows")));

        PageList<HfListen> list = hfListenService.selectResult(hfOrder,pageBounds);
        JSONObject json = new JSONObject();

        json.put("total", list.getPaginator().getTotalCount());
        json.put("rows", list);

        return json.toString();
    }

    @RequiresPermissions("1fHg4P7RSqqCShy2DsKLfqK015oFWt")
    @RequestMapping("/del")
    @ResponseBody
    public String del(@RequestParam("id") String id){

        try {
             hfListenService.del(id);
             return "delsuccess";
        } catch (Exception e){
            return "delerror";
        }
    }

    @RequiresPermissions("0G8THvXmsDViBhw2uSpOQ2MsY4bUNw")
    @RequestMapping("/bounced")
    @ResponseBody
    public String bounced(@RequestParam("id") String id) throws Exception {
        try {
            hfListenService.bounced(id);
            return "bouncedsuccess";
        } catch (Exception e){
            return "bouncederror";
        }
    }

    @RequiresPermissions("L8ynbVwFb76duN2TEJ5DYrQnKz4zRm")
    @RequestMapping("/unbounced")
    @ResponseBody
    public String unbounced(@RequestParam("id") String id) throws Exception {
        try {
            hfListenService.unbounced(id);
            return "unbouncedsuccess";
        } catch (Exception e){
            return "unbouncederror";
        }
    }

    @RequiresPermissions("tqMieW0WjXALhBAsmmQbYSs2GwPigv")
    @RequestMapping("/update")
    public String save(HttpServletRequest request, HttpServletResponse response,
                       Map<String, String> model){
        model.put("orderAddOrSave", "save");
        model = RequestUtil.putModelMap(request, model);
        if(model.containsKey("teacherInfo") && model.get("teacherInfo") != null){
            String backup = model.get("teacherInfo");
            backup= backup.replaceAll("\\r\\n","\\\\r\\\\n");
            model.put("teacherInfo",backup);
        }
        return PageURLUtil.Hf.ORDER_LISTEN;
    }

    @RequiresPermissions("tqMieW0WjXALhBAsmmQbYSs2GwPigv")
    @RequestMapping("/updateListen")
    @ResponseBody
    public String updateListen(HttpServletRequest request) throws ParseException {

        try{
            Map<String,String> map = RequestUtil.getRequestParamMap(request);
            HfListen order = new HfListen();

            //订单ID
            String id = map.get ( "orderListenId" );
            order.setId ( Long.parseLong ( id ) );
            //试听课程
            String hflistenSubject = map.get ( "hflistenSubject" );
            order.setListenSubject (hflistenSubject);
            //试听时间
            String hflistenTime = map.get ( "hflistenTime" );
            SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
            Date d = sdf.parse ( hflistenTime );
            order.setListenTime (d);

            //教师姓名
            String hfteacherName = map.get ( "hfteacherName" );
            order.setTeacher ( hfteacherName );

            //教师电话
            String hfteacherPhone = map.get ( "hfteacherPhone" );
            order.setTeacherPhone ( hfteacherPhone );

            //学生地址
            if(map.containsKey ( "hflistenArea" ) && map.get ( "hflistenArea" ) != null && !"".equals ( map.get ( "hflistenArea" ) )){
                order.setArea (map.get ( "hflistenArea" ));
            }
            //学生年级
            if(map.containsKey ( "hflistennj" ) && map.get ( "hflistennj" ) != null && !"".equals ( map.get ( "hflistennj" ) )){
                order.setNj (map.get ( "hflistennj" ));
            }
            //教师详情
            if(map.containsKey ( "hfteacherInfo" ) && map.get ( "hfteacherInfo" ) != null && !"".equals ( map.get ( "hfteacherInfo" ) )){
                order.setTeacherInfo (map.get ( "hfteacherInfo" ));
            }
            hfListenService.updateListener(order);
            return "updateSuccess";
        }catch (Exception e){
            return "updateError";
        }
     }

    @RequiresPermissions("LO6NXDUixabcFkFbAAKjTcffoX6vdi")
    @RequestMapping("/export")
    public void export(HfOrder hfOrder,
                       HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"全部试听数据");

    }

    private void export(HfOrder hfOrder, HttpServletResponse respone,String title) throws IOException {
        PageBounds pageBounds = new PageBounds(1,Integer.MAX_VALUE);


        PageList<HfListen> list = hfListenService.selectResult(hfOrder,pageBounds);

        List<List<String>> l = new ArrayList<>();

        for (HfListen HfListenTemp_:list){

            List<String> temp_ = new ArrayList<>();

            //订单相关
            HfOrder hfOrderTemp_ = HfListenTemp_.getHfOrder();

            temp_.add(hfOrderTemp_.getStudentName());
            temp_.add(hfOrderTemp_.getStudentPhone());
            temp_.add(hfOrderTemp_.getDocName());
            temp_.add(hfOrderTemp_.getOrgName());
            temp_.add(hfOrderTemp_.getStudentId());

            //学生地址
            String area = HfListenTemp_.getArea();
            temp_.add(area);

            //学生年级
            String nj = HfListenTemp_.getNj();

            if(nj!=null){
                switch (nj){
                    case "0":
                        temp_.add("小学一年级");
                        break;
                    case "1":
                        temp_.add("小学二年级");
                        break;
                    case "2":
                        temp_.add("小学三年级");
                        break;
                    case "3":
                        temp_.add("小学四年级");
                        break;
                    case "4":
                        temp_.add("小学五年级");
                        break;
                    case "5":
                        temp_.add("小学六年级");
                        break;
                    case "6":
                        temp_.add("初中一年级");
                        break;
                    case "7":
                        temp_.add("初中二年级");
                        break;
                    case "8":
                        temp_.add("初中三年级");
                        break;
                    case "9":
                        temp_.add("高中一年级");
                        break;
                    case "10":
                        temp_.add("高中二年级");
                        break;
                    case "11":
                        temp_.add("高中三年级");
                        break;
                        default:
                            temp_.add("");
                }

            } else{
                temp_.add("");
            }

            //学生课程
            String listenSubject = HfListenTemp_.getListenSubject();
            if(nj!=null){
                switch (listenSubject){
                    case "0":
                        temp_.add("语文");
                        break;
                    case "1":
                        temp_.add("数学");
                        break;
                    case "2":
                        temp_.add("外语");
                        break;
                    case "3":
                        temp_.add("物理");
                        break;
                    case "4":
                        temp_.add("化学");
                        break;
                    case "5":
                        temp_.add("生物");
                        break;
                    case "6":
                        temp_.add("历史");
                        break;
                    case "7":
                        temp_.add("地理");
                        break;
                    case "8":
                        temp_.add("政治");
                        break;
                    default :
                        temp_.add("其他");
                        break;
                }
            }else{
                temp_.add("其他");
            }

            //试听时间
            Date c1 = HfListenTemp_.getListenTime();
            SimpleDateFormat c_t1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cstr1 = c_t1.format(c1);
            temp_.add(cstr1);

            //是否跳票
            boolean b =HfListenTemp_.getIfBounced();
            if(b){
                temp_.add("未跳票");
            }else{
                temp_.add("跳票");
            }

            //跳票时间
            Date c2 = HfListenTemp_.getIfbouncedTime();
            if(c2 != null){
                SimpleDateFormat c_t2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String cstr2 = c_t1.format(c2);
                temp_.add(cstr2);
            }else{
                temp_.add("");
            }

            //授课老师
           String Teacher =  HfListenTemp_.getTeacher();
            temp_.add(Teacher);

            //授课老师电话
           String TeacherPhone =  HfListenTemp_.getTeacherPhone();
            temp_.add(TeacherPhone);

            //授课老师详情
            String teacherInfo =HfListenTemp_.getTeacherInfo();
            temp_.add(teacherInfo);

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

        headerList.add("学生地址");
        headerList.add("学生年级");
        headerList.add("试听课程");
        headerList.add("试听时间");
        headerList.add("是否跳票");
        headerList.add("跳票时间");
        headerList.add("授课老师");
        headerList.add("授课老师电话");
        headerList.add("授课老师详情");

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
        ee.write(respone,title + ".xlsx");
        ee.dispose();
    }
}
