package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;

@Service
public class CustomerReturnServiceImpl implements CustomerReturnService {

    @Autowired
    private CustomerReturnRepo repo;

    @Override
    public CustomerReturn create(CustomerReturn customerReturn) {
        return repo.save(customerReturn);
    }

    @Override
    public List<CustomerReturn> getAll() {
        return repo.findAll();
    }

    @Override
    public CustomerReturn getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}