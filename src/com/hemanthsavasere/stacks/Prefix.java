package com.hemanthsavasere.stacks;

public class Prefix {
    public static String infixToPrefix(String s){
        String s1 = new StringBuilder(s).reverse().toString();
        String res = new StringBuilder(Postfix.infixToPostifx(s1)).reverse().toString();
        return res;
    }
    public static void main(String[] args) {
        System.out.println(infixToPrefix("A+B*C"));
    }
}
