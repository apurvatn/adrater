package com.adrater.manager;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.adrater.datacollection.dao.AdDao;
import com.adrater.datacollection.vo.AdVO;

/**
 * This is a manager class for handling the ads
 * @author Suraj Shetty
 *
 */

public class AdManager {

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
	
}
