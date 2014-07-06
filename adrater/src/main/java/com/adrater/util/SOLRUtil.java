package com.adrater.util;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CollectionAdminResponse;
import org.apache.solr.client.solrj.response.CoreAdminResponse;

/**
 * This class is a utility class for providing the admin related functionality
 * in solr
 * @author Suraj Shetty
 *
 */

public class SOLRUtil {
	
	
	private static void createCore(String coreName){
		
		String hostURL = ToolPropertiesUtil.getProperty("SOLR_HOST");
		//create instance of sole server instance
		HttpSolrServer server = new HttpSolrServer(hostURL);
		
		//create a newc ollection
		//CollectionAdminResponse adminResponse = CollectionAdminRequest.
		
		 
		
	}

}
