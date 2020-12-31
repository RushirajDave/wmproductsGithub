package com.group2.wmproducts.model;

public class OrderBean {
	private String orderId;
	private String userId;
	private String productId;
	private String productQty;
	private String totalPrice;
	private String orderAddress;
	public OrderBean(String orderId, String userId, String productId, String productQty, String totalPrice,
			String orderAddress) {
		super();
		this.orderId = orderId;
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
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
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
		return "OrderBean [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", productQty="
				+ productQty + ", totalPrice=" + totalPrice + ", orderAddress=" + orderAddress + "]";
	}
}
