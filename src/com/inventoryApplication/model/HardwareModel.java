/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventoryApplication.model;

import java.time.LocalDate;

/**
 *
 * @author acer
 */
public class HardwareModel {
    private int productId;
    private String productName;
    private String supplierName;
    private LocalDate dateOfEntry;
    private double price;
    private int quantity;
    private String unit;
    private String measurementDescription;

    // Constructor
    public HardwareModel(int productId, String productName, String supplierName, 
                         LocalDate dateOfEntry, double price, int quantity, 
                         String unit, String measurementDescription) {
        this.productId = productId;
        this.productName = productName;
        this.supplierName = supplierName;
        this.dateOfEntry = dateOfEntry;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.measurementDescription = measurementDescription;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMeasurementDescription() {
        return measurementDescription;
    }

    public void setMeasurementDescription(String measurementDescription) {
        this.measurementDescription = measurementDescription;
    }
}
