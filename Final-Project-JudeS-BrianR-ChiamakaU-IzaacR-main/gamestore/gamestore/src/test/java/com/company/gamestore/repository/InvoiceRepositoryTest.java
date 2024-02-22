package com.company.gamestore.repository;

import com.company.gamestore.model.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.html.Option;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceRepositoryTest {
    @Autowired
    InvoiceRepository invoiceRepository;

    @BeforeEach
    void setUP(){
        invoiceRepository.deleteAll();
    }

    @Test
    public void createInvoiceTest(){
        Invoice invoice = new Invoice();
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setUnitPrice(new BigDecimal(0.62));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal(60.00));
        invoice.setTax(new BigDecimal(0.72));
        invoice.setProcessingFee(new BigDecimal(1.20));
        invoice.setTotal(new BigDecimal(62.54));

        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> newInvoice = invoiceRepository.findById(invoice.getId());
        assertTrue(newInvoice.isPresent());
    }

    @Test
    public void getInvoiceByIdTest(){
        Invoice invoice = new Invoice();
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setUnitPrice(new BigDecimal(0.62));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal(60.00));
        invoice.setTax(new BigDecimal(0.72));
        invoice.setProcessingFee(new BigDecimal(1.20));
        invoice.setTotal(new BigDecimal(62.54));

        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> retrievedInvoice = invoiceRepository.findById(invoice.getId());
        assertNotNull(retrievedInvoice);
    }

    @Test
    public void getAllInvoicesTest(){
        Invoice invoice = new Invoice();
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setUnitPrice(new BigDecimal(0.62));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal(60.00));
        invoice.setTax(new BigDecimal(0.72));
        invoice.setProcessingFee(new BigDecimal(1.20));
        invoice.setTotal(new BigDecimal(62.54));

        invoice = invoiceRepository.save(invoice);


        Invoice invoice2 = new Invoice();
        invoice2.setName("Brian");
        invoice2.setState("100 Main Street");
        invoice2.setCity("Clovis");
        invoice2.setState("CA");
        invoice2.setZipcode("93612");
        invoice2.setItemType("Game");
        invoice2.setItemId(562);
        invoice2.setUnitPrice(new BigDecimal(0.62));
        invoice2.setQuantity(1);
        invoice2.setSubtotal(new BigDecimal(60.00));
        invoice2.setTax(new BigDecimal(0.72));
        invoice2.setProcessingFee(new BigDecimal(1.20));
        invoice2.setTotal(new BigDecimal(62.54));

        invoice2 = invoiceRepository.save(invoice2);

        List<Invoice> allInvoices = invoiceRepository.findAll();
        assertEquals(allInvoices.size(), 2);

    }

    @Test
    public void getInvoiceByCustomerNameTest(){
        Invoice invoice = new Invoice();
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setUnitPrice(new BigDecimal(0.62));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal(60.00));
        invoice.setTax(new BigDecimal(0.72));
        invoice.setProcessingFee(new BigDecimal(1.20));
        invoice.setTotal(new BigDecimal(62.54));

        invoice = invoiceRepository.save(invoice);

        List<Invoice> invoicesByCustomersName = invoiceRepository.findByName("Izaac Ramirez");
        assertEquals(invoicesByCustomersName.size(), 1);
    }
}