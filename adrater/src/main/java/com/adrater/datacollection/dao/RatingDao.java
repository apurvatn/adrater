package com.adrater.datacollection.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class RatingDao {

	
	private static final String HOST = "localhost";//"localhost";
	private static final int PORT = 27017;//27017;
	private static final String DB_NAME = "craigslist";
	private static final String AD_COLLECTION_NAME = "ad";
	private static final String USERNAME ="cmpe295b";
	private static final String PASSWORD = "cmpe295b";
	private static final String REVIEW_FIELD = "reviews";
	
	private DB db;
	
	public RatingDao() throws UnknownHostException{
		MongoClient client = new MongoClient(HOST, PORT);
		db = client.getDB(DB_NAME);
		//db.authenticateCommand(USERNAME, PASSWORD.toCharArray());
	}
	
	public void addRating(String adId, ArrayList<String> reviews){
		
		DBCollection adCollection = db
				.getCollection(AD_COLLECTION_NAME);
		BasicDBObject adQuery = new BasicDBObject("id", adId);
		
		for(int i =0; i < reviews.size(); i++){
			BasicDBObject review = new BasicDBObject(REVIEW_FIELD, (BasicDBObject) JSON.parse(reviews.get(i)));
			DBObject updateQuery = new BasicDBObject("$push", review);
			WriteResult result = adCollection.update(adQuery, updateQuery);
			System.out.println(result + "--------- Updated Ad document");
		}
		
//		DBObject[] reviewList = new DBObject[reviews.size()];
//		//BasicDBObject reviewObject = new BasicDBObject(REVIEW_FIELD, new BasicDBObject("user", user).append("dimension",reviews.get("dimension1")).append("rating", val));
//		for(int i =0; i < reviews.size(); i++){
//			BasicDBObject review = new BasicDBObject(REVIEW_FIELD, (BasicDBObject) JSON.parse(reviews.get(0)));
//			reviewList[i] = review;
//		}
//		
//		DBObject updateQuery = new BasicDBObject("$push", reviewList);
//		
//		System.out.println(result + "--------- Updated Ad document");
		
	}
}
