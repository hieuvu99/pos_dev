package com.example.Pos.webservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pos.business.OrderService;
import com.example.Pos.data.Order;
//import com.example.Pos.data.OrderItem;
import com.example.Pos.data.Product;

@RestController
@RequestMapping("/api")
public class OrderWebserviceController {
//	private final OrderService orderService;
//
//	public OrderWebserviceController(OrderService orderService) {
//		this.orderService = orderService;
//	}
//
//	@RequestMapping(path = "/create-order", method = RequestMethod.POST)
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public void createOrder(@RequestBody OrderItem[] orderItems) {
////		this.orderService.addOrder(orderItems[0].getOrder());
//		this.orderService.addOrderItem(orderItems);
//	}
}
