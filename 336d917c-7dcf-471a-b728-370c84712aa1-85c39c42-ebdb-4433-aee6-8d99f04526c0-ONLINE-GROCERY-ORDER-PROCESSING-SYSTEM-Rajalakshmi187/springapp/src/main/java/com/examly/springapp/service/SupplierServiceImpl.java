
package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo repo;

    @Override
    public Supplier create(Supplier s) {
        return repo.save(s);
    }

    @Override
    public List<Supplier> getAll() {
        return repo.findAll();
    }

    @Override
    public Supplier getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Supplier update(Long id, Supplier s) {
        Supplier old = repo.findById(id).orElse(null);
        if (old != null) {
            old.setSupplierName(s.getSupplierName());
            old.setEmail(s.getEmail());
            return repo.save(old);
        }
        return null;
    }
}