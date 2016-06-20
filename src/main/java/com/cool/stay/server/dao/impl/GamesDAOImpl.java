package com.cool.stay.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cool.stay.server.datastore.ConnectionManager;
import com.cool.stay.server.datastore.Sqls;
import com.cool.stay.server.dto.Games;

public class GamesDAOImpl {
	private static ConnectionManager conMgr = new ConnectionManager();;

	public List<Games> getGames() throws ClassNotFoundException, SQLException {
		ResultSet rs = conMgr.executeQuery(Sqls.getGamess);
		List<Games> lst = new ArrayList<Games>();

		while (rs.next()) {
			Games user = new Games(rs.getString(1), rs.getString(2), rs.getString(3));
			lst.add(user);
		}

		return lst;
	}

	public void addGames(Games user) {
		try {
			conMgr.executeUpdate(Sqls.addGames, user.getDescription(), user.getNumOfPlayers(), user.getImage());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteGames(Games user) {
		try {
			conMgr.executeUpdate(Sqls.deleteGames, user.getDescription());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
