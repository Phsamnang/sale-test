package com.kosign.saletest.payload.invoice;

import com.kosign.saletest.domain.product.Product;
import com.kosign.saletest.payload.customer.CustomerResponse;
import com.kosign.saletest.payload.product.ProductResponse;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
@Builder
public record InvoiceResponse(Long invoiceId, LocalDateTime invoiceDate, CustomerResponse customer, List<ProductResponse> products) {
}
