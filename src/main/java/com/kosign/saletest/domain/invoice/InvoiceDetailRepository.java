package com.kosign.saletest.domain.invoice;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {
   @Modifying
   @Transactional
    List<InvoiceDetail> findAllByInvoice(Invoice invoice);
}
