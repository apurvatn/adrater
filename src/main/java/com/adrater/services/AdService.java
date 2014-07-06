package com.adrater.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adrater.datacollection.vo.AdVO;
import com.adrater.manager.AdManager;

/**
 * This class provides the REST service for ads 
 * 
 * @author Suraj Shetty
 *
 */
@Path("/ads")
public class AdService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AdVO> getAllAds(){
		
		AdManager adManager = new AdManager();
		List<AdVO> adList = adManager.getAllAds();
		return adList;
	}

}
