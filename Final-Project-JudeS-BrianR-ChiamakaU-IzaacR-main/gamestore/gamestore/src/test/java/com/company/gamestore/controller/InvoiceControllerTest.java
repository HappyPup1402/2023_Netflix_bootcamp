package com.company.gamestore.controller;

import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    InvoiceRepository invoiceRepository;

    @MockBean
    ServiceLayer serviceLayer;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() throws Exception {
        invoiceRepository.deleteAll();
    }

    @Test
    public void shouldCreateInvoice() throws Exception{
        Invoice invoice = new Invoice();
        invoice.setName("Brian");
        invoice.setStreet("100 Main Street");
        invoice.setCity("Clovis");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItemId(269);
        invoice.setItemType("Game");
        invoice.setQuantity(12);
        invoiceRepository.save(invoice);

        String inputJson = mapper.writeValueAsString(invoice);

        mockMvc.perform(post("/invoices")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetInvoiceById() throws Exception{
        Invoice invoice = new Invoice();
        invoice.setName("Brian");
        invoice.setStreet("100 Main Street");
        invoice.setCity("Clovis");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItemId(269);
        invoice.setItemType("Game");
        invoice.setQuantity(12);
        invoiceRepository.save(invoice);

        mockMvc.perform(get("/invoices/" + invoice.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllInvoices() throws Exception{
        Invoice invoice = new Invoice();
        invoice.setName("Brian");
        invoice.setStreet("100 Main Street");
        invoice.setCity("Clovis");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItemId(269);
        invoice.setItemType("Game");
        invoice.setQuantity(12);
        invoiceRepository.save(invoice);

        mockMvc.perform(get("/invoices"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetInvoiceByName() throws Exception{
        Invoice invoice = new Invoice();
        invoice.setName("Brian");
        invoice.setStreet("100 Main Street");
        invoice.setCity("Clovis");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItemId(269);
        invoice.setItemType("Game");
        invoice.setQuantity(12);
        invoiceRepository.save(invoice);

        mockMvc.perform(get("/invoices/customer/" + invoice.getName()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}