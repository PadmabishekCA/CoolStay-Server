package com.cool.stay.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public int addCuisine(Map cuisineDetail) {
		Cuisine cuisineInfo = new Cuisine(cuisineDetail);
		int rs=0,rs2=0;
		try {
		 rs=conMgr.executeUpdate(Sqls.addCuisine, cuisineInfo);
		 
		 rs2=conMgr.executeUpdate(Sqls.addCuisineAmount,cuisineInfo.getName(),cuisineInfo.getAmount());
		 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs+rs2;
	}

	public int deleteCuisine(Map deleteDetail) {
		Cuisine cuisineInfo = new Cuisine(deleteDetail.get("cuisineDeleteId").toString());
		System.out.println("user name " + cuisineInfo.getId());
		int rs=0;
		try {
			rs=conMgr.executeUpdate(Sqls.deleteCuisine, cuisineInfo.getId());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
