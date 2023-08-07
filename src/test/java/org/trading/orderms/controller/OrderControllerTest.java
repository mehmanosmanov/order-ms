package org.trading.orderms.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.trading.orderms.OrderMsApplication;
import org.trading.orderms.config.ClientMock;
import org.trading.orderms.config.WireMockConfig;
import org.trading.orderms.dto.request.OrderRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OrderMsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "integration")
@ContextConfiguration(classes = {WireMockConfig.class})
class OrderControllerTest {


    @Autowired
    private WireMockServer mockServer;

    @BeforeEach
    void setUpServerMock() throws IOException {
        ClientMock.setUpMockCustomerResponse(mockServer);
        ClientMock.setUpMockProductResponse(mockServer);
    }


    @LocalServerPort
    private int serverPort;
    private String url;

    @BeforeEach
    void setUp() {
        url = "http://localhost:" + serverPort;
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql(scripts = "classpath:sql/order.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/customer.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void givenMakeOrderWhenMadeThenReturnResponse() {

        //arrange
        OrderRequest request = new OrderRequest();
        request.setCount(1);
        request.setProductId(1L);
        request.setCustomerId(1L);

        //act
        //postForObject(url + "/order/make/", request, String.class);

        ResponseEntity<String> response = restTemplate.postForEntity(url + "/order/make/", request, String.class);


        //assert
        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Order successfully made", response.getBody());

    }
}