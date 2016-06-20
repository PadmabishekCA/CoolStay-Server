package com.cool.stay.server.datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cool.stay.server.dto.User;

public class UserCache {
	public static Map<String, User> usersData;
	private static UserCache instance;
	private static List<String> userNames;

	public static UserCache getInstance() {
		if (null == instance) {
			usersData = new HashMap<String, User>();
			userNames = new ArrayList<String>();
			instance = new UserCache();
		}

		return instance;
	}

}
