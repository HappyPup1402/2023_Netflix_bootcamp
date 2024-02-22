package com.company.gamestore.controller;

import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class T_ShirtController {


    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/tShirts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T_Shirt getTShirtById(@PathVariable int id) {
        return serviceLayer.findTShirtById(id);
    }

    @GetMapping("/tShirts")
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> getAllTShirts() {
        return serviceLayer.findAllTShirts();
    }

    @PutMapping("/tShirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody @Valid T_Shirt t_shirt) {
        serviceLayer.saveTShirt(t_shirt);
    }

    @PostMapping("/tShirts")
    @ResponseStatus(HttpStatus.CREATED)
    public T_Shirt createTShirt(@RequestBody @Valid T_Shirt tShirt) {
        return serviceLayer.saveTShirt(tShirt);
    }

    @DeleteMapping("/tShirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) {
        serviceLayer.deleteTShirtById(id);
    }

    @GetMapping("/tShirts/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> getTShirtByColor(@PathVariable @Valid String color) {
        return serviceLayer.findByColor(color);
    }

    @GetMapping("/tShirts/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> getTShirtBySize(@PathVariable @Valid String size) {
        return serviceLayer.findBySize(size);
    }
}
