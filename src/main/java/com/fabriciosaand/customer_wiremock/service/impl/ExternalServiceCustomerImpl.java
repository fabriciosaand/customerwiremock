package com.fabriciosaand.customer_wiremock.service.impl;

import com.fabriciosaand.customer_wiremock.clients.CustomerFeignClient;
import com.fabriciosaand.customer_wiremock.request.CustomerRequest;
import com.fabriciosaand.customer_wiremock.response.CustomerResponse;
import com.fabriciosaand.customer_wiremock.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExternalServiceCustomerImpl implements CustomerService {

    private final CustomerFeignClient customerFeignClient;

    public ExternalServiceCustomerImpl(CustomerFeignClient customerFeignClient) {
        this.customerFeignClient = customerFeignClient;
    }

    @Override
    public CustomerResponse getCustomerById(String customerDocumentNumber) {
        return customerFeignClient.getCustomerById(customerDocumentNumber);
    }

    @Override
    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        return customerFeignClient.savaeCustomer(customerRequest);
    }
}
