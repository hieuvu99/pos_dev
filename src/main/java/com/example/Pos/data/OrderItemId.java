package com.example.Pos.data;

import java.io.Serializable;

public class OrderItemId implements Serializable {
	private Long orderID;
	private Long productID;
	
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
}
