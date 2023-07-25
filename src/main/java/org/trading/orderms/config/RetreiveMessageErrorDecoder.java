//package org.trading.orderms.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import org.springframework.context.annotation.Configuration;
//import org.trading.orderms.exception.ErrorMessage;
//import org.trading.orderms.exception.exceptions.InsufficientCount;
//import org.trading.orderms.exception.exceptions.NotFoundException;
//
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * @author Mehman Osmanov
// * @project order-ms
// * @created 21:31 Sunday 23-07-2023
// */
//@Configuration
//public class RetreiveMessageErrorDecoder implements ErrorDecoder {
//   private final ErrorDecoder errorDecoder = new Default();
//
//   @Override
//   public Exception decode(String methodKey, Response response) {
////      ErrorMessage message = null;
////      try (InputStream bodyIs = response.body().asInputStream()) {
////         ObjectMapper mapper = new ObjectMapper();
////         message = mapper.readValue(bodyIs, ErrorMessage.class);
////      } catch (IOException e) {
////         return new Exception(e.getMessage());
////      }
//      switch (response.status()) {
//         case 400:
//            return new InsufficientCount();
//         case 404:
//            return new NotFoundException("Not found");
//         default:
//            return errorDecoder.decode(methodKey, response);
//      }
//   }
//
//}