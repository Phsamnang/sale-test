package com.kosign.saletest.payload.customer;

import lombok.Builder;

@Builder
public record CustomerRequest(String customerName,String customerAddress,String customerPhone) {
}
