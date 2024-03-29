package com.example.Pos.data;
import java.util.Set;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "products")
public class Product {
	 @Id
	 @Column(name="PID", columnDefinition = "bigint")
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long productID;
	 @Column(name="PRODUCTNAME")
	 private String productName;
	 @Column(name="PRODUCT_TYPE")
	 private String productType;
	 @Column(name="PRICE")
	 private Double price;
	 
	 @OneToMany(mappedBy = "product")
	 Set<OrderItem> orderItems;
	
	 public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", price='" + price + '\'' +
                '}';
    } 
	 
}
