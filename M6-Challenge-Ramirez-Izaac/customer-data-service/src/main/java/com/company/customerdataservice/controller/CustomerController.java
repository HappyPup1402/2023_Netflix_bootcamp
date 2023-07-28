package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer){
        repo.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id){
        repo.deleteById(id);
    }


    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id){
        Optional<Customer> returnVal = repo.findById(id);
        if(returnVal.isPresent()){
            return returnVal.get();
        }else{
            return null;
        }
    }

    @GetMapping("/customer/state/{state}")
    public List<Customer> getCustomersByState(@PathVariable String state){
        return repo.findByState(state);
    }

}
