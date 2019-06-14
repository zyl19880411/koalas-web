package com.muze.core.app.login.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.muze.core.app.utils.ConstantUtil;

/**
 * *********************基本信息说明********************************
 * 类名        :AuthFilter.java
 * 项目名称 :com.muze.core.app.doc.web
 * 类说明     :登录过滤类
 * 创建时间 :2015年12月4日
 * 作         者:张玉龙
 * 版         本:v1
 ***************************修改历史********************************
 * 1、none
 * 修改人    :张玉龙
 * 修改时间:2015年12月4日
 ************************主要方法说明********************************
 * 1、destroy销毁
 * 2、doFilter登录验证
 * 3、init初始化
 *******************************************************************
 */
public class AuthFilter implements Filter{  
  
	
    @Override  
    public void destroy() {  
          
    }  
  
    /**
	 * *********************基本信息说明********************************
	 * 方法名     :doFilter
	 * 方法说明 :获取菜单信息
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、request:获取消息头信息
	 * 2、response:获取相应头信息
	 * 3、chain:获取过滤类
	 * 创建时间 :2015年12月2日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月2日
	 ************************方法功能说明********************************
	 * 1、获取路径requestURI,判断是否是不需要过滤的请求
	 * 2、端盘session是否过期，如果没有过期那么通过请求，如果过期了那么返回登录页面
	 *******************************************************************
	 */
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
          
            HttpServletRequest req = (HttpServletRequest)request;  
            HttpServletResponse res = (HttpServletResponse)response;  
            //基于http协议的servlet  
            String requestURI = req.getRequestURI();
            String path = req.getContextPath() + "/";
            
            String basePath = req.getScheme() + "://" + req.getServerName()
    				+ ":" + req.getServerPort() + req.getContextPath();
            
            if(requestURI.endsWith(path) 
            		|| requestURI.indexOf("login/getRandomKey")>=0 
            		|| requestURI.indexOf("login/userLogin")>=0
            		|| requestURI.indexOf("login/index")>=0
            		){
            	  chain.doFilter(req, res);
            	  return;
            }
            
            Subject subject = SecurityUtils.getSubject();
    		Session session = subject.getSession();
    		
            if(session.getAttribute(ConstantUtil.LOGIN_USER)==null){
            	SecurityUtils.getSubject().logout();
            	res.sendRedirect(basePath + "/login/userLogin.do");
            	return;
            }
            chain.doFilter(req, res);
             
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}  
} 