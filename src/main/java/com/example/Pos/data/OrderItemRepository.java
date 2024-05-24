package com.example.Pos.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, ProductItemKey>{
	 List<OrderItem> findByOrderOrderID(Long orderId);
}
