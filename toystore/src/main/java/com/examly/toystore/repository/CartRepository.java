package com.examly.toystore.repository;

import com.examly.toystore.model.Cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
        @Query("SELECT c FROM Cart c WHERE c.cartId = :cartId")
            Cart findCartById(@Param("cartId") int cartId);
                
                @Query("SELECT c FROM Cart c WHERE c.quantity >= :minQuantity")
                    List<Cart> findByMinimumQuantity(@Param("minQuantity") int minQuantity);
}


