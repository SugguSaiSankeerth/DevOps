package org.iiitb.DevOps.rest_services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.DevOps.dbcon.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;


@Path("Rest_Service")
public class Rest_Services {

	@Path("heatmap/{year}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public static String HeatMap(String input,@PathParam("year") String year) throws Exception{
		Connection conn=DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = null;		
		JSONArray heatmap_json_array = new JSONArray();		
		try {
			String query = "select country,band,value,year from worldgridchartdata where year=?";			
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1,year);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				JSONObject heatmap_json = new JSONObject();
				heatmap_json.put("country", rs.getString("country"));
				heatmap_json.put("band", rs.getString("band"));
				heatmap_json.put("value", rs.getString("value"));
				heatmap_json.put("year", rs.getString("year"));
				heatmap_json_array.put(heatmap_json);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return heatmap_json_array.toString();
	            
	 }
	
	@Path("indiamap/{year}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public static String IndiaMap(String input,@PathParam("year") String year) throws Exception{
		Connection conn=DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = null;		
		JSONObject indiamap_json_array = new JSONObject();
		int count  = 0;
		try {
			String query = "select * from india_ppa_"+year;			
			preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
				JSONObject indiamap_json = new JSONObject();
				for (int i = 1; i <= rsmd.getColumnCount(); i++)
				{ 
					if(rsmd.getColumnName(i).equals("State"))
						indiamap_json.put(rsmd.getColumnName(i),rs.getString(rsmd.getColumnName(i)));
					else 
					{
						if(rs.getString(rsmd.getColumnName(i)).equals(""))
							indiamap_json.put(rsmd.getColumnName(i),JSONObject.NULL);
						else
							indiamap_json.put(rsmd.getColumnName(i),rs.getDouble(rsmd.getColumnName(i)));
					}
				}
				indiamap_json_array.put(Integer.toString(count) , indiamap_json);
				count++;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return indiamap_json_array.toString();
		 
	            
	 }
	
	
	@Path("treemap")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public static String TreeMap() throws Exception{
	    		
		Connection conn=DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = null;		
		JSONArray heatmap_json_array = new JSONArray();
		
		try {
			String query = "select data_spectrum.key , region , subregion , value  from data_spectrum;";
			
			preparedStatement = conn.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				JSONObject heatmap_json = new JSONObject();
				heatmap_json.put("key", rs.getString("key"));
				heatmap_json.put("region", rs.getString("region"));
				heatmap_json.put("subregion", rs.getString("subregion"));
				heatmap_json.put("value", rs.getDouble("value"));
				heatmap_json_array.put(heatmap_json);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return heatmap_json_array.toString();
	            
	 }
}
