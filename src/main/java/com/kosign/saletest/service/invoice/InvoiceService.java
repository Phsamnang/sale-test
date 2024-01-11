package com.kosign.saletest.service.invoice;

import com.kosign.saletest.domain.customer.Customer;
import com.kosign.saletest.domain.customer.CustomerRepository;
import com.kosign.saletest.domain.invoice.Invoice;
import com.kosign.saletest.domain.invoice.InvoiceDetail;
import com.kosign.saletest.domain.invoice.InvoiceDetailRepository;
import com.kosign.saletest.domain.invoice.InvoiceRepository;
import com.kosign.saletest.domain.product.Product;
import com.kosign.saletest.domain.product.ProductRepository;
import com.kosign.saletest.payload.invoice.InvoiceRequest;
import com.kosign.saletest.payload.invoice.InvoiceResponse;
import com.kosign.saletest.payload.product.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService implements IInvoiceService {
    private final InvoiceDetailRepository invoiceDetailRepository;
    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    public void createInvoice(InvoiceRequest payload) {
        Customer customer = customerRepository.findById(payload.customerId()).get();
        var invoice = new Invoice(customer);
        List<InvoiceDetail> invoiceDetails = payload.productId()
                .stream().map(x -> InvoiceDetail.builder().invoice(invoice).product(productRepository.findById(x).get()).build()).collect(Collectors.toList());
        invoice.setInvoiceDetails(invoiceDetails);
        invoiceRepository.save(invoice);
        //System.out.println(invoiceDetails);
    }

    @Override
    public InvoiceResponse getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id).get();
        List<InvoiceDetail> invoiceDetails = invoice.getInvoiceDetails();
        List<ProductResponse> products = invoiceDetails.stream().map(
                p -> p.getProduct().toProductRespone()
        ).collect(Collectors.toList());
       Customer customer=customerRepository.findById(invoice.getCustomer().getId()).get();
        System.out.println(customer.toCustomerResponse());
        return InvoiceResponse
                .builder().invoiceId(invoice.getId())
                .invoiceDate(invoice.getDate())
                .customer(customer.toCustomerResponse())
                .products(products).build();
      //  return null;
    }
}
