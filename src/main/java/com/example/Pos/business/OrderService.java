package com.example.Pos.business;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.Pos.data.Order;
import com.example.Pos.data.OrderItem;
import com.example.Pos.data.OrderItemRepository;
//import com.example.Pos.data.OrderItem;
//import com.example.Pos.data.OrderItemRepository;
import com.example.Pos.data.OrderRepository;
import com.example.Pos.data.Product;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;

	public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
	}
	
	public List<Order> getAllOrder(){
		return this.orderRepository.findAll();
	}
	
	public Order addOrder(Order order) {
		try {
			if(order == null)
				throw new RuntimeException("Order can not be empty");
			
			else return this.orderRepository.save(order);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Order getOrder(Long OrderNumber) {
		Optional<Order> orderOptional = this.orderRepository.findById(OrderNumber);
		if(orderOptional.isEmpty())
			return orderOptional.get();
		else throw new RuntimeException("Can not find the order");
	}
	
	public void addOrderItem(OrderItem[] orderItems) {
		System.out.println();
	}
	
}
