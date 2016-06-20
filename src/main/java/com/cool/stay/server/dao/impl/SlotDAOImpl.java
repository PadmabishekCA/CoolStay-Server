package com.cool.stay.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cool.stay.server.datastore.ConnectionManager;
import com.cool.stay.server.datastore.Sqls;
import com.cool.stay.server.dto.Slot;

public class SlotDAOImpl {
	private static ConnectionManager conMgr = new ConnectionManager();;

	public List<Slot> getSlots() throws ClassNotFoundException, SQLException {
		ResultSet rs = conMgr.executeQuery(Sqls.getGamess);
		List<Slot> lst = new ArrayList<Slot>();

		while (rs.next()) {
			Slot user = new Slot(rs.getString(1), rs.getString(2));
			lst.add(user);
		}

		return lst;
	}

	public void addSlot(Slot user) {
		try {
			conMgr.executeUpdate(Sqls.addGames, user.getStartTime(), user.getEndTime());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteSlot(Slot user) {
		try {
			conMgr.executeUpdate(Sqls.deleteGames, user.getStartTime());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
