package com.hemanthsavasere.arrays;

import java.util.Scanner;

class Monomial {
    int power;
    int coefficient;

    Monomial(int power, int coefficient) {
        this.power = power;
        this.coefficient = coefficient;
    }

    Monomial() {
        this.power = 0;
        this.coefficient = 0;
    }
}

class Polynomial {
    Monomial[] arr;

    Polynomial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of expressions in polynomial");
        int n = sc.nextInt();
        this.arr = new Monomial[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Monomial();
        }
    }

    Polynomial(int len) {
        this.arr = new Monomial[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Monomial();
        }
    }

    public void showPolynomial() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(this.arr[i].coefficient + "X" + this.arr[i].power + " ");
        }
        System.out.println();
    }

    public void initializePolynomial() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the coefficient of expression " + (i + 1));
            arr[i].coefficient = sc.nextInt();
            System.out.println("Enter the power of expression" + (i + 1));
            arr[i].power = sc.nextInt();
        }
    }

    // Polynomial Addition

    public Polynomial addPolynomial(Polynomial p2) {
        Polynomial res = new Polynomial(this.arr.length + p2.arr.length);
        int i = 0, j = 0, k = 0;
        while (i < this.arr.length && j < p2.arr.length) {
            if (this.arr[i].power == p2.arr[j].power) {
                res.arr[k].power = this.arr[i].power;
                res.arr[k].coefficient = this.arr[i].coefficient + p2.arr[j].coefficient;
                i++;
                j++;
                k++;
            } else if (this.arr[i].power > p2.arr[j].power) {
                res.arr[k].power = this.arr[i].power;
                res.arr[k].coefficient = this.arr[i].coefficient;
                i++;
                k++;
            } else if (this.arr[i].power < p2.arr[j].power) {
                res.arr[k].power = p2.arr[j].power;
                res.arr[k].coefficient = p2.arr[j].coefficient;
                j++;
                k++;
            }
        }

        while (i < this.arr.length) {
            res.arr[k] = this.arr[i];
            k++;
            i++;
        }

        while (j < p2.arr.length) {
            res.arr[k] = p2.arr[j];
            k++;
            j++;
        }
        return res;
    }

    public Polynomial multiplyPolynomial(Polynomial p2) {
        Polynomial res = new Polynomial(this.arr.length * p2.arr.length);
        Monomial term = new Monomial();
        int max = Math.max(this.arr.length, p2.arr.length);
        for (int j = 0; j < p2.arr.length; j++) {
            term = p2.arr[j];
            Polynomial temp = new Polynomial(max);
            int k = 0;
            for (int i = 0; i < this.arr.length; i++) {
                temp.arr[k].power = this.arr[i].power + term.power;
                temp.arr[k].coefficient = this.arr[i].coefficient * term.coefficient;
                k++;
            }
            res = res.addPolynomial(temp);
        }
        return res;
    }
}

public class ArrayOfObjects {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.initializePolynomial();

        Polynomial p2 = new Polynomial();
        p2.initializePolynomial();


        Polynomial res = p2.addPolynomial(p1);
        Polynomial res2 = p2.multiplyPolynomial(p1);
        p1.showPolynomial();
        p2.showPolynomial();
        res.showPolynomial();
        res2.showPolynomial();

    }
}


