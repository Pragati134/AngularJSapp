package com.test.demorest;



import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

@Path("users")
public class UserController {
	
	 UserRepository usrepo=new UserRepository();
   
    @GET
    @Path("user/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
	public User getuserid(@PathParam("userid")int userid) throws SQLException {
		return usrepo.getuser(userid);
	}
    
    
   
    
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String allUser() {
    
    	 Gson gson = new Gson();
        return gson.toJson(usrepo.getAllUsers());
    }

    @POST
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(User user) {
     System.out.println();
     String result = "";
     try {
      
      result = usrepo.addUser(user);
     } catch (Exception e) {
      System.out.println("Exception Error  " + e); // Console
     }
     return Response.status(200).entity(result).build();
    }

    @PUT
    @Path("/updateUser/userid/{userid}/username/{username}/email/{email}/phonenumber/{phonenumber}")
    public String updateUser(@PathParam("userid") int userid,
      @PathParam("username") String username, @PathParam("email") String email,@PathParam("phonenumber") String phonenumber) {
     String result = "";
     try {
     
      User obj = new User();
      obj.setUserid(userid);
      obj.setUsername(username);
      obj.setEmail(email);
      obj.setPhonenumber(phonenumber);
      result = usrepo.updateUser(obj);
     } catch (Exception e) {
      System.out.println("Exception Error  " + e); // Console
     }
     return result;
    }

    @DELETE
    @Path("/delUser/userid/{userid}")
    public String delUser(@PathParam("userid") int userid) {
     String result = "";
     try {
     
      result = usrepo.delUser(userid);
     } catch (Exception e) {
      System.out.println("Exception Error  " + e); // Console
     }
     return result;
    }
}
