package com.group2.wmproducts.service;

public class ProductWM {
	private String pId;
	private String pName;
	private String []pCatagory;
	private String pPrice;
	private String pQty;
	private String pSaller;
	private String pDiscription;
	private float pAvrRating;
	
	public ProductWM(String pId, String pName, String[] pCatagory, String pPrice, String pQty, String pSaller,
			String pDiscription, float pAvrRating) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pCatagory = pCatagory;
		this.pPrice = pPrice;
		this.pQty = pQty;
		this.pSaller = pSaller;
		this.pDiscription = pDiscription;
		this.pAvrRating = pAvrRating;
	}
	/**
	 * @return the pId
	 */
	public String getpId() {
		return pId;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setpId(String pId) {
		this.pId = pId;
	}
	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}
	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	/**
	 * @return the pCatagory
	 */
	public String[] getpCatagory() {
		return pCatagory;
	}
	/**
	 * @param pCatagory the pCatagory to set
	 */
	public void setpCatagory(String[] pCatagory) {
		this.pCatagory = pCatagory;
	}
	/**
	 * @return the pPrice
	 */
	public String getpPrice() {
		return pPrice;
	}
	/**
	 * @param pPrice the pPrice to set
	 */
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	/**
	 * @return the pQty
	 */
	public String getpQty() {
		return pQty;
	}
	/**
	 * @param pQty the pQty to set
	 */
	public void setpQty(String pQty) {
		this.pQty = pQty;
	}
	/**
	 * @return the pSaller
	 */
	public String getpSaller() {
		return pSaller;
	}
	/**
	 * @param pSaller the pSaller to set
	 */
	public void setpSaller(String pSaller) {
		this.pSaller = pSaller;
	}
	/**
	 * @return the pDiscription
	 */
	public String getpDiscription() {
		return pDiscription;
	}
	/**
	 * @param pDiscription the pDiscription to set
	 */
	public void setpDiscription(String pDiscription) {
		this.pDiscription = pDiscription;
	}
	/**
	 * @return the pAvrRating
	 */
	public float getpAvrRating() {
		return pAvrRating;
	}
	/**
	 * @param pAvrRating the pAvrRating to set
	 */
	public void setpAvrRating(float pAvrRating) {
		this.pAvrRating = pAvrRating;
	}
	
}
