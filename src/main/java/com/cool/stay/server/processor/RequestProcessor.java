package com.cool.stay.server.processor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cool.stay.server.datastore.UserCache;
import com.cool.stay.server.dto.User;
import com.cool.stay.server.utils.Utils;

public class RequestProcessor {
	public static void createUser(String json) {
//		Map<String, Object> usersMap = Utils.convertJsonToMap(json);
//		User newUser = new User();
//		newUser.setUsername(usersMap.get("user").toString());
//		newUser.setPassword(usersMap.get("password").toString());
//		newUser.setRegisteredOn(new Date(Long.parseLong((String) usersMap.get("date"))));
//		newUser.setExpiryDate(new Date(Long.parseLong((String) usersMap.get("expires"))));
//		newUser.setRole(usersMap.get("role").toString());
//		
//		UserCache.getInstance().addOrUpdate(newUser);
	}
	
	public static String getUsers() {
//		int num = 1;
//		Map<String, Object> usernames = new HashMap<String, Object>();
//		for (String username: UserCache.getInstance().getAllUserNames()) {
//			usernames.put(String.valueOf(num++), username);
//		}
//		
//		return Utils.convertMapToJson(usernames);
		return null;
	}
	
	public static void deleteUser(String username) {
//		User newUser = new User();
//		newUser.setUsername(username);
//		UserCache.getInstance().deleteUser(newUser);
	}
}
