package com.anzen.bean;

public class File {
	 
	private String route; 
	private String nameFile; 
	private String bucketName;
	 
	
	public File(String route, String nameFile, String bucketName) {
		super();
		this.route = route;
		this.nameFile = nameFile;
		this.bucketName = bucketName;
	}
	
	
	public File(String nameFile, String bucketName) {
		super();
		this.nameFile = nameFile;
		this.bucketName = bucketName;
	}


	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	
	

}
