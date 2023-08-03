package org.trading.orderms.orderms.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Mehman on 18-07-2023
 * @project product-ms
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long productId;
    private int count;
    private double totalPrice;
    private LocalDateTime orderedAt;
}
