package com.test.demorest;



import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienController {
	
	AlienRepository repo=new AlienRepository();
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAlien() throws SQLException {
		
		
		
		return repo.getAlien();
	}
    @GET
    @Path("alien/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlienid(@PathParam("id")int id) throws SQLException {
		
		
		
		return repo.getAlien(id);
	}
    
    
    @POST
    @Path("alien")
    public Alien createAlien(Alien a1) throws SQLException
    {
    	repo.create(a1);
    	return a1;
    }
}
