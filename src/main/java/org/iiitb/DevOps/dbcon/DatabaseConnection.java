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
			
			Class.forName("com.mysql.cj.jdbc.Driver");			
			String user = "root";
			String pass = "5555";
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection("jdbc:mysql://db:3306/spectrumdata?autoReconnect=true&useSSL=false",
					user, pass);
			System.out.println("Connections Success");
	    }
		catch (Exception e) {
			System.out.println("in catch");
		
	}
		return conn;
	}

}
