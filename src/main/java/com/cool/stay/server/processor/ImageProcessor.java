package com.cool.stay.server.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cool.stay.server.datastore.ConnectionManager;

public class ImageProcessor {
	/**
	 * sample location: "C:\\Users\\parkhan\\Desktop\\img.jpg"
	 * 
	 * @param location
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	public void saveImage(String imgString)
			throws ClassNotFoundException, SQLException, IOException {
		ConnectionManager cmgr = new ConnectionManager();
		Connection con = cmgr.getConnection();
		 
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\parkhan\\Desktop\\tmp_image.jpg");
		String []doit = imgString.split(",");
		byte[] buf = new byte[doit.length];
		
		for (int i = 0; i < buf.length; i++) {
			buf[i] = Byte.parseByte(doit[i]);
		}
		;

		fos.write(buf, 0, doit.length);
		fos.close();
		System.out.println(buf);
		
		File imgfile = new File("C:\\Users\\parkhan\\Desktop\\tmp_image.jpg");

		FileInputStream fin = new FileInputStream("C:\\Users\\parkhan\\Desktop\\tmp_image.jpg");

		PreparedStatement pre = con.prepareStatement("insert into img_set values(?)");

		pre.setBinaryStream(1, (InputStream) fin, (int) imgfile.length());
		pre.executeUpdate();
		System.out.println("Successfully inserted the file into the database!");
		try {
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pre.close();
	}

	/**
	 * destination location: "C:\\Users\\parkhan\\Desktop\\test3.jpg"
	 * @param destinationLocation
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public String loadImage(String destinationLocation, String sql, String columnName) throws ClassNotFoundException, SQLException, IOException {
		ConnectionManager cmgr = new ConnectionManager();
		Connection con = cmgr.getConnection();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		rs.next();
		Blob blob = rs.getBlob(columnName);
		int len = (int) blob.length();

		byte[] buf = blob.getBytes(1, len);
		String xy = "";
		for (int i = 0; i < len; i++) {
			xy += buf[i];
			if (i + 1 != len) {
				xy += ",";
			}
		}
	
		System.out.println(buf);
		return xy;
	}
	
	public int countStr(String superString, String subString) {
		String str = superString;
		String findStr = subString;
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){

		    lastIndex = str.indexOf(findStr,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += findStr.length();
		    }
		}
		
		return count;
	}
}
