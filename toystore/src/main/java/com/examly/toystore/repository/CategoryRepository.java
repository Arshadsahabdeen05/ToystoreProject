package com.examly.toystore.repository;

import com.examly.toystore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
        @Query("SELECT c FROM Category c WHERE c.id = :id")
            Category findCategoryById(@Param("id") int id);

                @Query("SELECT c FROM Category c WHERE c.name LIKE %:name%")
                    List<Category> findByNameContaining(@Param("name") String name);
}
