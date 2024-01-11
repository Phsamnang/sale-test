package com.kosign.saletest.domain.customer;

import com.kosign.saletest.domain.invoice.Invoice;
import com.kosign.saletest.payload.customer.CustomerResponse;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_tb")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_phone")
    private String phone;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Invoice> invoices = new HashSet<>();
    public CustomerResponse toCustomerResponse(){
        return new CustomerResponse(id,name,address,phone);
    }
    @Builder
    public Customer(Long id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
