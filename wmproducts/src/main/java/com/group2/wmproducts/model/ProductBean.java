package com.group2.wmproducts.model;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	private String productId;
	private String productName;
	private Binary productImage;
	private String productImageBase64;
	private String productCatagory;
	private String productPrice;
	private String productQty;
	private String productSaller;
	private String productDiscription;
	private String productAvrRating;
	
	
	public ProductBean() {
		super();
	}
	public ProductBean(String productName, Binary productImage, String productImageBase64, String productCatagory,
			String productPrice, String productQty, String productSaller, String productDiscription,
			String productAvrRating) {
		super();
		this.productName = productName;
		this.productImage = productImage;
		this.productImageBase64 = productImageBase64;
		this.productCatagory = productCatagory;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.productSaller = productSaller;
		this.productDiscription = productDiscription;
		this.productAvrRating = productAvrRating;
	}



	public String getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Binary getProductImage() {
		return productImage;
	}
	public void setProductImage(Binary productImage) {
		this.productImage = productImage;
	}
	public String getProductImageBase64() {
		return productImageBase64;
	}
	public void setProductImageBase64(String productImageBase64) {
		this.productImageBase64 = productImageBase64;
	}
	public String getProductCatagory() {
		return productCatagory;
	}
	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductQty() {
		return productQty;
	}
	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}
	public String getProductSaller() {
		return productSaller;
	}
	public void setProductSaller(String productSaller) {
		this.productSaller = productSaller;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}
	public String getProductAvrRating() {
		return productAvrRating;
	}
	public void setProductAvrRating(String productAvrRating) {
		this.productAvrRating = productAvrRating;
	}
	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + ", productImage=" + productImage
				+ ", productImageBase64=" + productImageBase64 + ", productCatagory=" + productCatagory
				+ ", productPrice=" + productPrice + ", productQty=" + productQty + ", productSaller=" + productSaller
				+ ", productDiscription=" + productDiscription + ", productAvrRating=" + productAvrRating + "]";
	}

	
	
}
