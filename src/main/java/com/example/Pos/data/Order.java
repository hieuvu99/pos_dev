package com.example.Pos.data;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name="OID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderID;
	@Column(name="TIME")
	private Timestamp time;
	@Column(name = "COST")
	private double cost;
	@Column(name = "ORDERNO")
	private int orderNo;
	@Column(name = "PAYMENT_STATUS")
	private String paymentStatus;
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", time=" + time + ", cost=" + cost + ", orderNo=" + orderNo
				+ ", paymentStatus=" + paymentStatus + ", paymentType=" + paymentType + "]";
	}

}
