package com.example.Pos.webservice;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pos.business.OrderService;
import com.example.Pos.data.Order;
import com.example.Pos.data.OrderItem;
//import com.example.Pos.data.OrderItem;
import com.example.Pos.data.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/api")
public class OrderWebserviceController {
	private final OrderService orderService;

	public OrderWebserviceController(OrderService orderService) {
		this.orderService = orderService;
	}

	@CrossOrigin(origins = "http://localhost:3000") // Replace with your Next.js development server URL
	@RequestMapping(path = "/create-order", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
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
	}
	
	@CrossOrigin(origins = "http://localhost:3000") // Replace with your Next.js development server URL
	@RequestMapping(path = "/orders", method = RequestMethod.GET)
	public List<Order> getOrders(Model model) {
		return this.orderService.getAllOrder();
	}
	
	@CrossOrigin(origins = "http://localhost:3000") // Replace with your Next.js development server URL
	@RequestMapping(path = "/order", method = RequestMethod.GET)
	public List<OrderItem> getOrder(@RequestParam String orderID, Model model) {
//		Order order = this.orderService.getOrderInfo(Long.parseLong(orderID));
//		if (order!=null)
			return this.orderService.getOrderItem(Long.parseLong(orderID));
//		return order;
	}
}
