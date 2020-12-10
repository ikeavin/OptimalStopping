package com.kevinahlstrom.OptimalStopping;

public class StopObject {

	public String name;
	public boolean isUrl;
	public float score;
	
	//Various constructors, name is the only parameter always required
	public StopObject(String name) {
		this.name = name;
		this.isUrl = isUrl();
	}
	
	public StopObject(String name, boolean isUrl) {
		this.name = name;
		this.isUrl = isUrl;
	}
	
	public StopObject(String name, boolean isUrl, float score) {
		this.name = name;
		this.isUrl = isUrl;
		this.score = score;
	}
	
	public StopObject(String name, float score) {
		this.name = name;
		this.isUrl = isUrl();
		this.score = score;
	}
	
	private boolean isUrl() {
		if(this.name.contains("http") && this.name.contains("://")) {
			return true;
		}
		
		return false;
	}
	
	public void setScore(float score) {
		this.score = score;
	}
	
	public void standardizeScore(float standard) {
		this.score = score/standard ;
	}
}
