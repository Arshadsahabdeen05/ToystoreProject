package com.examly.toystore.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
        @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Column(name = "user_id")
                    private int userId;

                        private String name;
                            private String email;
                                private String password;
}

