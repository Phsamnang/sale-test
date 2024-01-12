package com.kosign.saletest.domain.product;

import com.kosign.saletest.domain.category.Category;
import com.kosign.saletest.domain.invoice.InvoiceDetail;
import com.kosign.saletest.payload.product.ProductResponse;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private BigDecimal price;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InvoiceDetail> invoiceDetails = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
  public ProductResponse toProductRespone(){
      return new ProductResponse(id,name,price);
  }
    @Builder
    public Product(Long id, String name, BigDecimal price,Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category=category;
    }
}
