package com.inventoryApplication.model;

import java.time.LocalDate;

/**
 * Contract model class representing a construction contract.
 */
public class ContractModel {
    private int contractId;
    private String contractTitle;
    private String contractLocation;
    private LocalDate contractStartDate;
    private LocalDate contractExpectedEndDate;
    private String contractStatus;
    private double contractValue;
    private String clientName;
    private String scopeOfWork;

    // Constructor
    public ContractModel(int contractId, String contractTitle, String contractLocation, 
                         LocalDate contractStartDate, LocalDate contractExpectedEndDate, 
                         String contractStatus, double contractValue, String clientName, 
                         String scopeOfWork) {
        this.contractId = contractId;
        this.contractTitle = contractTitle;
        this.contractLocation = contractLocation;
        this.contractStartDate = contractStartDate;
        this.contractExpectedEndDate = contractExpectedEndDate;
        this.contractStatus = contractStatus;
        this.contractValue = contractValue;
        this.clientName = clientName;
        this.scopeOfWork = scopeOfWork;
    }

    // Getters and Setters
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    public String getContractLocation() {
        return contractLocation;
    }

    public void setContractLocation(String contractLocation) {
        this.contractLocation = contractLocation;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractExpectedEndDate() {
        return contractExpectedEndDate;
    }

    public void setContractExpectedEndDate(LocalDate contractExpectedEndDate) {
        this.contractExpectedEndDate = contractExpectedEndDate;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public double getContractValue() {
        return contractValue;
    }

    public void setContractValue(double contractValue) {
        this.contractValue = contractValue;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getScopeOfWork() {
        return scopeOfWork;
    }

    public void setScopeOfWork(String scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }
}
