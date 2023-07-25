package org.trading.orderms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.trading.orderms.client.CustomerClient;
import org.trading.orderms.client.ProductClient;

@SpringBootApplication
@EnableFeignClients(clients = { CustomerClient.class, ProductClient.class})
public class OrderMsApplication {

   public static void main(String[] args) {
      SpringApplication.run(OrderMsApplication.class, args);
   }
}
