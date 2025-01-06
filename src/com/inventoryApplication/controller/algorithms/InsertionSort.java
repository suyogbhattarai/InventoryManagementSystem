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
public class InsertionSort {

    public void sortByPending(List<ContractModel> contractList) {
        performPriorityInsertionSort(contractList, "Pending");
    }

    public void sortByCompleted(List<ContractModel> contractList) {
        performPriorityInsertionSort(contractList, "Completed");
    }

    public void sortByOnHold(List<ContractModel> contractList) {
        performPriorityInsertionSort(contractList, "On Hold");
    }

    private void performPriorityInsertionSort(List<ContractModel> contractList, String priorityStatus) {
        for (int i = 1; i < contractList.size(); i++) {
            ContractModel current = contractList.get(i);
            int j = i - 1;

            // Move elements with lower priority down the list
            while (j >= 0 && shouldSwap(contractList.get(j), current, priorityStatus)) {
                contractList.set(j + 1, contractList.get(j));
                j--;
            }

            // Insert the current element in its correct position
            contractList.set(j + 1, current);
        }

    }

    private boolean shouldSwap(ContractModel a, ContractModel b, String priorityStatus) {
        boolean aIsPriority = a.getContractStatus().equalsIgnoreCase(priorityStatus);
        boolean bIsPriority = b.getContractStatus().equalsIgnoreCase(priorityStatus);

        // If 'b' is the priority status and 'a' is not, they should be swapped
        return !aIsPriority && bIsPriority;
    }
}
