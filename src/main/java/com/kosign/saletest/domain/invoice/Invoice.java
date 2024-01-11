package com.kosign.saletest.domain.invoice;

import com.kosign.saletest.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoice_tb")
@Data
@RequiredArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InvoiceDetail> invoiceDetails = new ArrayList<>();
    @Builder
    public Invoice( Customer customer) {
        this.customer = customer;
    }
    public void addInvoiceDetail(List<InvoiceDetail> invoiceDetails){
        this.invoiceDetails=invoiceDetails;
    }
}
