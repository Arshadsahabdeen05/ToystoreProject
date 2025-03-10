package com.examly.toystore.repository;

import com.examly.toystore.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {
        @Query("SELECT t FROM Toy t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
            List<Toy> searchByName(String keyword);

               @Query("SELECT t FROM Toy t WHERE t.category LIKE %:category%")
               List<Toy> findByCategoryLike(@Param("category") String category);

               @Query("SELECT t FROM Toy t WHERE t.price BETWEEN :minPrice AND :maxPrice")
               List<Toy> findByPriceRange(@Param("minPrice") float minPrice, @Param("maxPrice") float maxPrice);


}

