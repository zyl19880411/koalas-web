package com.muze.core.app.hf.web;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.common.web.BaseController;
import com.muze.core.app.hf.service.HfErrorService;
import com.muze.core.app.hforder.model.HfOrder;
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
 * 类说明     :海丰教育错误订单页面操作
 * 创建时间 :2018年6月18日21:16:32
 * 作         者:张玉龙
 * 版         本:v1
 */
@Controller
@RequestMapping("/error")
public class HfOrderErrorController extends BaseController {

    @Autowired
    @Qualifier("commonService")
    private CommonService commonService;

    @Autowired
    private HfErrorService hfErrorService;

    @RequiresPermissions("KVO1WDgHTvFZp67NgFvZjOoRvT6xkV")
    @RequestMapping("/phoneerror")
    public String phoneerror(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrderError.PAGE);
        model.put("list", list);
        return PageURLUtil.HfErrorListen.PAGE;
    }

    @RequiresPermissions("AigVBpEwHmlhrEAbT2TOvDp3c8fIcn")
    @RequestMapping("/nolistenError")
    public String nolistenErro(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrderError.PAGE_NOLISTEN);
        model.put("list", list);
        return PageURLUtil.HfErrorListen.PAGE_NO_LISTEN;
    }

    @RequiresPermissions("2Sh0t7TBqMEkWk16nDKTkQyFlkVjbo")
    @RequestMapping("/listenError")
    public String listenError(Map<String, Object> model) {
        List<Map<String, String>> list = commonService
                .getbtnPermission(BtnPermissionUtil.HfOrderError.PAGE_LISTEN);
        model.put("list", list);
        return PageURLUtil.HfErrorListen.PAGE_LISTEN;
    }

    @RequiresPermissions("OXOTjKnvxZcSkR0DNsaJKFZixKVU8o")
    @RequestMapping("/geterrorphone")
    @ResponseBody
    public String geterrorphone(HfOrder hfOrder,
                            HttpServletRequest request) {

        return getErrorOrder(hfOrder, request);
    }


    @RequiresPermissions("edOIpypZBzDFT1SXAuPSblczVVrt7l")
    @RequestMapping("/geterrorListen")
    @ResponseBody
    public String geterrorListen(HfOrder hfOrder,
                                HttpServletRequest request) {

        return getErrorOrder(hfOrder, request);
    }

    @RequiresPermissions("AAP8CoQnKBkfmnfwm3jcoOCXcZbh8w")
    @RequestMapping("/geterrorNoListen")
    @ResponseBody
    public String geterrorNoListen(HfOrder hfOrder,
                                HttpServletRequest request) {

        return getErrorOrder(hfOrder, request);
    }

    private String getErrorOrder(HfOrder hfOrder, HttpServletRequest request) {
        PageBounds pageBounds = new PageBounds(Integer.parseInt(request
                .getParameter("page")), Integer.parseInt(request
                .getParameter("rows")));

        PageList<HfOrder> list = hfErrorService.selectResult(hfOrder,pageBounds);

        JSONObject json = new JSONObject();

        json.put("total", list.getPaginator().getTotalCount());
        json.put("rows", list);

        return json.toString();
    }


    @RequiresPermissions("2H3ziaVNHdeLgqhvw5AlICGWfRmQel")
    @RequestMapping("/exporterrorphone")
    public void exporterrorphone(HfOrder hfOrder,
                       HttpServletRequest request,HttpServletResponse respone) throws IOException {
        export(hfOrder, respone,"空错号");
    }

    @RequiresPermissions("ZTK3h84BhPOdPkr3KTPunyQpnAIsDy")
    @RequestMapping("/exporterrorListen")
    public void exporterrorListen(HfOrder hfOrder,
                       HttpServletRequest request,HttpServletResponse respone) throws IOException {
        export(hfOrder, respone,"试听后失单");
    }

    @RequiresPermissions("h1BLBnlKZnC4xDiWwiuBVOOFrcVkvu")
    @RequestMapping("/exporterrorNoListen")
    public void exporterrorNoListen(HfOrder hfOrder,
                       HttpServletRequest request,HttpServletResponse respone) throws IOException {
        export(hfOrder, respone,"未试听失单");
    }


    private void export(HfOrder hfOrder, HttpServletResponse respone,String title) throws IOException {
        PageBounds pageBounds = new PageBounds(1,Integer.MAX_VALUE);

        PageList<HfOrder> list = hfErrorService.selectResult(hfOrder,pageBounds);
        List<List<String>> l = new ArrayList<>();

        for (HfOrder hfOrderTemp_:list){
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
        ee.write(respone,title+".xlsx");
        ee.dispose();

    }
}
