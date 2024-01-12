package com.kosign.saletest.service.customer;

import com.kosign.saletest.domain.customer.Customer;
import com.kosign.saletest.domain.customer.CustomerRepository;
import com.kosign.saletest.payload.customer.CustomerRequest;
import com.kosign.saletest.payload.customer.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepository repository;

    @Override
    public void createCustomer(CustomerRequest payload) {
        //System.out.println(payload);

        Customer customer = Customer.builder().name(payload.customerName())
                .phone(payload.customerPhone())
                .address(payload.customerAddress()).build();
        repository.save(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {
        List<Customer> customers=repository.findAll();
        List<CustomerResponse> customerResponses=customers.stream().map(
                c->c.toCustomerResponse()
        ).collect(Collectors.toList());
        return customerResponses;
    }

    @Override
    public void removeCustomer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCustomer(Long id, CustomerRequest payload) {
        Customer customer=repository.findById(id).get();
        customer.setName(payload.customerName());
        customer.setAddress(payload.customerAddress());
        customer.setPhone(payload.customerPhone());
        repository.save(customer);
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        return repository.findById(id).get().toCustomerResponse();
    }
}
