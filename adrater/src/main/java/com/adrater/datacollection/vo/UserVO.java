package com.adrater.datacollection.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

public class UserVO {
	
	@JsonIgnore
	private String fname;
	
	@JsonIgnore
	private String lname;
	
	private String email;
	private String pwd;
	
	@JsonIgnore
	private String _id;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
