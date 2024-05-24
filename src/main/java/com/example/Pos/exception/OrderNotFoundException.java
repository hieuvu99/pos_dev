package com.example.Pos.exception;

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException(String msg) {
		super(msg);
	}
}
