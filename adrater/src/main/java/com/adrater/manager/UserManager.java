package com.adrater.manager;

import java.io.IOException;
import java.net.UnknownHostException;

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
public class UserManager {
	
	private ObjectMapper mapper = new ObjectMapper();

	public void addUser(String userVO){
		
		try {
			UserDao userDao = new UserDao();
			userDao.addUser(userVO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean validateUser(String email){
		
		try {
			UserDao userDao = new UserDao();
			UserVO userVO = mapper.readValue(email, UserVO.class);
			int result = userDao.validateUser(userVO);
			if(result!=0){
				System.out.println("User found");
				return true;
			}
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
