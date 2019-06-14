package com.muze.core.app.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

public class ResultUtil {

	public static final String DATA_NAME = "data";
	public static final String SUCCESS_NAME = "success";
	public static final String CODE_NAME = "code";
	
	
	public static String getJsonResult(Object obj, String succuess,String resultCode) {

		JSONObject json = new JSONObject();

		if (obj == null) {
			json.put(DATA_NAME, "");
			json.put(SUCCESS_NAME,succuess);
			json.put(CODE_NAME,resultCode);
			return json.toString();
		}

		if (Map.class.isAssignableFrom(obj.getClass())) {
			if (((Map) obj).keySet().size() == 0) {
				json.put(DATA_NAME, "");
			} else {
				json.put(DATA_NAME, JSONObject.fromObject(obj));
			}
		} else if (List.class.isAssignableFrom(obj.getClass())) {
			if (((List) obj).size() == 0) {
				json.put(DATA_NAME, "");
			} else {
				json.put(DATA_NAME, JSONArray.fromObject(obj));
			}
		} else if (String.class.isAssignableFrom(obj.getClass())) {
			json.put(DATA_NAME, obj.toString());
		}
		else if (int.class.isAssignableFrom(obj.getClass())) {
			json.put(DATA_NAME, String.valueOf((int)obj));
		}
		else{
			json.put(DATA_NAME,obj.toString());
		}
		json.put(CODE_NAME,resultCode);
		json.put(SUCCESS_NAME,succuess);
		return json.toString();
	}
}
