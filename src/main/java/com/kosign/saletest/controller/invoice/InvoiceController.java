package com.kosign.saletest.controller.invoice;

import com.kosign.saletest.controller.SaleRestController;
import com.kosign.saletest.payload.invoice.InvoiceRequest;
import com.kosign.saletest.service.invoice.IInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class InvoiceController extends SaleRestController {
    private final IInvoiceService service;
    @PostMapping("/invoice")
    public ResponseEntity<?>createInvoice(@RequestBody InvoiceRequest payload){
        System.out.println(payload);
        service.createInvoice(payload);
        return ok();
    }
    @GetMapping("/invoice/{id}")
    public ResponseEntity<?>getInvoiceById(@PathVariable("id") Long id){
        return ok(service.getInvoiceById(id));
    }
}
