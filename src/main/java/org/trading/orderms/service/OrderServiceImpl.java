package org.trading.orderms.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.trading.orderms.client.CustomerClient;
import org.trading.orderms.client.ProductClient;
import org.trading.orderms.dto.internal.CustomerResponse;
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
   public boolean makeOrder(OrderRequest orderRequest) {
      ProductResponse product = productClient.getProductById(orderRequest.getProductId()).getBody();
      CustomerResponse customer = customerClient.getCustomerById(orderRequest.getCustomerId()).getBody();
//      assert product != null;
//      assert customer != null;

      var totalPrice = product.getPrice() * orderRequest.getCount();
      boolean transaction = false;

      if (customer.getBalance() > totalPrice && product.getCount() > orderRequest.getCount())
         transaction = makeTransaction(orderRequest, totalPrice);
      if (transaction) {
         Order order = mapper.dtoToEntity(orderRequest);
         order.setTotalPrice(totalPrice);
         order.setOrderedAt(LocalDateTime.now());
         orderRepository.save(order);
         return true;
      }
      return false;
   }

   public boolean makeTransaction(OrderRequest orderRequest, double totalPrice) {
      if (productClient.decreaseCountByCount(orderRequest.getProductId(), orderRequest.getCount())) {
         if (customerClient.decreaseBalance(orderRequest.getCustomerId(), totalPrice)) {
            log.info("Transaction was successfully");
            return true;
         } else {
            log.warn("Something went wrong in the customer-ms");
            productClient.increaseCountByCount(orderRequest.getProductId(), orderRequest.getCount());
            return false;
         }
      } else
         log.warn("Something went wrong in the product-ms");
      return false;
   }
}

