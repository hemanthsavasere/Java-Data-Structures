package com.hemanthsavasere.arrays;

import java.util.Scanner;

public class Array {
    private static Scanner sc = new Scanner(System.in);
    static int size = 5;

    public static boolean insert(int[] arr) {
        boolean success = false;
        System.out.println("Enter the element to be inserted in array");
        int val = sc.nextInt();
        System.out.println("Enter the position to be inserted in");
        int pos = sc.nextInt();
        if (pos >= 0 && pos < arr.length) {
            for (int i = arr.length - 1; i >= pos; i--) {
                arr[i] = arr[i - 1];
            }
            arr[pos] = val;
            success = true;
        }
        size += 1;
        display(arr, size);
        return success;
    }

    public static boolean delete(int[] arr) {
        boolean success = false;
        System.out.println("Enter the position to be deleted ");
        int pos = sc.nextInt();
        if (pos >= 0 && pos < arr.length) {
            for (int i = pos; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            success = true;
        }
        size -= 1;
        display(arr, size);
        return success;
    }

    public static void display(int[] arr, int size) {
        System.out.println("Elements of Array are");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static int[] create(int n) {
        int[] arr = new int[100];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + " element of array");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = create(size);
        insert(arr);
        delete(arr);
    }
}
