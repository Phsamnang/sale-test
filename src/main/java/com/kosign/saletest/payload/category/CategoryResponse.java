package com.kosign.saletest.payload.category;

import com.kosign.saletest.payload.product.ProductResponse;
import lombok.Builder;

import java.util.List;
@Builder
public record CategoryResponse(Long categoryId,String categoryName, List<ProductResponse> products) {
}
