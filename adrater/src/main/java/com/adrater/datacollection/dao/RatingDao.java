package com.adrater.datacollection.dao;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class RatingDao {

	
	private static final String HOST = "ds033018.mongolab.com";//"localhost";
	private static final int PORT = 33018;//27017;
	private static final String DB_NAME = "craigslist";
	private static final String AD_COLLECTION_NAME = "ad";
	private static final String USERNAME ="cmpe295b";
	private static final String PASSWORD = "cmpe295b";
	private static final String REVIEW_FIELD = "reviews";
	
	private DB db;
	
	public RatingDao() throws UnknownHostException{
		MongoClient client = new MongoClient(HOST, PORT);
		db = client.getDB(DB_NAME);
		db.authenticateCommand(USERNAME, PASSWORD.toCharArray());
	}
	
	public boolean addRating(String adId, String reviews){
		
		DBCollection adCollection = db
				.getCollection(AD_COLLECTION_NAME);
		BasicDBObject adQuery = new BasicDBObject("id", adId);
		//BasicDBObject reviewObject = new BasicDBObject(REVIEW_FIELD, new BasicDBObject("user", user).append("dimension",reviews.get("dimension1")).append("rating", val));
		DBObject reviewArray = (DBObject) JSON.parse(reviews);
		DBObject updateQuery = new BasicDBObject("$push", reviewArray);
		adCollection.update(adQuery, updateQuery);
		
		return false;
	}
}
