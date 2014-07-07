package com.adrater.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adrater.datacollection.dao.UserDao;
import com.adrater.datacollection.vo.UserVO;
import com.adrater.manager.UserManager;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginService {

	@POST
	@Path("/signin")
	public boolean validateUser(UserVO userVO){
		try {
			UserManager userManager = new UserManager();
			return userManager.validateUser(userVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	@POST
	@Path("/signup")
	public int signUp(UserVO userVO)
	{
		try {
			UserManager userManager = new UserManager();
			return userManager.addUser(userVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}	
	}
}
