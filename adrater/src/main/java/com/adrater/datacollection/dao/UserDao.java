package com.adrater.datacollection.dao;

import java.net.UnknownHostException;

import com.adrater.datacollection.vo.UserVO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoURI;
import com.mongodb.MongoException.DuplicateKey;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

/**
 * Data access layer for User object
 * @author apurvatn
 *
 */
public class UserDao {

	private static final String HOST = "ds033018.mongolab.com";// "localhost";
	private static final int PORT = 33018;// 27017;
	private static final String DB_NAME = "craigslist";
	private static final String USER_COLLECTION_NAME = "user";
	private static final String USERNAME = "cmpe295b";
	private static final String PASSWORD = "cmpe295b";

	private DB db;

	public UserDao() throws UnknownHostException {

		MongoClient client = new MongoClient(HOST, PORT);
		db = client.getDB(DB_NAME);
		db.authenticateCommand(USERNAME, PASSWORD.toCharArray());
		
//		String username = "cmpe295b";
//    	char[] password = {'c','m','p','e','2','9','5','b'};
//    	
//    	//connect to the Mongolab
//    	String textUri = "mongodb://cmpe295b:cmpe295b@ds033018.mongolab.com:33018/craigslist";
//    	MongoURI uri  = new MongoURI(textUri); 
//    	Mongo m = new Mongo(uri);
//        // connect to your database
//        DB db = m.getDB( "craigslist" );
//		System.out.println("Connected to database successfully");
//		//authentication
//		boolean auth = db.authenticate(username,password);            			 
//    	System.out.println("Authentication: "+auth);
//    	
//    	DBCollection coll = db.getCollection("user");
//    	System.out.println("Collection selected successfully");
		
		

	}

	public Integer validateUser(UserVO userVO) {
		
		BasicDBObject query = new BasicDBObject("email", userVO.getEmail()).append("pwd", userVO.getPwd());
		DBCollection userCollection = db.getCollection(USER_COLLECTION_NAME);
		DBCursor dbCursor = userCollection.find(query);
		System.out.println(dbCursor.count());
		if(dbCursor.count()!=0){
			return dbCursor.count();
		}
		return 0;
	}
	
	public String getUser(String email){
		BasicDBObject query = new BasicDBObject("email", email);
		DBCollection userCollection = db.getCollection(USER_COLLECTION_NAME);
		DBCursor dbCursor = userCollection.find(query);
		while(dbCursor.hasNext()){
			return dbCursor.next().toString();
		}
		return null;
	}
	
	/**
	 * Inserts a User object into the collection
	 * @param userVo
	 *            - user object represented as String
	 */
	public void addUser(String userVo) {

		try {
			BasicDBObject dbObj = (BasicDBObject) JSON.parse(userVo);
			DBCollection userCollection = db
					.getCollection(USER_COLLECTION_NAME);
			WriteResult testinsertion= userCollection.insert(dbObj);
			System.out.println("get N"+testinsertion.getN());
			System.out.println("get tostring"+testinsertion.toString());
		} catch (DuplicateKey e) {
			System.out.println("A user with this email id already exists");
			e.printStackTrace();
		}

	}

}
