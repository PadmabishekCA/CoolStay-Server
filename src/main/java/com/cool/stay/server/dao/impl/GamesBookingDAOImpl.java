package com.cool.stay.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cool.stay.server.datastore.ConnectionManager;
import com.cool.stay.server.datastore.Sqls;
import com.cool.stay.server.dto.GameSlotStatus;
import com.cool.stay.server.dto.GamesBooking;
import com.cool.stay.server.dto.GamesSlotDetail;
import com.cool.stay.server.dto.OrderDetail;

public class GamesBookingDAOImpl {
	private static ConnectionManager conMgr = new ConnectionManager();;
	public Map checkGamesSlot(Map checkingSlot) throws ClassNotFoundException, SQLException {
		GamesBooking bookingInfo = new GamesBooking(checkingSlot);
		ResultSet rs = conMgr.executeQuery(Sqls.checkGameStatus,bookingInfo);
		GameSlotStatus slotStatus=null;
		List<GameSlotStatus> lst = new ArrayList<GameSlotStatus>();
		while(rs.next())
		{
			slotStatus = new GameSlotStatus(rs.getInt(1),rs.getString(2));
			lst.add(slotStatus);
		}
		Map resMap=new HashMap();
		System.out.println("response list of slot"+ lst.toString());
		resMap.put("slotInfo", lst);
		System.out.println("response list of slot"+ resMap.toString());
		return resMap;
	}
	
	public Map bookSlot(Map bookInfoMap, List slotInfo) throws ClassNotFoundException, SQLException {
		GamesSlotDetail slot=null;
		for(int i=0;i<slotInfo.size();i++){
			
			slot = new GamesSlotDetail(bookInfoMap,slotInfo.get(i).toString());
			int rs =conMgr.executeUpdate(Sqls.bookGameSlot,slot);
			System.out.println("result set for "+i+" "+rs);
			
		}
		GamesSlotDetail userBookingInfo=null;
		ResultSet rs = conMgr.executeQuery(Sqls.slotBookingStatusOfUser,slot.getUserName());
		List<GamesSlotDetail> lst = new ArrayList<GamesSlotDetail>();
		while(rs.next()){
			userBookingInfo=new GamesSlotDetail(rs.getString(1),rs.getString(2),rs.getDate(3));
			lst.add(userBookingInfo);
		}
		
		Map resMap=new HashMap();
		resMap.put("userBookedInfo", lst);
		System.out.println("response list of slot"+ resMap.toString());
		return resMap;
		
	}
}
