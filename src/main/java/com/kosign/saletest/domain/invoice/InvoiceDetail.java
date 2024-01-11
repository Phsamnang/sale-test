package com.kosign.saletest.domain.invoice;

import com.kosign.saletest.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoice_detail_db")
@Getter
@Setter
@RequiredArgsConstructor
public class InvoiceDetail {
    @EmbeddedId
    private InvoiceDetailId id=new InvoiceDetailId();
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("invoiceId")
    @JoinColumn(name = "invoice_id", nullable = false, referencedColumnName = "id")
    private Invoice invoice;
    @Builder
    public InvoiceDetail(Product product, Invoice invoice) {
        this.product = product;
        this.invoice = invoice;
    }
}
