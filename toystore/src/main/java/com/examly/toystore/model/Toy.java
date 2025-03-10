package com.examly.toystore.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Toy {
        @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
                private int toyId;

                    private String name;
                        private String category;
                            private String ageRange;
                                private float price;
                                    private int stock;
}

