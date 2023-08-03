package org.trading.orderms.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.trading.orderms.client.CustomerClient;
import org.trading.orderms.client.ProductClient;
import org.trading.orderms.dto.request.OrderRequest;
import org.trading.orderms.entity.Order;
import org.trading.orderms.mapper.OrderMapper;
import org.trading.orderms.repository.OrderRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

   @InjectMocks
   private OrderServiceImpl orderService;


   @Mock
   private CustomerClient customerClient;
   @Mock
   private ProductClient productClient;
   @Mock
   private OrderMapper mapper;
   @Mock
   private OrderRepository orderRepository;

   private Order order;

   @BeforeEach
   void setRequest() {

   }

   @BeforeEach
   void setOrder() {
      order = new Order();
      order.setId(1L);
      order.setCustomerId(1L);
      order.setCustomerId(1L);
      order.setCount(1);
      order.setTotalPrice(10);
      order.setOrderedAt(LocalDateTime.MAX);
   }


   @Test
   void givenMakeOrderWhenMadeThenResult() {
      //arrange
      OrderRequest request = new OrderRequest();
      request.setCustomerId(1L);
      request.setProductId(1L);
      request.setCount(2);


      //act

      //assert

   }
}