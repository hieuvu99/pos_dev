package com.example.Pos.webservice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pos.business.OrderService;
import com.example.Pos.data.Order;
import com.example.Pos.data.OrderItem;
//import com.example.Pos.data.OrderItem;
import com.example.Pos.data.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class OrderWebserviceController {
	private final OrderService orderService;

	public OrderWebserviceController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(path = "/create-order", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
//	public void createOrder(@RequestBody OrderItem[] orderItems, Order order) {
	public void createOrder(@RequestBody Map<String, Object> requestBody) {
		ObjectMapper objectMapper = new ObjectMapper();
		OrderItem[] orderItems = objectMapper.convertValue(
	            requestBody.get("orderItems"),
	            OrderItem[].class
	    );
		Order order = objectMapper.convertValue( 
				requestBody.get("order"),
	            Order.class);
		
		order = this.orderService.addOrder(order);
		this.orderService.addOrderItem(orderItems, order);

//		System.out.println(requestBody);
//		System.out.println(orderItems[0].toString());
	}
}
