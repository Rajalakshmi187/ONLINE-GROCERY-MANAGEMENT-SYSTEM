package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Supplier;

public interface SupplierService {
    Supplier create(Supplier s);
    List<Supplier> getAll();
    Supplier getById(Long id);
    Supplier update(Long id, Supplier s);
}
