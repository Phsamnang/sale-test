package com.kosign.saletest.controller.category;

import com.kosign.saletest.controller.SaleRestController;
import com.kosign.saletest.payload.category.CategoryRequest;
import com.kosign.saletest.service.category.ICategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CategoryController extends SaleRestController {
    private final ICategoryService service;
    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest request){
        service.createCategory(request);
        return ok();
    }
    @GetMapping("category/{id}")
    public ResponseEntity<?>getCategoryById(@PathVariable Long id){
      return ok(service.getCategoryById(id));
    }
}
