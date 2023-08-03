package org.trading.orderms.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trading.orderms.dto.request.OrderRequest;
import org.trading.orderms.service.OrderService;


/**
 * @author Mehman Osmanov
 * @project order-ms
 * @created 02:58 Wednesday 19-07-2023
 */
@RestController
@RequestMapping("/make")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

   private final  OrderService orderService;

   @PostMapping("/")
   public ResponseEntity<String> makeOrder(@RequestBody OrderRequest order) {
//      log.info("Starting make order");
      orderService.makeOrder(order);
      return ResponseEntity.ok("Order successfully made");
   }

   @GetMapping("/")
   public String sayHallo(){
      return "Hello";
   }
}
