package org.iiitb.DevOps.dbcon;
import java.sql.*;
import org.json.JSONException;
import org.json.JSONObject;

public class DatabaseConnection {
	public static Connection conn;

	public DatabaseConnection () 
	{
	}
	

	public static Connection getConnection() {
		try {
//			Statement stmt;
			
			Class.forName("com.mysql.cj.jdbc.Driver");			
			String user = "root";
			String pass = "5555";
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection("jdbc:mysql://db:3306/spectrumdata?autoReconnect=true&useSSL=false",
					user, pass);
			System.out.println("Connections Success");
//			stmt = conn.createStatement();
//			String sql;
//			sql = "SELECT * from seller";
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				String fname = rs.getString("fname");
//				System.out.print("fname: " + fname);
//			}
//			
//	        String query = "select * from sellerLogin where loginId = '"+"asd"+"'and password = '"+"asd"+"'";
//	        stmt = conn.createStatement();
//	        rs = stmt.executeQuery(query);
//	        //return true;
//	        int count=0;
//	        while(rs.next())
//	        {
//	            count=count+1;
//	        }
	    }
		catch (Exception e) {
			System.out.println("in catch");
		//e.printStackTrace();
	}
		return conn;
	}

}
