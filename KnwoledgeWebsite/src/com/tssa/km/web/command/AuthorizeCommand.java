package com.tssa.km.web.command;

public class AuthorizeCommand {
	public AuthorizeCommand(){
		petName="";
		dob="";
		pageTitle="AUTHRIZATION!!!";
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	private String petName;
	private String dob;
	private String pageTitle;
}
