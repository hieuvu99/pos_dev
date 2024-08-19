package com.example.Pos.business;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.Pos.data.Order;
import com.example.Pos.data.OrderItem;
import com.example.Pos.data.OrderItemRepository;
//import com.example.Pos.data.OrderItem;
//import com.example.Pos.data.OrderItemRepository;
import com.example.Pos.data.OrderRepository;
import com.example.Pos.data.Product;
import com.example.Pos.data.ProductRepository;
import com.example.Pos.exception.OrderNotFoundException;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final ProductRepository productRepository;

	public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository,
			ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
		this.productRepository = productRepository;
	}

	public List<Order> getAllOrder(int pageNumber) {
		return this.orderRepository.findAllByOrderByTimeDesc( PageRequest.of(pageNumber, 10));
	}

	public Order getOrderInfo(long OrderID) {
		Optional<Order> orderOptional = this.orderRepository.findById(OrderID);
		if (!(orderOptional.get() == null))
			return orderOptional.get();
		else
			throw new OrderNotFoundException("Order with ID " + OrderID + " not found.");
	}
	
	public List<OrderItem> getOrderItem(long OrderID){
		return this.orderItemRepository.findByOrderOrderID(OrderID);
	}

	public Integer getOrderNo(Order order) {
		Optional<Order> lastOrderOptional = this.orderRepository.findTopByOrderByTimeDesc();

		try {
			boolean isSameDate = lastOrderOptional.get().getTime().toLocalDateTime().toLocalDate()
					.isEqual(order.getTime().toLocalDateTime().toLocalDate());
			if (isSameDate && !lastOrderOptional.isEmpty()) {
				return lastOrderOptional.get().getOrderNo() + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return 1;
	}

	public Order addOrder(Order order) {
		try {
			if (order == null)
				throw new RuntimeException("Order can not be empty");

			else {
				order.setTime(new Timestamp(System.currentTimeMillis()));
				order.setOrderNo(this.getOrderNo(order));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return this.orderRepository.save(order);
	}


	public void addOrderItem(OrderItem[] orderItems, Order order) {
//		System.out.println(order.toString());
		try {
			Stream<OrderItem> orderItemsStm = Arrays.stream(orderItems);
			orderItemsStm.forEach(orderItem -> {
				Optional<Product> productOptional = productRepository
						.findById(orderItem.getOrderItemID().getProductID());
				orderItem.getOrderItemID().setOrderID(order.getOrderID());
				orderItem.setOrder(order);
				orderItem.setProduct(productOptional.get());
				orderItemRepository.save(orderItem);
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
