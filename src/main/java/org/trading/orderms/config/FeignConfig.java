//package org.trading.orderms.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import feign.Feign;
//import feign.jackson.JacksonDecoder;
//import feign.jackson.JacksonEncoder;
//import feign.okhttp.OkHttpClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.support.SpringMvcContract;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.trading.orderms.client.CustomerClient;
//import org.trading.orderms.client.ProductClient;
//
//
///**
// * @author Mehman Osmanov
// * @project order-ms
// * @created 11:35 Monday 24-07-2023
// */
//@Configuration
//@EnableFeignClients(clients = {CustomerClient.class,ProductClient.class})
//public class FeignConfig {
//
//   @Autowired
//   private ObjectMapper objectMapper;
//
//   @Bean
//   public ProductClient productClient() {
//      return getClient(ProductClient.class, "http://localhost:8082/product");
//   }
//   @Bean
//   public CustomerClient customerClient() {
//      return getClient(CustomerClient.class, "http://localhost:8082/customer");
//   }
//
//   private <T> T getClient(final Class<T> clazz, final String baseUrl) {
//      return Feign.builder()
//              .contract(new SpringMvcContract())
//              .client(new OkHttpClient())
//              .decoder(new JacksonDecoder(objectMapper))
//              .encoder(new JacksonEncoder(objectMapper))
//              .errorDecoder(new RetreiveMessageErrorDecoder())
//              .target(clazz, baseUrl);
//   }
//}
