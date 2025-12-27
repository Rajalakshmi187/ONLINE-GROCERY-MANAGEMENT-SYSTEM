package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.PurchaseOrderItemRepo;

@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {

    @Autowired
    private PurchaseOrderItemRepo purchaseOrderItemRepo;

    @Override
    public PurchaseOrderItem create(PurchaseOrderItem purchaseOrderItem) {
        // Validate the purchaseOrderItem
        if (purchaseOrderItem == null) {
            throw new IllegalArgumentException("PurchaseOrderItem cannot be null");
        }
        
        // Ensure quantity is positive
        if (purchaseOrderItem.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        
        // Save and return the purchase order item
        return purchaseOrderItemRepo.save(purchaseOrderItem);
    }

    @Override
    public List<PurchaseOrderItem> getByOrderId(Long orderId) {
        // Validate orderId
        if (orderId == null || orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be valid");
        }
        
        // Get purchase order items by order ID
        List<PurchaseOrderItem> items = purchaseOrderItemRepo.findByPurchaseOrder_PurchaseOrderId(orderId);
        
        return items;
    }
}