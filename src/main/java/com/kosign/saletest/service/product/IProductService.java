package com.kosign.saletest.service.product;

import com.kosign.saletest.payload.product.ProductRequest;

public interface IProductService {
    void createProduct(ProductRequest payload);
}
