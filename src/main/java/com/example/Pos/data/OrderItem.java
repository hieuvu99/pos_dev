package com.example.Pos.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItem {
	@EmbeddedId
	ProductItemKey OrderItemID;
	
	@ManyToOne
	@JoinColumn(name = "OID", insertable = false, updatable = false)
	Order order;
	
	@ManyToOne
	@JoinColumn(name = "PID", insertable = false, updatable = false)
	Product product;
	
	@Column(name = "Quantity")
	int quantity;

	public ProductItemKey getOrderItemID() {
		return OrderItemID;
	}

	public void setOrderItemID(ProductItemKey orderItemID) {
		OrderItemID = orderItemID;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [OrderItemID=" + OrderItemID + ", order=" + order.toString() + ", product=" + product.toString() + ", quantity="
				+ quantity + "]";
	}
}
