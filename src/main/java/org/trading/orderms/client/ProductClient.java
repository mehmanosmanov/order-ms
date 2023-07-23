package org.trading.orderms.client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trading.orderms.dto.internal.ProductRequest;
import org.trading.orderms.dto.internal.ProductResponse;

/**
 * @author Mehman on 18-07-2023
 * @project order-ms
 */
@FeignClient(name = "productClient", url = "http://localhost:8082")
public interface ProductClient {

   @PostMapping("/product/make/")
   void createProduct(@RequestBody ProductRequest request);

   @GetMapping("/product/make/{id}")
   ResponseEntity<ProductResponse> getProductById(@PathVariable Long id);

   @PutMapping("/product/make/decrease")
   boolean decreaseCountByCount(@RequestParam Long id, @RequestParam int amount);

   @PutMapping("/product/make/increase")
   boolean increaseCountByCount(@RequestParam Long id, @RequestParam int amount);
}
