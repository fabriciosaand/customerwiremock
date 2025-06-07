package com.fabriciosaand.customer_wiremock.service;

import com.fabriciosaand.customer_wiremock.request.CustomerRequest;
import com.fabriciosaand.customer_wiremock.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse getCustomerById(String customerDocumentNumber);

    CustomerResponse saveCustomer(CustomerRequest customerRequest);
}
