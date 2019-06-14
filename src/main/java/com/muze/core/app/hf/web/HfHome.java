package com.muze.core.app.hf.web;

import com.muze.core.app.common.service.CommonService;
import com.muze.core.app.utils.PageURLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/hfhome")
public class HfHome {

    @Autowired
    @Qualifier("commonService")
    private CommonService commonService;

    @RequestMapping("/page")
    public String getPage(Map<String, Object> model) {
        return PageURLUtil.HfHome.PAGE;
    }

}
