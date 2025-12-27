package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder create(PurchaseOrder p);
    List<PurchaseOrder> getAll();
    PurchaseOrder getById(Long id);
    PurchaseOrder update(Long id, PurchaseOrder p);
}

