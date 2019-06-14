package com.muze.core.app.hf.web;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.hf.service.HfOrderService;
import com.muze.core.app.hferror.model.HfOrderError;
import com.muze.core.app.hflisten.model.HfListen;
import com.muze.core.app.hforder.model.HfOrder;
import com.muze.core.app.hfsucess.model.HfSuccess;
import com.muze.core.app.login.model.UserModel;
import com.muze.core.app.utils.BtnPermissionUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.RequestUtil;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Case;
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
@RequestMapping("/order")
public class HfOrderController extends BaseController {

    @Autowired
    @Qualifier("commonService")
    private CommonService commonService;

    @Autowired
    private HfOrderService hfOrderService;

    @RequiresPermissions("0VKIhs4xjiGISsEh23tYTr66vbAuV5")
    @RequestMapping("/all")
    public String getPage(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrder.PAGE);
        model.put("list", list);
        return PageURLUtil.Hf.PAGE;
    }

    @RequiresPermissions("gt1dsgTdtIRrRHCp7ucJdZVMsUfwCW")
    @RequestMapping("/allnew")
    public String allnew(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrder.PAGE_DAY);
        model.put("list", list);
        return PageURLUtil.Hf.PAGE_DAY;
    }

    @RequiresPermissions("NJXNQTliT01tIhpIqj2Qm2FZNj1lMF")
    @RequestMapping("/allweek")
    public String allweek(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrder.PAGE_WEEK);
        model.put("list", list);
        return PageURLUtil.Hf.PAGE_WEEK;
    }

    @RequiresPermissions("Ip3ATbAUyiYCwtmCmZWmVlPIV408E6")
    @RequestMapping("/allMonth")
    public String allMonth(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrder.PAGE_MONTH);
        model.put("list", list);
        return PageURLUtil.Hf.PAGE_MONTH;
    }

    @RequiresPermissions("XRHiDUhTSPmHkeWNlIT1rN8nPC7WQ4")
    @RequestMapping("/allyear")
    public String allyear(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrder.PAGE_YEAR);
        model.put("list", list);
        return PageURLUtil.Hf.PAGE_YEAR;
    }

    @RequiresPermissions("0MEbdBdaoz6QG8AD14bDx4Zd5pOPv0")
    @RequestMapping("/getOrders")
    @ResponseBody
    public String getOrders(HfOrder hfOrder,
                            HttpServletRequest request) {

        return getOrder(hfOrder, request);
    }

    @RequiresPermissions("WQI7qSbdCFJpGe0IYQR5gwMUE65LxK")
    @RequestMapping("/getOrdersDay")
    @ResponseBody
    public String getOrdersDay(HfOrder hfOrder,
                            HttpServletRequest request) {

        return getOrder(hfOrder, request);
    }

    @RequiresPermissions("Z4XzHgXv3r0yOxHaFO2uiYYCYH6SD3")
    @RequestMapping("/getOrdersWeek")
    @ResponseBody
    public String getOrdersWeek(HfOrder hfOrder,
                               HttpServletRequest request) {

        return getOrder(hfOrder, request);
    }

    @RequiresPermissions("VVOl6onYPL4KmWLapUfTfcqIHRPSKa")
    @RequestMapping("/getOrdersMonth")
    @ResponseBody
    public String getOrdersMonth(HfOrder hfOrder,
                                HttpServletRequest request) {

        return getOrder(hfOrder, request);
    }

    @RequiresPermissions("TOR8e5EPMOhXYX6p4qjgJEqkuhXaHT")
    @RequestMapping("/getOrdersYear")
    @ResponseBody
    public String getOrdersYear(HfOrder hfOrder,
                                 HttpServletRequest request) {

        return getOrder(hfOrder, request);
    }


    private String getOrder(HfOrder hfOrder, HttpServletRequest request) {
        PageBounds pageBounds = new PageBounds(Integer.parseInt(request
                .getParameter("page")), Integer.parseInt(request
                .getParameter("rows")));

        PageList<HfOrder> list = hfOrderService.selectResult(hfOrder,pageBounds);

        JSONObject json = new JSONObject();

        json.put("total", list.getPaginator().getTotalCount());
        json.put("rows", list);

        return json.toString();
    }

    @RequiresPermissions("omfWdOfgtmOFGbuHNBL8NrOim50ZOc")
    @RequestMapping("/export")
     public void export(HfOrder hfOrder,
                            HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"所有订单");

    }

    @RequiresPermissions("rxwdyUGhPSGKNSSEDG5eiJEEA81tSy")
    @RequestMapping("/exportDay")
    public void exportDay(HfOrder hfOrder,
                       HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"今天新订单");

    }

    @RequiresPermissions("GRCfijPFpMIbrmqCDN0NU1bcqj0xRr")
    @RequestMapping("/exportWeek")
    public void exportWeek(HfOrder hfOrder,
                          HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"本周新订单");

    }

    @RequiresPermissions("P187PhPSGnJMr2BQ0BS5Spa4REPv7l")
    @RequestMapping("/exportMonth")
    public void exportMonth(HfOrder hfOrder,
                           HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"本月新订单");

    }

    @RequiresPermissions("5MA55Sxg0XIWBNOF1XUfZhBRw6rnWv")
    @RequestMapping("/exportYear")
    public void exportYear(HfOrder hfOrder,
                           HttpServletRequest request,HttpServletResponse respone) throws IOException {

        export(hfOrder, respone,"本年度新订单");

    }

    private void export(HfOrder hfOrder, HttpServletResponse respone,String title) throws IOException {
        PageBounds pageBounds = new PageBounds(1,Integer.MAX_VALUE);

        PageList<HfOrder> list_ = hfOrderService.selectResult(hfOrder,pageBounds);

        List<List<String>> l = new ArrayList<>();

        for (HfOrder hfOrderTemp_:list_){
            List<String> temp_ = new ArrayList<>();
            temp_.add(hfOrderTemp_.getStudentName());
            temp_.add(hfOrderTemp_.getStudentPhone());
            temp_.add(hfOrderTemp_.getDocName());
            temp_.add(hfOrderTemp_.getOrgName());
            temp_.add(hfOrderTemp_.getStudentId());

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

            //意向课程
            String loveSubject = hfOrderTemp_.getLoveSubject();

            String love = null;
            if(loveSubject != null){
                switch (loveSubject){
                    case  "0":
                        love = "语文";
                        break;
                    case  "1":
                        love = "数学";
                        break;
                    case  "2":
                        love = "外语";
                        break;
                    case  "3":
                        love = "物理";
                        break;
                    case  "4":
                        love = "化学";
                        break;
                    case  "5":
                        love = "生物";
                        break;
                    case  "6":
                        love = "历史";
                        break;
                    case  "7":
                        love = "地理";
                        break;
                    case  "8":
                        love = "政治";
                        break;
                    case  "9":
                        love = "其他";
                        break;
                    default:
                        love = "未知";
                }
                temp_.add(love);
            } else{
                temp_.add("");
            }
            temp_.add(hfOrderTemp_.getChannel());
            temp_.add(hfOrderTemp_.getIfListener()?"试听":"未试听");
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
            Date c = hfOrderTemp_.getcTime();
            SimpleDateFormat c_t= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cstr = c_t.format(c);
            temp_.add(cstr);

            //更新时间
            if(hfOrderTemp_.getuTime() != null){
                Date d = hfOrderTemp_.getuTime();
                SimpleDateFormat c_u= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String cutr = c_u.format(c);
                temp_.add(cutr);
            } else{
                temp_.add("");
            }
            //备注
            temp_.add(hfOrderTemp_.getBackup());

            l.add(temp_);
        }

        List<String> headerList = Lists.newArrayList();

        headerList.add("学生姓名");
        headerList.add("家长电话");
        headerList.add("跟进人");
        headerList.add("所属组别");
        headerList.add("编号");
        headerList.add("高考年份");
        headerList.add("意向课程");
        headerList.add("渠道");
        headerList.add("是否试听");
        headerList.add("是否已经成单");
        headerList.add("数据是否有效");
        headerList.add("是否是转介绍");
        headerList.add("转介绍类型");
        headerList.add("转介绍人");
        headerList.add("录入时间");
        headerList.add("更新时间");
        headerList.add("备注");

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

    @RequiresPermissions("PuW5gvSpBTJ6603jBQjWhjoQMehqFh")
    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response,
                      Map<String, String> model){
        model.put("orderAddOrSave", "add");
        return PageURLUtil.Hf.ORDER_ADD_SAVE;
    }

    @RequiresPermissions("jPMCYSP6ruFye3zxCkAgFxyxDSrRJ2")
    @RequestMapping("/save")
    public String save(HttpServletRequest request, HttpServletResponse response,
                      Map<String, String> model){
        model.put("orderAddOrSave", "save");
        model = RequestUtil.putModelMap(request, model);
        if(model.containsKey("backup") && model.get("backup") != null){
            String backup = model.get("backup");
            backup= backup.replaceAll("\\r\\n","\\\\r\\\\n");
            model.put("backup",backup);
        }

        return PageURLUtil.Hf.ORDER_ADD_SAVE;
    }

    @RequiresPermissions("a214r7YFuMo8eDgwHKbDSJI8NqVWff")
    @RequestMapping("/del")
    @ResponseBody
    public String del(@RequestParam("id") String id){

        try {
            hfOrderService.delOrder(Long.parseLong(id));
            return "delsuccess";
        } catch (Exception e){
            return "delerror";
        }
    }

    @RequiresPermissions(value ={"PuW5gvSpBTJ6603jBQjWhjoQMehqFh","jPMCYSP6ruFye3zxCkAgFxyxDSrRJ2"},logical=Logical.OR)
    @RequestMapping("/addOrsave")
    @ResponseBody
    public String addOrsave(HttpServletRequest request,
                            HttpServletResponse response, Map<String, String> model) {

        Map<String,String> map = RequestUtil.getRequestParamMap(request);

        HfOrder order = new HfOrder();

        //人员ID
        Session session =SecurityUtils.getSubject().getSession();
        UserModel userDto = (UserModel) session.getAttribute("user");
        order.setDocId(userDto.getId());
        //学生姓名
        order.setStudentName(map.get("hfusername"));
        //学生编号
        order.setStudentId(map.get("hfstudentId"));
        //家长电话
        order.setStudentPhone(map.get("hfuserphone"));

        //高考年份
        if(map.containsKey("hfgaokaoYear") && map.get("hfgaokaoYear") != null && !"".equals(map.get("hfgaokaoYear"))){
            Calendar calendar = Calendar.getInstance();
            String hfgaokaoYear = map.get("hfgaokaoYear");
            calendar.set(Calendar.YEAR,Integer.valueOf(hfgaokaoYear.substring(0,4)));
            calendar.set(Calendar.MONTH,Integer.valueOf(hfgaokaoYear.substring(5,7)));
            order.setGaokaoYear(calendar.getTime());
        }
        //意向课程
        if(map.containsKey("hflovesubject") && map.get("hflovesubject") != null && !"".equals(map.get("hflovesubject"))){
            order.setLoveSubject(map.get("hflovesubject"));
        }
        //渠道
        if(map.containsKey("hfchannel") && map.get("hfchannel") != null && !"".equals(map.get("hfchannel"))){
            order.setChannel(map.get("hfchannel"));
        }
        //备注
        if(map.containsKey("hftype_Remark") && map.get("hftype_Remark") != null && !"".equals(map.get("hftype_Remark"))){
            order.setBackup(map.get("hftype_Remark"));
        }

        if(map.get("addOrSave").equals("add")){

            if(hfOrderService.checkExtsis (order.getStudentId ())){
                return "orderContains";
            }
            //是否试听
            order.setIfListener(false);
            //是否成单
            order.setIfSuccess(false);
            //是否转介绍
            order.setIfIntroduction(false);
            //是否有效数据
            order.setIfError(true);
            //录入时间
            order.setcTime(new Date());
            hfOrderService.insertSelective(order);

            return "addSuccess";
        } else{

            long id =  (long) Integer.parseInt ( map.get ( "hfid" ) );
            order.setId (id);
            if(hfOrderService.checkExtsisForUpdate (order.getStudentId (),id)){
                return "orderContains";
            }
            hfOrderService.updateOrder ( order );
            return "updateSuccess";
        }

    }

    @RequiresPermissions("zbYoJ17XW4EmdwQEMJdFJKENdKxV8g")
    @RequestMapping("/listen")
    public String listen(HttpServletRequest request, HttpServletResponse response,
                       Map<String, String> model){
        model = RequestUtil.putModelMap(request, model);

        return PageURLUtil.Hf.ORDER_LISTEN;
    }

    @RequiresPermissions("72fVBPr4KBHLIUn07b5gykDUW0ftxw")
    @RequestMapping("/success")
    public String success(HttpServletRequest request, HttpServletResponse response,
                         Map<String, String> model){
        model = RequestUtil.putModelMap(request, model);

        return PageURLUtil.Hf.ORDER_SUCCESS;
    }

    @RequiresPermissions("Ein8tfcksPuHvmOF8PKXm5z7TIYt1f")
    @RequestMapping("/introduction")
    public String introduction(HttpServletRequest request, HttpServletResponse response,
                          Map<String, String> model){
        model = RequestUtil.putModelMap(request, model);

        return PageURLUtil.Hf.ORDER_INTRODUCTION;
    }

    @RequiresPermissions("8YoINwfmGuashBUjOd0HgB3kfxv1av")
    @RequestMapping("/error")
    public String error(HttpServletRequest request, HttpServletResponse response,
                               Map<String, String> model){
        model = RequestUtil.putModelMap(request, model);
        return PageURLUtil.Hf.ORDER_ERROR;
    }

    @RequiresPermissions("Ein8tfcksPuHvmOF8PKXm5z7TIYt1f")
    @RequestMapping("/addintroduction")
    @ResponseBody
    public String addintroduction(HttpServletRequest request) throws ParseException {

        try{
            Map<String,String> map = RequestUtil.getRequestParamMap(request);
            //订单ID
            String id = map.get ( "orderintroductionId" );
            HfOrder hf = new HfOrder();
            hf.setId(Long.valueOf(id));
            hf.setIfIntroduction(true);
            //转介绍类型
            String addhfhfintroductionType = map.get("addhfhfintroductionType");
            hf.setIntroductionType(addhfhfintroductionType);

            //转介绍人
            String hfintroductionName = map.get("hfintroductionName");
            hf.setIntroductionId(hfintroductionName);

            hfOrderService.Orderintroduction(hf);
            return "addSuccess";
        } catch (Exception e){
            return "adderror";
        }
    }

    @RequiresPermissions("8YoINwfmGuashBUjOd0HgB3kfxv1av")
    @RequestMapping("/adderror")
    @ResponseBody
    public String adderror(HttpServletRequest request) throws ParseException {

        try{
            Map<String,String> map = RequestUtil.getRequestParamMap(request);
            HfOrderError hfOrderError = new HfOrderError();
            //订单ID
            String id = map.get ( "orderErrorId" );
            hfOrderError.setOrderId(Long.parseLong(id));
            //错误类型
            String addhfErrorType = map.get("addhfErrorType");
            hfOrderError.setErrorId(Integer.valueOf(addhfErrorType));

            hfOrderService.OrderError(hfOrderError);
            return "addSuccess";
        } catch (Exception e){
            return "adderror";
        }
    }


    @RequiresPermissions("72fVBPr4KBHLIUn07b5gykDUW0ftxw")
    @RequestMapping("/addSuccess")
    @ResponseBody
    public String addSuccess(HttpServletRequest request) throws ParseException {

        try{
            Map<String,String> map = RequestUtil.getRequestParamMap(request);
            HfSuccess hfSuccess = new HfSuccess ();
            //订单ID
            String id = map.get ( "orderSuccessId" );
            hfSuccess.setOrderId ( Long.parseLong ( id ) );

            //成交试听关单时间
            String hfcloseVTime = map.get ( "hfcloseVTime" );
            SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
            Date d = sdf.parse ( hfcloseVTime );
            hfSuccess.setCloseVTime ( d );

            //合同编号
            String hfcontractNumbe = map.get ( "hfcontractNumbe" );
            hfSuccess.setContractNumbe ( hfcontractNumbe );

            //成单课时
            String hfclassHour= map.get ( "addhfclassHour" );
            hfSuccess.setClassHour ( Integer.parseInt ( hfclassHour ) );

            //成单金额
            String hforderMoney = map.get ( "hforderMoney" );
            hfSuccess.setOrderMoney ( new BigDecimal ( hforderMoney ) );

            //奖品
            if(map.containsKey ( "hfgift" ) && map.get ( "hfgift" ) != null && !"".equals ( map.get ( "hfgift" ) )){
                hfSuccess.setGift (map.get ( "hfgift" ));
            }

            //支付方式
            String hfpayStatus = map.get ( "hfpayStatus" );
            hfSuccess.setPayStatus ( hfpayStatus );

            //支付时间
            String hfpayTime = map.get ( "hfpayTime" );
            d = sdf.parse ( hfpayTime );
            hfSuccess.setPayTime ( d );
            return hfOrderService.OrderSuccess ( hfSuccess );
        } catch (Exception e){
            return "adderror";
        }
    }

    @RequiresPermissions("zbYoJ17XW4EmdwQEMJdFJKENdKxV8g")
    @RequestMapping("/addListen")
    @ResponseBody
    public String addListen(HttpServletRequest request) throws ParseException {
        Map<String,String> map = RequestUtil.getRequestParamMap(request);
        HfListen order = new HfListen();

        //订单ID
        String id = map.get ( "orderListenId" );
        order.setOrderId ( Long.parseLong ( id ) );
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
        hfOrderService.OrderListen (order);
        return "addSuccess";
    }

}
