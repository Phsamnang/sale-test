package com.kosign.saletest.controller.product;

import com.kosign.saletest.controller.SaleRestController;
import com.kosign.saletest.payload.product.ProductRequest;
import com.kosign.saletest.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ProductController extends SaleRestController {
   private final IProductService service;
    @PostMapping("/product")
    public ResponseEntity<?>createProduct(@RequestBody ProductRequest payload){
       service.createProduct(payload);
        return ok();
    }
}
