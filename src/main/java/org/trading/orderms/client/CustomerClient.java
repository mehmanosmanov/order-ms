package org.trading.orderms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trading.orderms.dto.internal.CustomerRequest;
import org.trading.orderms.dto.internal.CustomerResponse;

/**
 * @author Mehman on 18-07-2023
 * @project order-ms
 */

@FeignClient(name = "customerClient", url = "http://localhost:8081")
public interface CustomerClient {

   @PostMapping("/customer/make/")
   void createCustomer(@RequestBody CustomerRequest request);

   @GetMapping("/customer/make/{id}")
   ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id);

   @PutMapping("/customer/make/decrease")
   boolean decreaseBalance(@RequestParam Long id, @RequestParam double amount);

   @PutMapping("/customer/make/increase")
   boolean increaseBalance(@RequestParam Long id, @RequestParam double amount);

}

