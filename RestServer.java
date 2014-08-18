package com.insertdata;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import java.sql.*;
@Path("/emp")
public class RestServer {

	
    @GET
    @Path("/users")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUsers()
    {  
    String name="Amar";
    String token="A11";
    	try {
    		  Class.forName("com.mysql.jdbc.Driver");
    		  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", 
    		"root", "pass");
    		  PreparedStatement st = 
    		con.prepareStatement("insert into token values(?,?)");
    		  st.setString(2, token);
    		  st.setString(1, name);
    		  
    		  st.executeUpdate();
    		  } catch (Exception e) {
    		  System.out.println(e.getMessage());
    		  }
        String result = "Data inserted";
        return result;
    }
}
