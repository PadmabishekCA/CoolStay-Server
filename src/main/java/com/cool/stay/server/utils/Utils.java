package com.cool.stay.server.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
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
	
	public static Map convertJsonRequestToMap(JSONObject jObject){
		JSONArray jarray= jObject.getJSONArray("classroom");
		System.out.println("Request: Create jarray " + jarray);
		Map ob = new HashMap();
		Iterator it =jarray.iterator();
		while(it.hasNext())	
		{
			JSONObject jObjectit = (JSONObject)it.next();
			Iterator<?> keys = jObjectit.keys();
			String keyName = null;
			while (keys.hasNext()) {
				String key = (String) keys.next();
				String value = jObjectit.getString(key);
				if(key.equalsIgnoreCase("name"))
					keyName = value;
				else if(key.equalsIgnoreCase("value")) 
					ob.put(keyName, value);
				System.out.println("Key : "+key + " value :"+ value);
			}
			System.out.println("Map obkect  :"+ ob.toString());
			
		}	
		return ob;
	}
}
