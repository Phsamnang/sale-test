package com.kosign.saletest.service.product;

import com.kosign.saletest.domain.product.Product;
import com.kosign.saletest.domain.product.ProductRepository;
import com.kosign.saletest.payload.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository repository;
    @Override
    public void createProduct(ProductRequest payload) {
        repository.save(Product.builder().name(payload.productName()).price(payload.productPrice()).build());
    }
}
