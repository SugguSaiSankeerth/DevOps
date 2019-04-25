package org.iiitb.DevOps.Test;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.DevOps.dbcon.DatabaseConnection;
import org.iiitb.DevOps.rest_services.Rest_Services;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test_class {
public static void main(String args[]) throws Exception {
	Rest_Services rs = new Rest_Services();
	System.out.println(rs.HeatMap(null, null));

}
}

