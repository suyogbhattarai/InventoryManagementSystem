/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventoryApplication.controller.algorithms;

import com.inventoryApplication.model.ContractModel;
import java.util.List;

/**
 *
 * @author Suyog Bhattarai Lmuid:23048633
 */
public class SelectionSort {

    public void performLowToHighSelectionSort(List<ContractModel> contractList) {
        int listSize = contractList.size();

        for (int step = 0; step < listSize - 1; step++) {
            int minIndex = step;

            for (int next = step + 1; next < listSize; next++) {
                if (contractList.get(next).getContractValue()
                        < contractList.get(minIndex).getContractValue()) {
                    minIndex = next;

                }

// Swap
                ContractModel tempContractModel = contractList.get(step);
                contractList.set(step, contractList.get(minIndex));
                contractList.set(minIndex, tempContractModel);

            }
        }
    }

    public void performHighToLowSelectionSort(List<ContractModel> contractList) {
        int listSize = contractList.size();

        for (int step = 0; step < listSize - 1; step++) {
            int maxIndex = step;

            for (int next = step + 1; next < listSize; next++) {
                if (contractList.get(next).getContractValue()
                        > contractList.get(maxIndex).getContractValue()) {
                    maxIndex = next;
                }
            }
//swap
            ContractModel tempContractModel = contractList.get(step);
            contractList.set(step, contractList.get(maxIndex));
            contractList.set(maxIndex, tempContractModel);
        }
    }
        public void performLatestDataSelectionSort(List<ContractModel> contractList) {
        int listSize = contractList.size();
        int left = 0;
        int right = listSize - 1;

        while (left < right) {
            // Swap the left and right elements
            ContractModel tempContractModel = contractList.get(left);
            contractList.set(left, contractList.get(right));
            contractList.set(right, tempContractModel);

            // Move the indices towards each other   
            left++;
            right--;
        }
    }
}
