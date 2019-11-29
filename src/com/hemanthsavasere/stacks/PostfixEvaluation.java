package com.hemanthsavasere.stacks;

import java.util.Stack;

public class PostfixEvaluation {

    public static int operation(char operator, int a, int b) {
        int res = 0;
        switch (operator) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;

            case '/':
                res = b / a;
                break;
        }
        return res;
    }

    public static int evaluatePostfixExpression(String s) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            System.out.println(st);
            if (symbol >= '0' && symbol <= '9') {
                st.push(Character.getNumericValue(symbol));
            } else {
                int op2 = st.pop();
                int op1 = st.pop();
                int res = operation(s.charAt(i), op1, op2);
                st.push(res);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String s1 = "123*+";
        System.out.println(evaluatePostfixExpression(s1));
    }
}
