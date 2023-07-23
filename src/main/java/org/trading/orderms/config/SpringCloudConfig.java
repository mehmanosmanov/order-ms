//package org.trading.orderms.config;
//
//import io.netty.resolver.DefaultAddressResolverGroup;
////import org.springframework.cloud.gateway.route.RouteLocator;
////import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import reactor.netty.http.client.HttpClient;
//
///**
// * @author Mehman Osmanov
// * @project order-ms
// * @created 08:56 Thursday 20-07-2023
// */
//@Configuration
//public class SpringCloudConfig {
//   @Bean
//   public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//
//      return builder.routes().route(r -> r.path("/employee/**")
//                      .uri("http://localhost:8081/"))
//              .route(r -> r.path("/consumer/**")
//                      .uri("http://localhost:8082/"))
////              .route(r -> r.path("/order/**")
////                      .uri("http://localhost:8080/"))
//              .build();
//   }
//
//
//   @Bean
//   public HttpClient httpClient() {
//      return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
//   }
//}
