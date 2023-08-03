package org.trading.orderms;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.trafficlistener.WiremockNetworkTrafficListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.util.StreamUtils.copyToString;

@SpringBootTest
@ActiveProfiles("integration")
class OrderMsApplicationTests {

    @Autowired
    @Qualifier("customer")
    private WireMockServer customer;
    @Autowired
    @Qualifier("product")
    private WireMockServer product;

    @BeforeEach
    void setUpCustomerClient() throws IOException {

        customer.stubFor(WireMock.get(WireMock.urlEqualTo("/customer/make/{id}"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(copyToString(
                                this.getClass().getClassLoader().getResourceAsStream("json/customer.json"),
                                Charset.defaultCharset()))));
    }

    @BeforeEach
    void setUpProductClient() throws IOException {

        product.stubFor(WireMock.get(WireMock.urlEqualTo("/books"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(copyToString(
                                this.getClass().getClassLoader().getResourceAsStream("json/product.json"),
                                Charset.defaultCharset()))));
    }


}
