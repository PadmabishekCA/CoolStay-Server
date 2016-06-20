package com.cool.stay.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cool.stay.server.datastore.ConnectionManager;
import com.cool.stay.server.datastore.Sqls;
import com.cool.stay.server.dto.Cuisine;

public class CuisineDAOImpl {
	private static ConnectionManager conMgr = new ConnectionManager();

	public List<Cuisine> getCuisines() throws ClassNotFoundException, SQLException {
		ResultSet rs = conMgr.executeQuery(Sqls.getCuisines);
		List<Cuisine> lst = new ArrayList<Cuisine>();

		while (rs.next()) {
			Cuisine user = new Cuisine(rs.getString(1), rs.getString(2), rs.getString(3));
			lst.add(user);
		}

		return lst;
	}

	public void addCuisine(Cuisine user) {
		try {
			conMgr.executeUpdate(Sqls.addCuisine, user.getName(), user.getDescription(), user.getImage(),
					user.getPriority(), user.getUserId());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteCuisine(Cuisine user) {
		System.out.println("user name " + user.getName());
		try {
			conMgr.executeUpdate(Sqls.deleteCuisine, user.getName());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
