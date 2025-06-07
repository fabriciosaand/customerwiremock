package com.fabriciosaand.customer_wiremock;

import com.fabriciosaand.customer_wiremock.controller.CustomerController;
import com.fabriciosaand.customer_wiremock.request.CustomerRequest;
import com.fabriciosaand.customer_wiremock.response.CustomerResponse;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles({"test", "services"})
@EnableConfigurationProperties
@SpringBootTest(classes = {WireMockConfig.class})
class CustomerWiremockApplicationTests {

	@Autowired
	private WireMockServer mockCustomerServiceWithJsonStubbing;

	@Autowired
	private CustomerController customerController;

	@BeforeEach
	void setUp() {
		mockCustomerServiceWithJsonStubbing.resetAll();
	}

	@Test
	@DisplayName("Testa a consulta de um cliente por ID")
	void testGivenCustomerId_WhenFindById_thenReturnCustomer() {

		mockCustomerServiceWithJsonStubbing.stubFor(get(urlEqualTo("/customers/9999"))
				.willReturn(aResponse()
						.withHeader("Content-Type", "application/json")
						.withBody("{\"name\":\"randomName\",\"documentNumber\":\"9999\"}")));

		CustomerResponse customer = customerController.getCustomers("9999").getBody();

		mockCustomerServiceWithJsonStubbing.verify(
				exactly(1),
				getRequestedFor(urlMatching("/customers/9999"))
		);

		assertNotNull(customer);
		assertEquals("randomName", customer.getName());
	}

	@Test
	@DisplayName("Testa a criação de um cliente com objeto CustomerRequest")
	void testGivenCustomerObject_WhenCreateCustomer_thenReturnSavedCustomer() throws IOException {

		String jsonRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/customer_request.json")));
		String jsonResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/customer_response.json")));

		mockCustomerServiceWithJsonStubbing.stubFor(post(urlEqualTo("/customers"))
						.withRequestBody(equalToJson(jsonRequest))
				.willReturn(aResponse()
						.withHeader("Content-Type", "application/json")
						.withBody(jsonResponse)));


		var customerRequest = new CustomerRequest();
		customerRequest.setDocumentNumber("123456789");
		customerRequest.setName("randomName");
		customerRequest.setPhone("1234567890");

		CustomerResponse customer = customerController.saveCustomer(customerRequest).getBody();


		mockCustomerServiceWithJsonStubbing.verify(
				exactly(1),
				postRequestedFor(urlMatching("/customers"))
						.withRequestBody(equalToJson("{\"documentNumber\":\"123456789\",\"name\":\"randomName\",\"phone\":\"1234567890\"}"))
		);

		assertNotNull(customer);
		assertNotNull(customer.getUuid());
		assertEquals("123456789", customer.getDocumentNumber());
		assertEquals("randomName", customer.getName());
		assertEquals("1234567890", customer.getPhone());

	}

}
