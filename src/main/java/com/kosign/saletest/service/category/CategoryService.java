package com.kosign.saletest.service.category;

import com.kosign.saletest.domain.category.Category;
import com.kosign.saletest.domain.category.CategoryRepository;
import com.kosign.saletest.domain.product.Product;
import com.kosign.saletest.payload.category.CategoryRequest;
import com.kosign.saletest.payload.category.CategoryResponse;
import com.kosign.saletest.payload.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository repository;

    @Override
    public void createCategory(CategoryRequest request) {
        repository.save(Category.builder().name(request.name()).build());
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category=repository.findById(id).get();

        List<ProductResponse> productResponses=category.getProduct().stream().map(product -> {
            return product.toProductRespone();
        }).collect(Collectors.toList());

        return CategoryResponse.builder().categoryId(category.getId()).categoryName(category.getName()).products(productResponses).build();
    }
}
