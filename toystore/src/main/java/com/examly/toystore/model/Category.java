package com.examly.toystore.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
}