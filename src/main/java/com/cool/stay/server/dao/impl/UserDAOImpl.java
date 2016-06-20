package com.cool.stay.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cool.stay.server.datastore.ConnectionManager;
import com.cool.stay.server.datastore.Sqls;
import com.cool.stay.server.dto.Cuisine;
import com.cool.stay.server.dto.Games;
import com.cool.stay.server.dto.User;

public class UserDAOImpl {
	private static ConnectionManager conMgr = new ConnectionManager();;

	public List<User> getUsers() throws ClassNotFoundException, SQLException {
		ResultSet rs = conMgr.executeQuery(Sqls.getUsers);
		List<User> lst = new ArrayList<User>();

		while (rs.next()) {
			User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			lst.add(user);
		}

		return lst;
	}
	public String confirmUser(String user) throws ClassNotFoundException, SQLException {
		ResultSet rs = conMgr.executeQuery(Sqls.confirmUser,user);
		//List<User> lst = new ArrayList<User>();
		if (rs.next()) {
			String i = rs.getString(1);
			System.out.println("Hello"+i);
			if(i!=null)
				return i;
		}
		return "Invalid";
	}
	public void addUser(User user) {
		try {
			conMgr.executeUpdate(Sqls.addUser, user.getName(), user.getPassword(), user.getRoleName());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(User user) {
		try {
			conMgr.executeUpdate(Sqls.deleteUser, user.getName());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Map getAllDetails() throws ClassNotFoundException, SQLException {
		Map allMap = new HashMap();
		ResultSet rs = conMgr.executeQuery(Sqls.getGamess);
		List<Games> gamesList = new ArrayList<Games>();
		while (rs.next()) {
			Games user = new Games(rs.getString(1), rs.getString(2), rs.getString(3));
			gamesList.add(user);
		}
		System.out.println(gamesList);
		List<Cuisine> cuisineList = new ArrayList<Cuisine>();
		rs = conMgr.executeQuery(Sqls.getCuisines);
		while (rs.next()) {
			Cuisine user = new Cuisine(rs.getString(1), rs.getString(2), rs.getString(3));
			cuisineList.add(user);
		}
		
		allMap.put("games", gamesList);
		allMap.put("cuisine", cuisineList);
		return allMap;
	}
	
}
