package com.kosign.saletest.controller.customer;

import com.kosign.saletest.controller.SaleRestController;
import com.kosign.saletest.payload.customer.CustomerRequest;
import com.kosign.saletest.payload.customer.CustomerResponse;
import com.kosign.saletest.service.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CustomerController extends SaleRestController {
    private final ICustomerService service;

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest payload) {
        service.createCustomer(payload);
        return ok();
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomer() {
        return ok(service.getAllCustomer());
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        service.removeCustomer(id);
        return ok();
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest request) {
        service.updateCustomer(id, request);
        return ok();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return ok(service.getCustomerById(id));
    }
}

