package com.adrater.manager;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.adrater.datacollection.vo.UserRatingVO;

public class RatingManager {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public UserRatingVO parseUserRating(String userRating){
		
		UserRatingVO userRatingVO = new UserRatingVO();
		try {
			userRatingVO = mapper.readValue(userRating, UserRatingVO.class);
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
		return userRatingVO;
	}

}
