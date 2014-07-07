package com.adrater.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adrater.manager.UserManager;

@Path("/signup")
public class SignUpService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void signUp(String userVO)
	{
		System.out.println("Inside sinup");
		try {
			UserManager userManager = new UserManager();
			userManager.addUser(userVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
