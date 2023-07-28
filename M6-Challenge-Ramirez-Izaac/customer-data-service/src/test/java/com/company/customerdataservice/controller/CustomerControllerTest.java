package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepo;

    @BeforeEach
    public void setUp() throws Exception{
        customerRepo.deleteAll();
    }

    @Test
    public void testCreateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-8623");
        customer.setAddress1("11723 colima rd");
        customer.setAddress2("Apt D");
        customer.setCity("Whittier");
        customer.setState("California");
        customer.setPostalCode("90604");
        customer.setCountry("United States");
        customerRepo.save(customer);


        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customer").content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateCustomer() throws Exception{
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-8623");
        customer.setAddress1("11723 colima rd");
        customer.setAddress2("Apt D");
        customer.setCity("Whittier");
        customer.setState("California");
        customer.setPostalCode("90604");
        customer.setCountry("United States");
        customerRepo.save(customer);

        String inputJson = mapper.writeValueAsString(customer);

        customer.setPhone("(323)456-1402");

        mockMvc.perform(put("/customer/{id}", customer.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testDeleteCustomer() throws Exception{
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-8623");
        customer.setAddress1("11723 colima rd");
        customer.setAddress2("Apt D");
        customer.setCity("Whittier");
        customer.setState("California");
        customer.setPostalCode("90604");
        customer.setCountry("United States");
        customerRepo.save(customer);

        mockMvc.perform(delete("/customer/{id}", customer.getId()))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testGetCustomerById() throws Exception{
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-8623");
        customer.setAddress1("11723 colima rd");
        customer.setAddress2("Apt D");
        customer.setCity("Whittier");
        customer.setState("California");
        customer.setPostalCode("90604");
        customer.setCountry("United States");
        customerRepo.save(customer);

        mockMvc.perform(delete("/customer/{id}", customer.getId()))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testGetCustomersByState() throws Exception{
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-9412");
        customer.setAddress1("11723 colima rd");
        customer.setAddress2("Apt D");
        customer.setCity("Whittier");
        customer.setState("California");
        customer.setPostalCode("90604");
        customer.setCountry("United States");
        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Izaac");
        customer2.setLastName("Ramirez");
        customer2.setEmail("Izaac.ramirez@gmail.com");
        customer2.setCompany("McDonald's");
        customer2.setPhone("(562)846-8623");
        customer2.setAddress1("11203 elmcroft ave");
        customer2.setAddress2("");
        customer2.setCity("Norwalk");
        customer2.setState("California");
        customer2.setPostalCode("90650");
        customer2.setCountry("United States");
        customerRepo.save(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Paul");
        customer3.setLastName("kent");
        customer.setEmail("paul.kent@gmail.com");
        customer3.setCompany("Dutch Bro's");
        customer3.setPhone("(541)955-4700");
        customer3.setAddress1("722 N McQueen Rd");
        customer3.setAddress2("");
        customer3.setCity("Gilbert");
        customer3.setState("Arizona");
        customer3.setPostalCode("95343");
        customer3.setCountry("United States");
        customerRepo.save(customer3);

        mockMvc.perform(delete("/customer/{id}", customer.getId()))
                .andExpect(status().isNoContent());

    }


}
