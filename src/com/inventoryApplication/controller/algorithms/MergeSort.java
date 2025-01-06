/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventoryApplication.controller.algorithms;

import com.inventoryApplication.model.ContractModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class MergeSort {

    public void performMergeSort(List<ContractModel> list) {
        if (list.size() <= 1) {
            return;

        }

        int mid = list.size() / 2;
        List<ContractModel> left = new ArrayList<>(list.subList(0, mid));
        List<ContractModel> right = new ArrayList<>(list.subList(mid, list.size()));

        performMergeSort(left);
        performMergeSort(right);

        mergeData(list, left, right);

    }

    public void mergeData(
            List<ContractModel> list,
            List<ContractModel> left,
            List<ContractModel> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getClientName().compareTo(right.get(j).getClientName()) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));

            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++)
            );
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++)
            );
        }
    }
}
