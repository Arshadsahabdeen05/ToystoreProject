package com.examly.toystore.repository;

import com.examly.toystore.model.Discount;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
        @Query("SELECT d FROM Discount d WHERE d.name LIKE %:name%")
            List<Discount> findByName(@Param("name") String name);

                @Query("SELECT d FROM Discount d WHERE d.percentage >= :minPercentage")
                    List<Discount> findByMinimumPercentage(@Param("minPercentage") float minPercentage);
}

