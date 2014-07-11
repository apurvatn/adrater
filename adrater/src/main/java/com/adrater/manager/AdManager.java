package com.adrater.manager;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.adrater.datacollection.dao.AdDao;
import com.adrater.datacollection.vo.AdVO;
import com.adrater.util.ToolPropertiesUtil;

/**
 * This is a manager class for handling the ads
 * @author Suraj Shetty
 *
 */

public class AdManager {
	
	//number of ads to be returned
	private int adLimit;
	
	
	public AdManager(){
		
		adLimit = Integer.parseInt(ToolPropertiesUtil.getProperty("ADS_LIMIT"));
		
	}

	/**
	 * Gets all the details of all ads available
	 * @return
	 */
	public List<AdVO> getAllAds(){
		
		try {
			AdDao adDao = new AdDao();
			List<AdVO> adList =  adDao.getAllAds();
			return adList;
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public List<AdVO> getAds( int part ){
		
		int startIndex = adLimit * part;
		
		List<AdVO> adList = null;
		try {
			AdDao adDao = new AdDao();
			adList = adDao.getAds(startIndex, adLimit);
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return adList;
		
		
	}
	
	public static void main(String[] args) {
		
		AdManager manager = new AdManager();
		List<AdVO> adList =  manager.getAds(2);
		
		for(AdVO adVO : adList)
			System.out.println(adVO);
		
	}
	
}
