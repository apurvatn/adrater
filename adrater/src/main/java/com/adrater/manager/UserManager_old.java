package com.adrater.manager;

import java.io.IOException;
import java.net.UnknownHostException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.adrater.datacollection.dao.UserDao;
import com.adrater.datacollection.vo.UserVO;

/**
 * Manages all the functionalities wrt User object
 * @author apurvatn
 *
 */
public class UserManager_old {
	
	private ObjectMapper mapper = new ObjectMapper();

	public int addUser(UserVO userVO){

		String userVOStr;
		
		userVO.setFname("John");
		userVO.setLname("Doe");
		userVO.setEmail("johndoe@example.com");
		userVO.setPwd("pass123");
		
		try {
			userVOStr = mapper.writeValueAsString(userVO);
			UserDao userDao = new UserDao();
			userDao.addUser(userVOStr);
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public boolean validateUser(UserVO userVO){
		
		String userVOStr;
		try {
			userVOStr = mapper.writeValueAsString(userVO);
			UserDao userDao = new UserDao();
			int result = userDao.validateUser(userVO);
			if(result!=0){
				System.out.println("User found");
				return true;
			}
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("User not found");
		return false;
	}
	
	public UserVO getUser(String email){
		
		try {
			UserDao userDao = new UserDao();
			String userStr = userDao.getUser(email);
			UserVO userVO = mapper.readValue(userStr, UserVO.class);
			return userVO;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
