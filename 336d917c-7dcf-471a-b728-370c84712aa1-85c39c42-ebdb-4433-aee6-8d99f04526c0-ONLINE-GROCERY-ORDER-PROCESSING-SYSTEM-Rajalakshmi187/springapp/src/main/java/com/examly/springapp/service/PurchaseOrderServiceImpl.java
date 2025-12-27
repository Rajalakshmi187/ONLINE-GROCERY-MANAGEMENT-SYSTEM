package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.repository.PurchaseOrderRepo;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepo repo;

    @Override
    public PurchaseOrder create(PurchaseOrder p) {
        return repo.save(p);
    }

    @Override
    public List<PurchaseOrder> getAll() {
        return repo.findAll();
    }

    @Override
    public PurchaseOrder getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PurchaseOrder update(Long id, PurchaseOrder p) {
        PurchaseOrder existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setOrderNumber(p.getOrderNumber());
            existing.setOrderDate(p.getOrderDate());
            existing.setStatus(p.getStatus());
            existing.setSupplier(p.getSupplier());
            return repo.save(existing);
        }
        return null;
    }
}
