package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.CustomerReturn;

public interface CustomerReturnService {
    CustomerReturn create(CustomerReturn c);
    List<CustomerReturn> getAll();
    CustomerReturn getById(Long id);
}
