package com.example.Pos.data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
	Optional<Order> findTopByOrderByTimeDesc();
}
