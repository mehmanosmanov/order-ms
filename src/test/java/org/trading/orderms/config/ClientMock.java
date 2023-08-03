package org.trading.orderms.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.util.StreamUtils.copyToString;

/**
 * @author Mehman Osmanov
 * @project order-ms
 * @created 09:57 Thursday 03-08-2023
 */
@Configuration
public class ClientMock {

   public static void setUpMockCustomerResponse(WireMockServer mockServer) throws IOException {
      mockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/customer/{id}"))
              .willReturn(WireMock.aResponse()
                      .withStatus(HttpStatus.OK.value())
                      .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                      .withBody(copyToString(
                              ClientMock.class.getClassLoader().getResourceAsStream("json/customer.json"),
                              Charset.defaultCharset()))));
   }


   public static void setUpMockProductResponse(WireMockServer mockServer) throws IOException {

      mockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/product/{id}"))
              .willReturn(WireMock.aResponse()
                      .withStatus(HttpStatus.OK.value())
                      .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                      .withBody(copyToString(
                              ClientMock.class.getClassLoader().getResourceAsStream("json/product.json"),
                              Charset.defaultCharset()))));

   }
}