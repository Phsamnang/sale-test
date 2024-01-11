package com.kosign.saletest.service.invoice;

import com.kosign.saletest.payload.invoice.InvoiceRequest;
import com.kosign.saletest.payload.invoice.InvoiceResponse;

public interface IInvoiceService {
    void createInvoice(InvoiceRequest payload);
    InvoiceResponse getInvoiceById(Long id);
}
