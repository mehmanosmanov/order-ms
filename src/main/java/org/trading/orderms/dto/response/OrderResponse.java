package org.trading.orderms.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Mehman Osmanov
 * @project order-ms
 * @created 00:14 Wednesday 19-07-2023
 */
@Setter
@Getter
public class OrderResponse {

   private Long customerId;
   private Long productId;
   private int count;
   private double totalPrice;
   private LocalDateTime orderedAt;
}
