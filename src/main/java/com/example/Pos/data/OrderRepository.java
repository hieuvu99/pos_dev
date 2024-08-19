package com.example.Pos.data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
	Optional<Order> findTopByOrderByTimeDesc();

	List<Order> findAllByOrderByTimeDesc(Pageable pageable);
//	Timestamp time, 
	
//	@Query("SELECT o FROM Order o LEFT JOIN FETCH o.orderItems WHERE o.orderID = :orderId")
//	Optional<OrderItem> findOrderWithorderItemsByOrderID(long orderID);
}

//"SELECT o FROM Order o LEFT JOIN FETCH o.orderItems WHERE o.orderID = :orderId""
//Check the above Query Cause it really Wrong
//Run Query on work bench please
///