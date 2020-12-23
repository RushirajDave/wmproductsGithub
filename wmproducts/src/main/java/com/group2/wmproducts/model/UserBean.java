package com.group2.wmproducts.model;

public class UserBean {
	public String id;
	public String fName;
	public String lName;
	public String mNumber;
	public String eMail;
	public String uPassword;
	
	
	public UserBean(String fName, String lName, String mNumber, String eMail, String uPassword) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.mNumber = mNumber;
		this.eMail = eMail;
		this.uPassword = uPassword;
	}
	public UserBean() {
		super();
	}
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getmNumber() {
		return mNumber;
	}
	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", fName=" + fName + ", lName=" + lName + ", mNumber=" + mNumber + ", eMail="
				+ eMail + ", uPassword=" + uPassword + "]";
	}
	
}
