package org.iiitb.DevOps.rest_services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.sql.Connection;
import java.sql.PreparedStatement;
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


@Path("Test")
public class test {

	@Path("success")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
 public String getTopItems() throws Exception{
		Connection conn=DatabaseConnection.getConnection();
		
	return "Success";
	}
}
