package com.kosign.saletest.service.category;

import com.kosign.saletest.payload.category.CategoryRequest;
import com.kosign.saletest.payload.category.CategoryResponse;

public interface ICategoryService {
    void createCategory(CategoryRequest request);
    CategoryResponse getCategoryById(Long id);
}
