package org.trading.orderms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@SpringBootConfiguration
public class OrderMsApplication {

   public static void main(String[] args) {
      SpringApplication.run(OrderMsApplication.class, args);
   }
}
