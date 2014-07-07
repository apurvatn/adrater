package com.adrater.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adrater.manager.UserManager;

@Path("/auth")
public class AuthService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean authenticateUser(String email){
		try {
			UserManager userManager = new UserManager();
			return userManager.validateUser(email);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
}
