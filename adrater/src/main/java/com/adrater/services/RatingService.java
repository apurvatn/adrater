package com.adrater.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adrater.manager.RatingManager;

@Path("/rating")
public class RatingService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void rateAd(String rating){
		
		RatingManager ratingManager = new RatingManager();
		ratingManager.parseUserRating(rating);
	}

}
