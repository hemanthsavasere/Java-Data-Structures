package com.hemanthsavasere.arrays;

import java.util.Arrays;

public class RemoveDuplicateElements {
    public static int[] removeDuplicateElements(int[] arr) {
        int[] unique = new int[1];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (k > unique.length - 1) {
                    int[] tempArr = new int[unique.length + 1];
                    for (int a = 0; a < unique.length; a++) {
                        tempArr[a] = unique[a];
                    }
                    //System.arraycopy(unique, 0, tempArr, 0, unique.length + 1);
                    tempArr[unique.length] = temp;
                    unique = tempArr;
                    k++;
                } else {
                    unique[k++] = temp;
                }
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, 3, 1, 5, 4, 5, 6, 8, 9, 9};
        System.out.println(Arrays.toString(removeDuplicateElements(arr)));
    }
}