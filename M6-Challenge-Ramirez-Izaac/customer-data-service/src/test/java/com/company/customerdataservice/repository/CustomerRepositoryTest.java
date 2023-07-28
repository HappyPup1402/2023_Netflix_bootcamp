package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepo;

    @BeforeEach
    void setUp() {
        customerRepo.deleteAll();
    }

    @Test
    public void createNewCustomerTest() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Izaac");
        customer.setLastName("Ramirez");
        customer.setEmail("Izaac.ramirez@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-8623");
        customer.setAddress1("11203 elmcroft ave");
        customer.setAddress2("");
        customer.setCity("Norwalk");
        customer.setState("California");
        customer.setPostalCode("90650");
        customer.setCountry("United States");

        customer = customerRepo.save(customer);

        Optional<Customer> savedCustomer = customerRepo.findById(customer.getId());

        assertEquals(savedCustomer.get(), customer);
    }

    @Test
    public void updateExistingCustomerTest() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Izaac");
        customer.setLastName("Ramirez");
        customer.setEmail("Izaac.ramirez@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-8623");
        customer.setAddress1("11203 elmcroft ave");
        customer.setAddress2("");
        customer.setCity("Norwalk");
        customer.setState("California");
        customer.setPostalCode("90650");
        customer.setCountry("United States");

        customer = customerRepo.save(customer);

        customer.setPhone("(323)846-8623");

        customerRepo.save(customer);

        Optional<Customer> savedCustomer = customerRepo.findById(customer.getId());

        assertEquals(savedCustomer.get(), customer);
    }

    @Test
    public void deleteCustomerTest() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Izaac");
        customer.setLastName("Ramirez");
        customer.setEmail("Izaac.ramirez@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-8623");
        customer.setAddress1("11203 elmcroft ave");
        customer.setAddress2("");
        customer.setCity("Norwalk");
        customer.setState("California");
        customer.setPostalCode("90650");
        customer.setCountry("United States");

        customer = customerRepo.save(customer);

        customerRepo.delete(customer);

        Customer deletedCustomer = customerRepo.findById(customer.getId()).orElse(null);

        assertNull(deletedCustomer);

    }

    @Test
    public void findCustomerByIdTest() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Izaac");
        customer.setLastName("Ramirez");
        customer.setEmail("Izaac.ramirez@gmail.com");
        customer.setCompany("McDonald's");
        customer.setPhone("(562)846-8623");
        customer.setAddress1("11203 elmcroft ave");
        customer.setAddress2("");
        customer.setCity("Norwalk");
        customer.setState("California");
        customer.setPostalCode("90650");
        customer.setCountry("United States");

        customer = customerRepo.save(customer);

        Optional<Customer> savedCustomer = customerRepo.findById(customer.getId());

        assertEquals(savedCustomer.get(), customer);
    }

    @Test
    public void findCustomersByStateTest() {
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
        customer = customerRepo.save(customer);

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
        customer2 = customerRepo.save(customer2);

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
        customer3 = customerRepo.save(customer3);

        List<Customer> customersInCalifornia = customerRepo.findByState("California");
        List<Customer> customersInArizona = customerRepo.findByState("Arizona");

        assertEquals(2, customersInCalifornia.size());
        assertEquals(1, customersInArizona.size());

    }
}