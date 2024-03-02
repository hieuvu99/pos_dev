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
	ProductItemKey OderItemID;
	
	@ManyToOne
	@JoinColumn(name = "OID", insertable = false, updatable = false)
	Order order;
	
	@ManyToOne
	@JoinColumn(name = "PID", insertable = false, updatable = false)
	Product product;
	
	@Column(name = "Quantity")
	int quantity;

	public ProductItemKey getOderItemID() {
		return OderItemID;
	}

	public void setOderItemID(ProductItemKey oderItemID) {
		OderItemID = oderItemID;
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
}
