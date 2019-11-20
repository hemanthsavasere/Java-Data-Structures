package com.hemanthsavasere.matrices;

public class MatrixAddition {
    public static int[][] addMatrices(int[][] arr, int[][] brr) throws Exception {
        if (arr.length != brr.length || arr[0].length != brr[0].length)
            throw new Exception("Matrix with unequal dimensions");

        int[][] result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[i][j] = arr[i][j] + brr[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] brr = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        try {
            int[][] res = addMatrices(arr, brr);
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < brr.length; j++){
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
