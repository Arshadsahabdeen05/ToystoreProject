package com.examly.toystore.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Discount {
        @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
                private int discountId;

                    private String name;
                        private float percentage;
                            private Date validUntil;
}

