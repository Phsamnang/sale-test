package com.kosign.saletest.payload.product;

import java.math.BigDecimal;

public record ProductRequest(String productName, BigDecimal productPrice,Long categoryId) {
}
