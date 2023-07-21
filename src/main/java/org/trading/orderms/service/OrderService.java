package org.trading.orderms.service;

import org.trading.orderms.dto.request.OrderRequest;

/**
 * @author Mehman on 18-07-2023
 * @project product-ms
 */
public interface OrderService {

   void createOrder(OrderRequest request);

   void makeOrder(OrderRequest order);

}
