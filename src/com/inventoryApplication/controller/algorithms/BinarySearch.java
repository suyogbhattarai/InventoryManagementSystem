/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventoryApplication.controller.algorithms;

import com.inventoryApplication.model.ContractModel;
import java.util.List;

/**
 *
 * @author acer
 */
public class BinarySearch {
    
    public ContractModel searchByClient(String searchValue, List<ContractModel> contractList, int low, int high) {
        if (low>high) {
            return null;
        }
        System.out.println("Sorted Client Names:");
for (ContractModel contract : contractList) {
    System.out.println(contract.getClientName());
}
        //indexing
        int mid = (low + high) / 2;
        if (contractList.get(mid).getClientName().toLowerCase().equals(searchValue.toLowerCase().trim())) {
            return contractList.get(mid);
        } else if (searchValue.compareToIgnoreCase(contractList.get(mid).getClientName().trim()) < 0) {
            // search value is less than mid 
            return searchByClient(searchValue, contractList, low, mid - 1);
        } else {
            return searchByClient(searchValue, contractList, mid + 1, high);
        }
    }
    
}
