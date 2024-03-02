package com.example.Pos.data;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
@Embeddable
public class ProductItemKey implements Serializable {
	
	Long OID;
	
	Long PID;

	public Long getOrderID() {
		return OID;
	}

	public void setOrderID(Long orderID) {
		OID = orderID;
	}

	public Long getProductID() {
		return PID;
	}

	public void setProductID(Long productID) {
		PID = productID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(OID, PID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductItemKey other = (ProductItemKey) obj;
		return Objects.equals(OID, other.OID) && Objects.equals(PID, other.PID);
	}
	
}
