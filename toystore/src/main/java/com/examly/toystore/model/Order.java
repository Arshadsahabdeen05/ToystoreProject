package com.examly.toystore.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {
        @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
                private int id;

                    private Date orderDate;
                        private float totalAmount;
                            private String status;
}

