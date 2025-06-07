package com.fabriciosaand.customer_wiremock.controller;

import com.fabriciosaand.customer_wiremock.request.CustomerRequest;
import com.fabriciosaand.customer_wiremock.response.CustomerResponse;
import com.fabriciosaand.customer_wiremock.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<CustomerResponse> getCustomers(@PathVariable ("documentNumber") String documentNumber) {
        return ResponseEntity.ok(customerService.getCustomerById(documentNumber));
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> saveCustomer(CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.saveCustomer(customerRequest));
    }

}
