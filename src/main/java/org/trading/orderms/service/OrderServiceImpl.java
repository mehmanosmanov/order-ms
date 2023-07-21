package org.trading.orderms.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.trading.orderms.client.CustomerClient;
import org.trading.orderms.client.ProductClient;
import org.trading.orderms.dto.internal.ProductResponse;
import org.trading.orderms.dto.request.OrderRequest;
import org.trading.orderms.entity.Order;
import org.trading.orderms.mapper.OrderMapper;
import org.trading.orderms.repository.OrderRepository;

import java.time.LocalDateTime;

/**
 * @author Mehman Osmanov
 * @project order-ms
 * @created 02:59 Wednesday 19-07-2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

   private final OrderRepository orderRepository;
   private final OrderMapper mapper;
   private final CustomerClient customerClient;
   private final ProductClient productClient;

   @Override
   public void createOrder(OrderRequest request) {
      log.info("Create order");
      orderRepository.save(mapper.dtoToEntity(request));
   }

   @Override
   public void makeOrder(OrderRequest order) {
      ProductResponse product = productClient.getProductById(order.getProductId()).getBody();
      customerClient.getCustomerById(order.getCustomerId());
      assert product != null;
      var totalPrice = product.getPrice() * order.getCount();

      if (productClient.decreaseCountByCount(order.getProductId(), order.getCount())) {
         if (customerClient.decreaseBalance(order.getCustomerId(), totalPrice)) {
            Order order1 = Order.builder()
                    .customerId(order.getCustomerId())
                    .productId(order.getProductId())
                    .count(order.getCount())
                    .totalPrice(totalPrice)
                    .orderedAt(LocalDateTime.now()).build();
            orderRepository.save(order1);
         } else {
            productClient.increaseCountByCount(order.getProductId(), order.getCount());
         }
      } else {
         customerClient.increaseBalance(order.getCustomerId(), totalPrice);
      }
   }
}

