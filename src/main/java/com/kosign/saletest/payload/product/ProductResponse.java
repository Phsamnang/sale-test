package com.kosign.saletest.payload.product;

import java.math.BigDecimal;

public record ProductResponse(Long productId, String productName, BigDecimal productPrice) {
}
