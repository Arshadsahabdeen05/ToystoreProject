package com.examly.toystore.repository;

import com.examly.toystore.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer> {

        @Query("SELECT o FROM Order o WHERE o.status like %:status%")
        List<Order> findByStatus(@Param("status") String status);

        @Query("SELECT o FROM Order o WHERE o.totalAmount >= :minAmount")
        List<Order> findByMinimumAmount(@Param("minAmount") float minAmount);

}

