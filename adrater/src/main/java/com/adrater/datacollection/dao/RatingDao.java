package com.adrater.datacollection.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class RatingDao {

	
	private static final String HOST = "ds033018.mongolab.com";//"localhost";
	private static final int PORT = 33018;//27017;
	private static final String DB_NAME = "craigslist";
	private static final String AD_COLLECTION_NAME = "ad";
	private static final String USERNAME ="cmpe295b";
	private static final String PASSWORD = "cmpe295b";
	
	private DB db;
	
	public RatingDao() throws UnknownHostException{
		MongoClient client = new MongoClient(HOST, PORT);
		db = client.getDB(DB_NAME);
		db.authenticateCommand(USERNAME, PASSWORD.toCharArray());
	}
	
	public void addRating(String adId, String user){
		
	}
}
