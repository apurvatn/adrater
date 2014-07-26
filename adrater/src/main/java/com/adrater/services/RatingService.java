package com.adrater.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rating")
public class RatingService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void testRating(String rating){
		
		
	}

}
