package com.test.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int userid;
	private String username;
	private String email;
	private String phonenumber;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	@Override
	 public String toString() {
		
	  return "{\"id\":\"" + userid + "\",\"name\":\"" + username + "\",\"email\":\""
	    + email + "\",\"phonenumber\":\"" + phonenumber + "\"}";
	 }
}
