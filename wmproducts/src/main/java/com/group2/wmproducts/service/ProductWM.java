package com.group2.wmproducts.service;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductWM {
	@Id
	private String productId;
	private String productName;
	private Binary productImage;
	private String productCatagory;
	private String productPrice;
	private String productQty;
	private String productSaller;
	private String productDiscription;
	private float productAvrRating;
	
	
	public ProductWM(String productId, String productName, Binary productImage, String productCatagory,
			String productPrice, String productQty, String productSaller, String productDiscription,
			float productAvrRating) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
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
	public float getProductAvrRating() {
		return productAvrRating;
	}
	public void setProductAvrRating(float productAvrRating) {
		this.productAvrRating = productAvrRating;
	}
	
	
}
