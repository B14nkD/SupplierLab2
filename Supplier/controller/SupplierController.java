package com.example.myapp.controller;

import com.example.myapp.model.Supplier;
import com.example.myapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.findAll();
    }

    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable String id, @RequestBody Supplier supplierDetails) {
        Supplier supplier = supplierService.findById(id);
        if (supplier == null) {
            return null;
        }
        supplier.setName(supplierDetails.getName());
        supplier.setOrigin(supplierDetails.getOrigin());
        supplier.setDescription(supplierDetails.getDescription());
        return supplierService.save(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable String id) {
        Supplier supplier = supplierService.findById(id);
        if (supplier == null) {
            return ResponseEntity.badRequest().body("Cannot delete supplier with items");
        }
        supplierService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
