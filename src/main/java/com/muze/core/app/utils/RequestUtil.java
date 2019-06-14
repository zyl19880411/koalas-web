package com.muze.core.app.utils;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestUtil {

	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getRequestParamMap(HttpServletRequest request){
		
		if(request==null){
			return null;
		}
		
		Enumeration<String> e = request.getParameterNames();

		Map<String, String> map = new HashMap<String, String>();

		while (e.hasMoreElements()) {
			String val = e.nextElement();
			
			if(map.containsKey(val)){
				map.put(val,map.get(val) + ","+StringEscapeUtils.escapeHtml4(request.getParameter(val)));
			}
			else{
				map.put(val, request.getParameter(val));
			}
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getRequestParamLinkedMap(HttpServletRequest request){
		
		if(request==null){
			return null;
		}
		
		Enumeration<String> e = request.getParameterNames();

		Map<String, String> map = new LinkedHashMap<String, String>();

		while (e.hasMoreElements()) {
			String val = e.nextElement();
			map.put(val, StringEscapeUtils.escapeHtml4(request.getParameter(val)));
		}
		return map;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static Map<String,String> putModelMap(HttpServletRequest request,Map<String, String> model){
		
		if(request==null){
			return model;
		}
		
		Enumeration<String> e = request.getParameterNames();

		while (e.hasMoreElements()) {
			String val = e.nextElement();
			try {
				model.put(val, StringEscapeUtils.escapeHtml4(URLDecoder.decode(request.getParameter(val),"UTF-8")));
			} catch (UnsupportedEncodingException e1) {
				
				e1.printStackTrace();
			}
		}
		return model;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static Map<String,Object> putModelMapObject(HttpServletRequest request,Map<String, Object> model){
		
		if(request==null){
			return model;
		}
		
		Enumeration<String> e = request.getParameterNames();

		while (e.hasMoreElements()) {
			String val = e.nextElement();
			try {
				model.put(val, StringEscapeUtils.escapeHtml4(URLDecoder.decode(request.getParameter(val),"UTF-8")));
			} catch (UnsupportedEncodingException e1) {
			
				e1.printStackTrace();
			}
		}
		return model;
	}
	
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
	 
		String s_iso88591 = new String("中".getBytes("UTF-8"),"ISO8859-1");
		String s_utf8 = new String(s_iso88591.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(s_iso88591);
		System.out.println(s_utf8);
		
		System.out.println(URLEncoder.encode(URLEncoder.encode("初审")));
		System.out.println(URLDecoder.decode("%25E5%2588%259D%25E5%25AE%25A1","iso8859-1"));
		System.out.println(URLDecoder.decode("%E5%88%9D%E5%AE%A1","utf-8"));

		
	}
}
