package com.adrater.datacollection.dao;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.adrater.datacollection.vo.AdVO;
import com.adrater.datacollection.vo.LocationVO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoURI;
import com.mongodb.util.JSON;

/**
 * This class is provides the data access layer for the ad details
 * @author Suraj Shetty
 *
 */
public class AdDao {

	
	private static final String HOST = "ds033018.mongolab.com";//"localhost";
	private static final int PORT = 33018;//27017;
	private static final String DB_NAME = "craigslist";
	private static final String AD_COLLECTION_NAME = "ad";
	private static final String USERNAME ="cmpe295b";
	private static final String PASSWORD = "cmpe295b";
	
	private DB db;
	
	
	public AdDao() throws UnknownHostException{
/*String username = "cmpe295b";
    	char[] password = {'c','m','p','e','2','9','5','b'};
    	
    	//connect to the Mongolab
    	String textUri = "mongodb://cmpe295b:cmpe295b@ds033018.mongolab.com:33018/craigslist";
    	MongoURI uri  = new MongoURI(textUri); 
    	Mongo m = new Mongo(uri);
        // connect to your database
        DB db = m.getDB( "craigslist" );
		System.out.println("Connected to database successfully");
		//authentication
		boolean auth = db.authenticate(username,password);            			 
System.out.println("Authentication: "+auth);
//   DBCollection coll = db.getCollection("user");
System.out.println("Collection selected successfully");
//    	
*/			
		
//		
		MongoClient client = new MongoClient(HOST, PORT);
		
		db = client.getDB(DB_NAME);
		db.authenticateCommand(USERNAME, PASSWORD.toCharArray());
//		
	}
	/**
	 * This method inserts an ad which is in form of a JSON string into the
	 * collection
	 * @param adVo
	 */
	public void insertAd(String adVo){
		
		BasicDBObject dbObj = (BasicDBObject)JSON.parse(adVo);
		DBCollection adCollection =  db.getCollection(AD_COLLECTION_NAME);
		adCollection.insert(dbObj);
		
	}
	/**
	 * This method returns a list of all the ads. In case of any exception or
	 * if there are no items found in the collection, the method would return
	 * an empty list
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public List<AdVO> getAllAds() throws JsonParseException, JsonMappingException, IOException{
		
		DBCollection adCollection = db.getCollection(AD_COLLECTION_NAME);
		
		//set the fields  that are required
		BasicDBObject fields = new BasicDBObject().append("_id",false).append("id", true).append("adHeader", true).append("adLink", true)
				.append("adDetails", true).append("subCategory", true).append("location", true).append("postDate", true);
		
		
		DBCursor cursor = adCollection.find(null,fields);
					
		ObjectMapper mapper = new ObjectMapper();
		//list of all the ads
		List<AdVO> adList = new LinkedList<>();
		AdVO adVo=null;
		
		while(cursor.hasNext()){
			String data = cursor.next().toString();
						
			 adVo = mapper.readValue(data, AdVO.class);
			 adList.add(adVo);
						
		}
		return adList;
	}
	
	/**
	 * This methods returns a few ads. The number of ads returned depends on the "count".
	 * The ads that are returned depends on the "startIndex". Starting from the "startIndex", "count" number
	 * of ads are returned to the calling function.
	 * @param startIndex
	 * @param count
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public  List<AdVO> getAds(int startIndex, int count) throws JsonParseException, JsonMappingException, IOException{
		
		DBCollection adCollection = db.getCollection(AD_COLLECTION_NAME);
		
		//set the fields  that are required
		BasicDBObject fields = new BasicDBObject().append("_id",false).append("id", true).append("adHeader", true).append("adLink", true)
				.append("subCategory", true).append("postDate", true);
		
		
		DBCursor cursor = adCollection.find(null,fields).skip(startIndex).limit(count);
					
		ObjectMapper mapper = new ObjectMapper();
		//list of all the ads
		List<AdVO> adList = new LinkedList<>();
		AdVO adVo=null;
		
		while(cursor.hasNext()){
			 adVo = mapper.readValue(cursor.next().toString(), AdVO.class);
			 adList.add(adVo);
						
		}
		return adList;
		
	}
	
	/**
	 * For the given ad id, this method returns the details of the ad to the
	 * calling function
	 * @param adId
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public AdVO getAd( String adId) throws JsonParseException, JsonMappingException, IOException{
		
		DBCollection adCollection = db.getCollection(AD_COLLECTION_NAME);
		//set the required fields that need to be fetched
		BasicDBObject fields = new BasicDBObject().append("_id", false).append("id", true).append("adHeader", true).append("addLink", true)
				.append("subCategory", true).append("location", true).append("postDate", true).append("adDetails", true).append("postDate", true);
		
		//query to find the required doc
		BasicDBObject query = new BasicDBObject("id", "4492497102");
		
		//search for the document 
		DBCursor result = adCollection.find(query, fields);
		
		//map the result into a VO object
		ObjectMapper mapper = new ObjectMapper();
		//assuming the id is unique, we just return one ad
		AdVO adVO = null;
		if(result.hasNext()){
	//		System.out.println(result.next().toString());
			adVO = mapper.readValue(result.next().toString(), AdVO.class);
			
		}
		return adVO;
		
	}
	
	
	
	private void createCollections(){
		
		db.createCollection("ad", new BasicDBObject());
		
	}
	
	private void  getAllCollections(){
		
		Set<String> collSet = db.getCollectionNames();
		for(String collection : collSet){
			System.out.println(collection);
		}
		
	}
	
	private void deleteAllItems(){
		
		DBCollection adCollection = db.getCollection(AD_COLLECTION_NAME);
		DBCursor cursor = adCollection.find();
		
		while(cursor.hasNext()){
			
				BasicDBObject obj =  (BasicDBObject) cursor.next();
				adCollection.remove(obj);
						
		}
	}
<<<<<<< HEAD
			
=======
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		/*AdDao adDo = new AdDao();
		
		List<AdVOOld> adList = adDo.getAllAds();
		
		ObjectMapper mapper = new ObjectMapper();
		
		for(AdVOOld adVOOld: adList ){
			
			AdVO adVO = new AdVO();
			adVO.setAdDetails(adVOOld.getAdDetails());
			adVO.setAdHeader(adVOOld.getAdHeader());
			adVO.setSubCategory(adVOOld.getSubCategory().getCategory());
			adVO.setAdLink(adVOOld.getSubCategory().getLink());
			adVO.setId(adVOOld.getId());
			adVO.setLocationInfo(adVOOld.getLocation().getInfo());
			adVO.setPostDate(adVOOld.getPostDate());
			
			LocationVO vo = new LocationVO();
			vo.setLattitude(adVOOld.getLocation().getLattitude());
			vo.setLongitude(adVOOld.getLocation().getLongitude());
			
			adVO.setLocation(vo);
			mapper.writeValue(new File("output/" + adVO.getId() + ".json"),
					adVO);
			System.out.println(adVO);
		}
		*/
	
		System.out.println("********************************************************");
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("output");
		for(File json : file.listFiles()){
			if(json.isDirectory()) continue;
			AdVO adVo = mapper.readValue(json, AdVO.class);
			System.out.println(mapper.writeValueAsString(adVo));
		}
	}
		
>>>>>>> 0994ee513de8a8b0d2ffbc41e2f318ce8804da7c
}
