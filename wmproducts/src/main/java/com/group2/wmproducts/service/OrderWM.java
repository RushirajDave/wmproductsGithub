package com.group2.wmproducts.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class OrderWM {
	@Id
	private String orderId;
	private String userId;
	private String productId;
	private String productQty;
	private Integer totalPrice;
	private String orderAddress;
	public OrderWM(String orderId, String userId, String productId, String productQty, Integer totalPrice,
			String orderAddress) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.productQty = productQty;
		this.totalPrice = totalPrice;
		this.orderAddress = orderAddress;
	}
	public OrderWM(String userId, String productId, String productQty, Integer totalPrice, String orderAddress) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.productQty = productQty;
		this.totalPrice = totalPrice;
		this.orderAddress = orderAddress;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductQty() {
		return productQty;
	}
	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	@Override
	public String toString() {
		return "OrderWM [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", productQty="
				+ productQty + ", totalPrice=" + totalPrice + ", orderAddress=" + orderAddress + "]";
	}
	
}
