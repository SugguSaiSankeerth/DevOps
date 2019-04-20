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
//import org.iiitb.DevOps.model.Category;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test_class {
public static void main(String args[]) throws Exception {
// boolean b = DAO_Sub_Category.addSub_Category(3, "Women's Clothing");
// b = DAO_Sub_Category.addSub_Category(3, "Women's Shoes");
// b = DAO_Sub_Category.addSub_Category(3, "Men's Clothing");
// b = DAO_Sub_Category.addSub_Category(3, "Men's Shoes");
// b = DAO_Sub_Category.addSub_Category(3, "Fashion Jewelry");
// b = DAO_Sub_Category.addSub_Category(3, "Women's Hand Bags");
// b = DAO_Sub_Category.addSub_Category(3, "Kid's Clothing");
// b = DAO_Sub_Category.addSub_Category(3, "Others");
	
 
 //System.out.println(b);
 //boolean b1 = DAO_Buyer.update_Buyer(2,"mukesh","2001-01-01","8976768647","mukesh@gmail.com","25-K Frank Anne Street, Michigan","26-K Frank Anne Street, Michigan");
 //System.out.println("b1 "+b1);
 
 //ArrayList<Item> anslist = new ArrayList<Item>();
//System.out.println(b);

//ArrayList<Shopping_Cart> list = new ArrayList<Shopping_Cart>();

// list = DAO_Shopping_cart.get_Shopping_Cart_details(2);
// int length = list.size();
// for(int i=0;i<length;i++) {
//	 System.out.println(list.get(i).getId()+" "+list.get(i).getBuyer_id()+" "+list.get(i).getItem_id()+" "+list.get(i).getQuantity());	 
// }
//ArrayList<String> list = new ArrayList<String>();
 //boolean b = DAO_Shopping_cart.update_Itemof_Shopping_Cart(2, 30, 0);
//System.out.println(Update_Cart_Item(8,10,15));
//	JSONObject json = new JSONObject();
//	json.put("buyer_id", "7");
//	json.put("item_id", "8");
//	json.put("quantity", "4");
//	String s = json.toString();
//	System.out.println(DAO_Buyer.add_Buyer("John", "1997-08-05", "9876543210", "abc@hmail.com", "Somajiguda Hyd.", "Post Box : 1562", "1234"));
// boolean bou = DAO_BankAccount.add_Buyer_Account(2, 123131317, 98765);
//System.out.println(bou);
// testUpdateUser();
	Rest_Services rs = new Rest_Services();
	System.out.println(rs.HeatMap(null, null));

}
}
//public String get_user() throws JSONException {
//	JSONObject json = new JSONObject();
//	json.put("name", "aaaa");
//	json.put("email", "yyyy@hmail.com");
//	json.put("mobile", "9999999999");
//	json.put("dob", "1997-09-05");
//	json.put("address_1", "Post Box Number:1562 Hyd.");
//	json.put("address_2", "Somajiguda Hyd.");
//	String s = json.toString();
//	return s;
//}
//
//
//
//
//
//public static String Update_Cart_Item(String item) throws Exception{
//	
//	JSONObject buyer_json = new JSONObject(item);
//    boolean result = DAO_Shopping_cart.update_Itemof_Shopping_Cart(buyer_json.getInt("buyer_id"),
//    buyer_json.getInt("item_id"),
//    buyer_json.getInt("quantity"));
//    return result ? "S" : "F";
//}
//
//
//private static void testUpdateUser(){
//      Form form = new Form();
//     
////       form.param("name", "suresh");
////       form.param("email", "suresh@gmail.com");
////       form.param("mobile", "81972677288");
////       form.param("dob", "2001-01-01");
////       form.param("address_1", "luis street 1");
////       form.param("address_2", "luis street 2");
//     
//      
//      form.param("buyer_id", "11");
//      form.param("item_id", "11");
//      form.param("quantity", "1");
//     
//      Client client = ClientBuilder.newClient();
//       Response callResult = client
//          .target("http://localhost:8600/EC/webapi/ShoppingCartService/addCart")
//          .request(MediaType.TEXT_PLAIN)
//          .post(Entity.entity(form, MediaType.MULTIPART_FORM_DATA));
//          
//     System.out.println("response "+callResult);
//
//          
////          .put(Entity.entity(form,
////             MediaType.MULTIPART_FORM_DATA),
////             String.class);
////      String dummy="hgh";
////      Response dump=    
////      client
////           .target("http://localhost:9000/EC/webapi/buyerService/buyerInfo2")
////           .request(MediaType.TEXT_PLAIN)
////           .get();      
////      System.out.println("response "+dump);
//     
//     
////       String result = PASS;
////       if(!SUCCESS_RESULT.equals(callResult)){
////          result = FAIL;
////       }
////
////       System.out.println("Test case name: testUpdateUser, Result: " + result );
//   }
//}
//
//
//
///*
// * 
// *  anslist = DAO_Item.get_Top5_Items();
// System.out.println(anslist.get(0).getItem_id());
// System.out.println(anslist.get(1).getItem_id());
// System.out.println(anslist.get(2).getItem_id());
// System.out.println(anslist.get(3).getItem_id());
// System.out.println(anslist.get(4).getItem_id());
// 
// ArrayList<Item> anslist2 = new ArrayList<Item>();
//
// anslist2 = DAO_Item.get_Top5_Discounted();
// System.out.println(anslist2.get(0).getItem_id());
// System.out.println(anslist2.get(1).getItem_id());
// System.out.println(anslist2.get(2).getItem_id());
// System.out.println(anslist2.get(3).getItem_id());
// System.out.println(anslist2.get(4).getItem_id());
// 
// */
