package com.cool.stay.server.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
	public static HashMap<String, Object> convertJsonToMap(String json) throws JSONException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JSONObject jObject = new JSONObject(json);
		Iterator<?> keys = jObject.keys();

		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = jObject.getString(key);
			map.put(key, value);
		}

		return map;
	}
	
	public static String convertMapToJson(Map<String, Object> hashMap) {
		return (new JSONObject(hashMap)).toString();
	}
}
