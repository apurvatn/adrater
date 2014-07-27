package com.adrater.datacollection.vo;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.solr.client.solrj.beans.Field;

@XmlRootElement
public class AdVO  {
	@Field("id")
	private String id;
	
	@Field("adHeader_t")
	private String adHeader;
	
	@Field("url")
	private String adLink;
	
	@Field("adDetails_t")
	private String adDetails;
	
	@Field("postDate_dt")
	private String postDate;
	
	@Field("category")
	private String subCategory;
		
	private LocationVO location;
	
	@Field("locationInfo_t")
	private String locationInfo;
	
	public AdVO(){
		
	}
	
	public AdVO(String adHeader, String adLink){
		this.adHeader = adHeader;
		this.adLink = adLink;
	}
	/*@Override
	public String toString(){
		
		return "{id:"+ this.id+ ", header:\""+this.adHeader+"\" , link:\""+this.adLink+"\" , details:\""+this.adDetails+"\" , time:\""+this.postDate+ "\" , category:\""+ this.subCategory+"\", locationInfo:\""+this.locationInfo+ "\", location:"+this.location+"}";
	}*/
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getAdHeader() {
		return adHeader;
	}
	
	public void setAdHeader(String adHeader) {
		this.adHeader = adHeader;
	}
	public String getAdLink() {
		return adLink;
	}
	public void setAdLink(String adLink) {
		this.adLink = adLink;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getAdDetails() {
		return adDetails;
	}

	public void setAdDetails(String adDetails) {
		this.adDetails = adDetails;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public LocationVO getLocation() {
		return location;
	}

	public void setLocation(LocationVO location) {
		this.location = location;
	}

	public String getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
	}
		

}
