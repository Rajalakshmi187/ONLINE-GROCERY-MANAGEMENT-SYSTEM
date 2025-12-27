package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.service.CustomerReturnService;

@RestController
@RequestMapping("/api/customer-returns")
public class CustomerReturnController {

    @Autowired
    private CustomerReturnService service;

    @PostMapping
    public ResponseEntity<CustomerReturn> addCustomerReturn(@RequestBody CustomerReturn customerReturn) {
        return new ResponseEntity<>(service.create(customerReturn), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerReturn>> getAllCustomerReturns() {
        List<CustomerReturn> list = service.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerReturn> getCustomerReturnById(@PathVariable Long id) {
        CustomerReturn customerReturn = service.getById(id);
        if (customerReturn == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerReturn, HttpStatus.OK);
    }
}    