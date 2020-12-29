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
	private String productType;
	private String productColor;
	private String productSize;
	private String productBrand;
	private String productPrice;
	private String productQty;
	private String productSaller;
	private String productDiscription;
	private float productAvrRating;
	
	
	public ProductWM(String productId, String productName, Binary productImage, String productType, String productColor,
			String productSize, String productBrand, String productPrice, String productQty, String productSaller,
			String productDiscription, float productAvrRating) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productType = productType;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productBrand = productBrand;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
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
	@Override
	public String toString() {
		return "ProductWM [productId=" + productId + ", productName=" + productName + ", productImage=" + productImage
				+ ", productType=" + productType + ", productColor=" + productColor + ", productSize=" + productSize
				+ ", productBrand=" + productBrand + ", productPrice=" + productPrice + ", productQty=" + productQty
				+ ", productSaller=" + productSaller + ", productDiscription=" + productDiscription
				+ ", productAvrRating=" + productAvrRating + "]";
	}
	
}
