package com.fabriciosaand.customer_wiremock.clients;

import com.fabriciosaand.customer_wiremock.request.CustomerRequest;
import com.fabriciosaand.customer_wiremock.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "customer", url = "${customer.url}")
public interface CustomerFeignClient {
    @GetMapping("/customers")
    ResponseEntity<List<CustomerResponse>> getCustomers();

    @GetMapping(value = "/customers/{id}",consumes = "application/json", produces = "application/json")
    CustomerResponse getCustomerById(@PathVariable("id") String number);

    @PostMapping(value = "/customers", consumes = "application/json", produces = "application/json")
    CustomerResponse savaeCustomer(CustomerRequest customerRequest);
}
