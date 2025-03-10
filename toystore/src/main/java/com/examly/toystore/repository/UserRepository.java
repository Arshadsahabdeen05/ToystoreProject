package com.examly.toystore.repository;

import com.examly.toystore.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
        @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
        List<User> findByNameLike(@Param("name") String name);

        @Query("SELECT u FROM User u WHERE u.email LIKE %:email%")
        List<User> findByEmailLike(@Param("email") String email);

}

