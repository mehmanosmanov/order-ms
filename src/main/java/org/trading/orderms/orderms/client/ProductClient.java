package org.trading.orderms.orderms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trading.orderms.dto.internal.ProductRequest;
import org.trading.orderms.dto.internal.ProductResponse;

/**
 * @author Mehman on 18-07-2023
 * @project order-ms
 */
@FeignClient(name = "productClient", url = "http://localhost:8082")
//@FeignClient(name = "productClient")
public interface ProductClient {

   @PostMapping("/product/")
   void createProduct(@RequestBody ProductRequest request);

   @GetMapping("/product/{id}")
   ResponseEntity<ProductResponse> getProductById(@PathVariable Long id);

   @PutMapping("/product/decrease")
   boolean decreaseCountByCount(@RequestParam Long id, @RequestParam int amount);

   @PutMapping("/product/increase")
   boolean increaseCountByCount(@RequestParam Long id, @RequestParam int amount);
}
