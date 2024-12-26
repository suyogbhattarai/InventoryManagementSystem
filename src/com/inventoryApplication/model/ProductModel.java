/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventoryApplication.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author acer
 */
public class ProductModel {
    private int productId;
    private String productName;
    private String productDescription;
    private LocalDate manufacturedDate;
    private List<HardwareModel> hardwareUsed;
    private double labourCharge;
    private double hardwareCost;
    private double totalCost;
    private double sellingPrice;
    private int quantityProduced;
    private int quantitySold;
    private int remainingQuantity;
    private List<SuppliersModel> productSuppliers;

    // Constructor
    public ProductModel(int productId, String productName, String productDescription, 
                        LocalDate manufacturedDate, List<HardwareModel> hardwareUsed, 
                        double labourCharge, double hardwareCost, double sellingPrice, 
                        int quantityProduced, int quantitySold, List<SuppliersModel> productSuppliers) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.manufacturedDate = manufacturedDate;
        this.hardwareUsed = hardwareUsed;
        this.labourCharge = labourCharge;
        this.hardwareCost = hardwareCost;
        this.sellingPrice = sellingPrice;
        this.totalCost = calculateTotalCost();
        this.quantityProduced = quantityProduced;
        this.quantitySold = quantitySold;
        this.remainingQuantity = calculateRemainingQuantity();
        this.productSuppliers = productSuppliers;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(LocalDate manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public List<HardwareModel> getHardwareUsed() {
        return hardwareUsed;
    }

    public void setHardwareUsed(List<HardwareModel> hardwareUsed) {
        this.hardwareUsed = hardwareUsed;
    }

    public double getLabourCharge() {
        return labourCharge;
    }

    public void setLabourCharge(double labourCharge) {
        this.labourCharge = labourCharge;
        this.totalCost = calculateTotalCost();  // Recalculate on change
    }

    public double getHardwareCost() {
        return hardwareCost;
    }

    public void setHardwareCost(double hardwareCost) {
        this.hardwareCost = hardwareCost;
        this.totalCost = calculateTotalCost();  // Recalculate on change
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getQuantityProduced() {
        return quantityProduced;
    }

    public void setQuantityProduced(int quantityProduced) {
        this.quantityProduced = quantityProduced;
        this.remainingQuantity = calculateRemainingQuantity();  // Update remaining
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
        this.remainingQuantity = calculateRemainingQuantity();  // Update remaining
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public List<SuppliersModel> getProductSuppliers() {
        return productSuppliers;
    }

    public void setProductSuppliers(List<SuppliersModel> productSuppliers) {
        this.productSuppliers = productSuppliers;
    }

    // Utility Methods
    private double calculateTotalCost() {
        return labourCharge + hardwareCost;
    }

    private int calculateRemainingQuantity() {
        return quantityProduced - quantitySold;
    }
}
