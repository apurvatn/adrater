package com.adrater.datacollection.vo;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.solr.client.solrj.beans.Field;

@XmlRootElement
public class LocationVO {
	
	@Field("lattitude_p")
	private String lattitude;
	
	@Field("longitude_p")
	private String longitude;
	
	public LocationVO(){
		this.lattitude = null;
		this.longitude = null;
	}
	
	public LocationVO(String lattitude, String longitude){
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString(){
		
		return "{lattitude:"+ this.lattitude +" , longitude:" + this.longitude+" }"; 
		
	}
	
}
