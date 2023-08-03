package org.trading.orderms.orderms.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mehman Osmanov
 * @project order-ms
 * @created 03:03 Wednesday 19-07-2023
 */
@Setter
@Getter
public class OrderRequest {
   private Long customerId;
   private Long productId;
   private int count;
}
