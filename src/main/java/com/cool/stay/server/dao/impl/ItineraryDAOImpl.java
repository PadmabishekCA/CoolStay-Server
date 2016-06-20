package com.cool.stay.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cool.stay.server.datastore.ConnectionManager;
import com.cool.stay.server.datastore.Sqls;
import com.cool.stay.server.dto.Itinerary;

public class ItineraryDAOImpl {
	private static ConnectionManager conMgr = new ConnectionManager();;

	public List<Itinerary> getItineraries() throws ClassNotFoundException, SQLException {
		ResultSet rs = conMgr.executeQuery(Sqls.getItineraries);
		List<Itinerary> lst = new ArrayList<Itinerary>();

		while (rs.next()) {
			Itinerary user = new Itinerary(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			lst.add(user);
		}

		return lst;
	}

	public void addItinerary(Itinerary user) {
		try {
			conMgr.executeUpdate(Sqls.addItinerary, user.getName(), user.getDescription(), user.getImage(),
					user.getRoute(), user.getVehicleTypes(), user.getMaxNumbers(), user.getUserId());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteItinerary(Itinerary user) {
		try {
			conMgr.executeUpdate(Sqls.deleteItinerary, user.getName());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
