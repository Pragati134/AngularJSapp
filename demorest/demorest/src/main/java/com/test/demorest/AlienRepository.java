package com.test.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienRepository {
	
	List<Alien> alien;
	
	Connection conn;
	public AlienRepository()
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

	public List<Alien> getAlien() throws SQLException
	{
		List<Alien> alien=new ArrayList<Alien>();
		String sql="select * from alien";
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Alien a= new Alien();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			
			alien.add(a);
		}
		return alien;
	}
	public Alien getAlien(int id) throws SQLException {
		
		/*
		 * for(Alien a : alien) { if(a.getId()==id) return a; } return null;
		 */
		Alien a= new Alien();
		String sql="select * from alien where id=" +id;
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
			
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			
			
		}
	return a;
	}

	public void create(Alien a1) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * alien.add(a1); return a1;
		 */
		String sql="insert into alien values(?,?,?)";
		PreparedStatement st= conn.prepareStatement(sql);
		st.setInt(1,a1.getId());
		st.setString(2,a1.getName());
		st.setInt(3,a1.getPoints());
		st.executeUpdate();
		
	}
}
