package com.hemanthsavasere.matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MartixMultiplication {

    public static List<List<Integer>> mulitplyMatrices(List<List<Integer>> arr , List<List<Integer>> brr ) throws Exception{
        int m1 = arr.size(), m2 = arr.get(0).size();
        int n1 = brr.size(), n2 = brr.get(0).size();

        List<List<Integer>> result = new ArrayList<>();

        if(m2 != n1)
            throw new Exception("Matrix sizes is not matching, so matrix multiplication is not possible");

        int temp;
        for(int a = 0; a < m1; a++){
            result.add(new ArrayList<>());
            for(int b = 0; b < n2; b++){
                temp = 0;
                for(int c = 0; c < n1; c++){
                    temp  += arr.get(a).get(c) * brr.get(c).get(b);
                }
                result.get(a).add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<List<Integer>> brr = new ArrayList<>();

        arr.add(Arrays.asList(1, 2, 3));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(7, 8, 9));

        brr.add(Arrays.asList(1, 0, 0));
        brr.add(Arrays.asList(0, 1, 0));
        brr.add(Arrays.asList(0, 0, 1));

        System.out.println(arr);
        System.out.println(brr);

        try{
            System.out.println(mulitplyMatrices(arr, brr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
