package com.cool.stay.server.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cool.stay.server.datastore.ConnectionManager;
import com.cool.stay.server.datastore.Sqls;
import com.cool.stay.server.dto.Cuisine;
import com.cool.stay.server.dto.CuisineOrder;
import com.cool.stay.server.dto.CuisineResponse;
import com.cool.stay.server.dto.OrderDetail;

public class CuisineOrderDAOImpl {
	private static ConnectionManager conMgr = new ConnectionManager();
	public Map addCuisineOrder(Map orderDetail) throws ClassNotFoundException, SQLException {
			OrderDetail o=null;
			CuisineOrder orderList = new CuisineOrder(orderDetail);
			List<OrderDetail> lst = new ArrayList<OrderDetail>();
			ResultSet rs = conMgr.executeQuery(Sqls.getInfoForCuisineOrder,orderList);
			while (rs.next()) {
				o =new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
				lst.add(o);
			}
			int i=updateOrder(o,orderList);
			
			rs = conMgr.executeQuery(Sqls.getOrderInfoOfUser,orderList.getUserName());
			List<CuisineResponse> resLst = new ArrayList<CuisineResponse>();
			while(rs.next()){
				Date date = rs.getDate(4);  // wherever you get this
				DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
				String text = df.format(date);
				CuisineResponse res= new CuisineResponse(rs.getString(1),rs.getString(2),rs.getDouble(3),text);
				resLst.add(res);
			}
			System.out.println("Object value"+ resLst.toString());
			Map resMap=new HashMap();
			resMap.put("orderInfo", resLst);
			return resMap;
	}
	
	public int updateOrder(OrderDetail o,CuisineOrder l){
		int rs=0;
		
		try{
		rs =conMgr.executeUpdate(Sqls.addCuisineOrder,o,l);
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	
}
