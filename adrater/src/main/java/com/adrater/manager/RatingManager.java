package com.adrater.manager;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.adrater.datacollection.dao.RatingDao;
import com.adrater.datacollection.vo.ReviewVO;
import com.adrater.datacollection.vo.UserRatingVO;

public class RatingManager {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public UserRatingVO parseUserRating(String userRating){
		
		UserRatingVO userRatingVO = new UserRatingVO();
		ArrayList<String> reviewJson = new ArrayList<String>();
		try {
			userRatingVO = mapper.readValue(userRating, UserRatingVO.class);
			System.out.println(userRatingVO);
			ReviewVO review1 = new ReviewVO();
			review1.setUser(userRatingVO.getUser_email());
			review1.setDimension(userRatingVO.getDimension1());
			review1.setRating(userRatingVO.getRating1());
			
			ReviewVO review2 = new ReviewVO();
			review2.setUser(userRatingVO.getUser_email());
			review2.setDimension(userRatingVO.getDimension2());
			review2.setRating(userRatingVO.getRating2());
			
			ReviewVO review3 = new ReviewVO();
			review3.setUser(userRatingVO.getUser_email());
			review3.setDimension(userRatingVO.getDimension3());
			review3.setRating(userRatingVO.getRating3());
			
			ReviewVO review4 = new ReviewVO();
			review4.setUser(userRatingVO.getUser_email());
			review4.setDimension(userRatingVO.getDimension4());
			review4.setRating(userRatingVO.getRating4());
			
//			ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
//			reviewList.add(review1);
//			reviewList.add(review2);
//			reviewList.add(review3);
//			reviewList.add(review4);
			
			reviewJson.add(mapper.writeValueAsString(review1));
			reviewJson.add(mapper.writeValueAsString(review2));
			reviewJson.add(mapper.writeValueAsString(review3));
			reviewJson.add(mapper.writeValueAsString(review4));
			
//			for(ReviewVO rev : reviewList){
//				reviewJson = reviewJson + mapper.writeValueAsString(rev) + ",";
//				
//			}
//			reviewJson = reviewJson.substring(0, reviewJson.length()-1);
//
//			System.out.println(reviewJson);
			RatingDao ratingDao = new RatingDao();
			ratingDao.addRating(userRatingVO.getAd_id(), reviewJson);
			
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
