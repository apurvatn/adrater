package com.adrater.datacollection.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class RatingDao {

	private static final String HOST = "localhost";// "localhost";
	private static final int PORT = 27017;// 27017;
	private static final String DB_NAME = "craigslist";
	private static final String AD_COLLECTION_NAME = "ad";
	private static final String AVG_RATING_COLLECTION = "avg";
	private static final String USERNAME = "cmpe295b";
	private static final String PASSWORD = "cmpe295b";
	private static final String REVIEW_FIELD = "reviews";

	private DB db;

	public RatingDao() throws UnknownHostException {
		MongoClient client = new MongoClient(HOST, PORT);
		db = client.getDB(DB_NAME);
		// db.authenticateCommand(USERNAME, PASSWORD.toCharArray());
	}

	public void addRating(String adId, ArrayList<String> reviews) {

		DBCollection adCollection = db.getCollection(AD_COLLECTION_NAME);
		BasicDBObject adQuery = new BasicDBObject("id", adId);
		DBCursor dbCursor = adCollection.find(adQuery);
		if (dbCursor.size() != 0) {
			for (int i = 0; i < reviews.size(); i++) {
				BasicDBObject review = new BasicDBObject(REVIEW_FIELD,
						(BasicDBObject) JSON.parse(reviews.get(i)));
				DBObject updateQuery = new BasicDBObject("$push", review);
				WriteResult result = adCollection.update(adQuery, updateQuery);
				System.out.println(result + "--------- Updated Ad document");
			}
		} else {
			System.out.println("No ad with this id exists!");
		}

		// DBObject[] reviewList = new DBObject[reviews.size()];
		// //BasicDBObject reviewObject = new BasicDBObject(REVIEW_FIELD, new
		// BasicDBObject("user",
		// user).append("dimension",reviews.get("dimension1")).append("rating",
		// val));
		// for(int i =0; i < reviews.size(); i++){
		// BasicDBObject review = new BasicDBObject(REVIEW_FIELD,
		// (BasicDBObject) JSON.parse(reviews.get(0)));
		// reviewList[i] = review;
		// }
		//
		// DBObject updateQuery = new BasicDBObject("$push", reviewList);
		//
		// System.out.println(result + "--------- Updated Ad document");

	}

	public void getAvgRating(String ad_id) {

		DBCollection adCollection = db.getCollection(AD_COLLECTION_NAME);
		DBCollection avgCollection = db.getCollection(AVG_RATING_COLLECTION);

		DBObject match = new BasicDBObject("$match", new BasicDBObject("id",
				ad_id));

		DBObject reviewField = new BasicDBObject("reviews", 1);
		reviewField.put("id", 1);
		reviewField.put("_id", 0);
		DBObject project = new BasicDBObject("$project", reviewField);
		DBObject unwind = new BasicDBObject("$unwind", "$reviews");

		DBObject groupFields = new BasicDBObject( "_id", "$reviews.dimension");
		groupFields.put("average", new BasicDBObject( "$avg", "$reviews.rating"));
		DBObject group = new BasicDBObject("$group", groupFields);

		AggregationOutput output = adCollection.aggregate(match, project,
				unwind, group);
		for (DBObject result : output.results()) {
			BasicDBObject avgEntry = new BasicDBObject("ad", ad_id).append("dimension", result.get("_id")).append("average", result.get("average"));
			WriteResult avg = avgCollection.insert(avgEntry);
		}
	}
}
