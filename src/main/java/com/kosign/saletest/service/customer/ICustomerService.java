package com.kosign.saletest.service.customer;

import com.kosign.saletest.payload.customer.CustomerRequest;
import com.kosign.saletest.payload.customer.CustomerResponse;

import java.util.List;

public interface ICustomerService {
    void createCustomer(CustomerRequest payload);
   List<CustomerResponse> getAllCustomer();
   void removeCustomer(Long id);
   void updateCustomer(Long id,CustomerRequest payload);
   CustomerResponse getCustomerById(Long id);
}
