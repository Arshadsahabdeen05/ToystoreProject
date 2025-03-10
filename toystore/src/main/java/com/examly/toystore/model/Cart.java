package com.examly.toystore.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int cartId;
        private int quantity;
}

