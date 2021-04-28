package com.test.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	

	
	Connection conn;
	public UserRepository()
	{
		/*
		 * alien = new ArrayList<Alien>(); Alien a1 = new Alien(); a1.setId(1);
		 * a1.setName("Yash"); a1.setPoints(100); Alien a2 = new Alien(); a2.setId(2);
		 * a2.setName("Yash"); a2.setPoints(100); alien.add(a1); alien.add(a2);
		 */
		String url="jdbc:sqlserver://LAPTOP-94JOT367\\SQLEXPRESS;databaseName=MyDB;portNumber=1433;";
		String us= "Test";
		String ps= "Test";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn=DriverManager.getConnection(url,us,ps);
		System.out.println("connected");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	} 
	public List<User> getAllUsers() {
		  List<User> lst = new ArrayList();
		  try {
			  String sql="select * from userdetails";
		    Statement st= conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
		   
		   while (rs.next()) {
		    User obj = new User();
		    obj.setUserid(rs.getInt("userid"));
		    obj.setUsername(rs.getString("username"));
		    obj.setEmail(rs.getString("email"));
		    obj.setPhonenumber(rs.getString("phonenumber"));
		    lst.add(obj);
		    
		   }
		  } catch (Exception e) {
		   System.out.println(e);
		  }
		 
		  return lst;
		 }

	
public User getuser(int userid) throws SQLException {
		
		
		User a= new User();
		String sql="select * from userdetails where userid=" +userid;
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
			
			
			    a.setUserid(rs.getInt("userid"));
			    a.setUsername(rs.getString("username"));
			    a.setEmail(rs.getString("email"));
			    a.setPhonenumber(rs.getString("phonenumber"));
			   
			
			
		}
	return a;
	}
		 public String addUser(User obj) {
		  try {
			  String sql="insert into userdetails(username,email,phonenumber) values(?,?,?)";
				PreparedStatement st= conn.prepareStatement(sql);
				
				st.setString(1,obj.getUsername());
				st.setString(2,obj.getEmail());
				st.setString(3,obj.getPhonenumber());
				System.out.println(obj.getUsername());
				System.out.println(obj.getEmail());
				System.out.println(obj.getPhonenumber());
		   int i =st.executeUpdate();
		   if (i > 0) {
		    return "{\"msg\":\"User Created\"}";
		   }
		  } catch (Exception e) {
		   System.out.println("addUser: " + e);
		  }
		  return "{\"msg\":\"Failed to  Create User\"}";
		 }

		 public String updateUser(User obj) {
		  try {
		  
		   String sql="update userdetails set username=?,email = ?,phonenumber=? where userid = ?";
			PreparedStatement st= conn.prepareStatement(sql);
			
			st.setString(1,obj.getUsername());
			st.setString(2,obj.getEmail());
			st.setString(3,obj.getPhonenumber());
			st.setInt(4,obj.getUserid());
		   int i = st.executeUpdate();
		   if (i > 0) {
		    return "{\"msg\":\"User Updated\"}";
		   }
		  } catch (Exception e) {
		   System.out.println("updateUser: " + e);
		  }
		  return "Failed to  Update User";
		 }

		 public String delUser(int userid) {
		  try {
		   
		   String sql="delete from userdetails where userid = ?";
			PreparedStatement st= conn.prepareStatement(sql);
			st.setInt(1,userid);
		   int i = st.executeUpdate();
		   if (i > 0) {
		    return "{\"msg\":\"User Deleted\"}";
		   }
		  } catch (Exception e) {
		   System.out.println("delUser: " + e);
		  }
		  return "Failed to  Delete User";
		 }
}
