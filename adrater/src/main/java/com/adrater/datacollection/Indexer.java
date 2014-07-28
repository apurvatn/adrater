package com.adrater.datacollection;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.codehaus.jackson.map.ObjectMapper;

import com.adrater.datacollection.dao.AdDao;
import com.adrater.datacollection.vo.AdVO;

public class Indexer {
	
	private static final String HOST = "http://localhost:8983/solr/";
	
	private HttpSolrServer server;
	
	private static final Map<FIELDS, String> SOLR_FIELD_MAP = new HashMap<FIELDS, String>();
	
	public static enum FIELDS {
		ID,
		AD_HEADER,		
		AD_DETAIL,
		POST_DATE,
		CATEGORY
	}
	
	static {
		
		SOLR_FIELD_MAP.put(FIELDS.ID, "id");
		SOLR_FIELD_MAP.put(FIELDS.AD_HEADER, "adHeader_t");
		SOLR_FIELD_MAP.put(FIELDS.AD_DETAIL, "adDetails_t");
		SOLR_FIELD_MAP.put(FIELDS.POST_DATE, "postDate_dt");
		SOLR_FIELD_MAP.put(FIELDS.CATEGORY, "category");
		
	}
	
	public Indexer() {
			
		server = new HttpSolrServer(HOST);
		
				
	}
	
	public void getAllDocs() throws SolrServerException{
		//query to get all documents
		SolrQuery query = new SolrQuery("*:*");
		
		
		QueryResponse queryResponse = server.query(query); 
		SolrDocumentList docList = queryResponse.getResults();
		
		for(int i = 0; i < docList.size(); i++){
			System.out.println(docList.get(i));
		}
		
	}
	
	
	public void  deleteAllDocs(){
		
			
		try {
			UpdateResponse response = server.deleteByQuery("*:*");
			server.commit();
			System.out.println(response.getStatus());
			
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void extractFromMongo() throws IOException, SolrServerException{
		
		AdDao adDao = new AdDao();
		List<AdVO> adLists = adDao.getAllAds();
		
		for(AdVO adVO: adLists){
			
			server.addBean(adVO);
			System.out.println("Adding  "+ adVO);
		}
		
		server.commit();
	}
	
	private void addDocuments(){
		//add the ad details for indexing
		
		File dir = new File("output");
		
		File [] jsonFiles = dir.listFiles();
		ObjectMapper mapper = new ObjectMapper();
		
		for(File adInfoFile : jsonFiles){
			if(adInfoFile.isDirectory()) continue;
				try {
					AdVO adVo = mapper.readValue(adInfoFile, AdVO.class);
			//		adVo.setPostDate(adVo.getPostDate()+"Z");
					System.out.println(adVo);
					server.addBean(adVo);
					
				} catch (IOException e) {
					System.err.println("Exception in parsing to object");
				} catch (SolrServerException e) {
					System.err.print("SOLR exception");
				}
		
				
		}
		
		try {
			server.commit();
		} catch (Exception e) {
			System.err.println("Error during commit");
		}
		
		//method 2: using the HTTPClient to add new documents
		/*
		DefaultHttpClient httpClient = null;
		HttpPost postReq = new HttpPost(HOST+"update/json");
		
		//get the JSON entities
		
		for(File adInfoFile : jsonFiles){
			
				try {
					AdVO adVo = mapper.readValue(adInfoFile, AdVO.class);
					
					httpClient = new DefaultHttpClient(); 
					StringEntity entity = new StringEntity(adVo.toString());
					entity.setContentType("application/json");
					postReq.setEntity(entity);
					HttpResponse response = httpClient.execute(postReq);
					System.out.println(response.toString());
					httpClient.close();
					
				} catch (IOException e) {
					System.err.println("Exception in parsing to object");
				}
				
		}
		*/
	}
	
	public void findDocument(Map<FIELDS, String> queryMap){
		
 		SolrQuery query = new SolrQuery();
		query.setQuery( SOLR_FIELD_MAP.get(FIELDS.AD_DETAIL) + ":" +queryMap.get(FIELDS.AD_DETAIL));
	
		
		String [] fields = null;
		String [] filter = new String [queryMap.size()];
		
		//construct the filter
		int index = 0;
		for(Entry<FIELDS, String> entry : queryMap.entrySet()){
			
			if(entry.getKey().equals(FIELDS.AD_DETAIL)) continue;
			filter[index] = SOLR_FIELD_MAP.get(entry.getKey()) + ":" + entry.getValue();
			
			index++;
		}
		
		//get the fields that needs to be returned as part of the result set
		fields = SOLR_FIELD_MAP.values().toArray((new String[SOLR_FIELD_MAP.size()]));
				
		query.setFilterQueries(filter);
		query.setFields(fields);
		
		QueryResponse response = null;
		try {
			response = server.query(query);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	SolrDocumentList  docList = response.getResults();
		List<AdVO> adList = response.getBeans(AdVO.class);
		
		
		for(int i = 0 ; i< adList.size(); i++){
			System.out.println(adList.get(i));
		}
		
	}
	
	

	
	public static void main(String[] args) throws SolrServerException {
		
		Indexer indexer = new Indexer();
		
	//	indexer.deleteAllDocs();
	//	indexer.addDocuments();
	//	indexer.getAllDocs();
		/*try {
			indexer.extractFromMongo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//querying for some document
		Map<FIELDS, String> query = new HashMap<Indexer.FIELDS, String>();
		query.put(FIELDS.AD_DETAIL, "plumber");
		query.put(FIELDS.CATEGORY, "household services");
		
		indexer.findDocument(query);
		
	}

}
