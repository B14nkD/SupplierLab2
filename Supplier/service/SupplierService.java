package com.example.myapp.service;

import com.example.myapp.model.Supplier;
import com.example.myapp.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier findById(String id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        supplierRepository.deleteById(id);
    }
}
