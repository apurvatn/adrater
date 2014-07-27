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

/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AdVO> getAllAds(){

		AdManager adManager = new AdManager();
		List<AdVO> adList = adManager.getAllAds();
		return adList;
	}*/

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Viewable getAds(@Context HttpServletRequest httpRequest){
		if(httpRequest.getParameter("id") != null){
			AdManager adManager = new AdManager();
			AdVO adVO = adManager.getAdDetails(httpRequest.getParameter("id"));
			System.out.println(adVO);
			
			httpRequest.setAttribute("adVO", adVO);
			//////
			return new Viewable("/star.jsp");
		}
		int part = 0;
		if(httpRequest.getParameter("part") != null) part = (int)Long.parseLong(httpRequest.getParameter("part"));
			
		AdManager adManger = new AdManager();
		List<AdVO> adList =  adManger.getAds(part);
		httpRequest.setAttribute("adlist", adList);
		httpRequest.setAttribute("part", part);
			/////////////////////////////
		return new Viewable("/ads.jsp");
	}
	

}