package com.kosign.saletest.payload.invoice;

import com.kosign.saletest.domain.customer.Customer;
import java.util.Set;

public record InvoiceRequest(Long customerId, Set<Long> productId) {
}
