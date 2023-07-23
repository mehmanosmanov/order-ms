package org.trading.orderms.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.trading.orderms.dto.request.OrderRequest;
import org.trading.orderms.service.OrderService;


/**
 * @author Mehman Osmanov
 * @project order-ms
 * @created 02:58 Wednesday 19-07-2023
 */
@RestController
@RequiredArgsConstructor
@Slf4j
//@RequestMapping("/cont")
public class OrderController {

   private final  OrderService orderService;

   @PostMapping("/make")
   public void makeOrder(@RequestBody OrderRequest order) {
      log.info("Starting make order");
      orderService.makeOrder(order);
   }

   @GetMapping("/")
   public String sayHallo(){
      return "Hello";
   }
}
