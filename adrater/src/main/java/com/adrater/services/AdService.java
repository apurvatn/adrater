package com.adrater.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.adrater.datacollection.vo.AdVO;
import com.adrater.manager.AdManager;
import com.sun.jersey.api.view.Viewable;

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
	public List<AdVO> getAllAds( @DefaultValue("0") @QueryParam("part") String part ){
		
		AdManager adManager = new AdManager();
		List<AdVO> adList = adManager.getAds((int)Long.parseLong(part));
		return adList;
	}
	
	@GET
	@Path("ad")
	@Produces(MediaType.APPLICATION_JSON)
	public AdVO getAd (@QueryParam("id") String id){
		System.out.println(id);
		if(id == null || id == "")
			return null;
		
		AdManager adManager = new AdManager();
		return adManager.getAdDetails(id);
 
	}
	
}
