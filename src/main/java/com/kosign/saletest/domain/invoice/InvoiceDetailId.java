package com.kosign.saletest.domain.invoice;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InvoiceDetailId implements Serializable {
    @Column(nullable = false, insertable = false)
    private Long productId;
    @Column(nullable = false, insertable = false)
    private Long invoiceId;
}
