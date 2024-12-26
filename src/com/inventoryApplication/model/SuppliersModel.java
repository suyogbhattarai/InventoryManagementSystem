package com.inventoryApplication.model;

import java.util.List;

/**
 * Represents a supplier in the inventory system,
 * supplying various products.
 */
public class SuppliersModel {
    private int supplierId;
    private String supplierName;
    private String location;
    private String email;
    private String phoneNumber;
    private List<ProductModel> productsSupplied;
    private double totalTransactionAmount;

    // Constructor
    public SuppliersModel(int supplierId, String supplierName, String location, String email, 
                          String phoneNumber, List<ProductModel> productsSupplied) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.location = location;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.productsSupplied = productsSupplied;
        this.totalTransactionAmount = calculateTotalTransactionAmount();
    }

    // Getters and Setters
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ProductModel> getProductsSupplied() {
        return productsSupplied;
    }

    public void setProductsSupplied(List<ProductModel> productsSupplied) {
        this.productsSupplied = productsSupplied;
        this.totalTransactionAmount = calculateTotalTransactionAmount();  // Recalculate on update
    }

    public double getTotalTransactionAmount() {
        return totalTransactionAmount;
    }

    // Utility Method to Calculate Total Transaction Amount
    private double calculateTotalTransactionAmount() {
        return productsSupplied.stream()
                .mapToDouble(product -> product.getSellingPrice() * product.getQuantityProduced())  // Using quantityProduced as the supplied amount
                .sum();
    }
}
