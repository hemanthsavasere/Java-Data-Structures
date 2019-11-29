package com.hemanthsavasere.stacks;

import java.util.Stack;

public class Postfix {
    public static int precedence(char ch1) {
        int value = 0;
        if (ch1 == '+' || ch1 == '-')
            value = 1;

        if (ch1 == '*' || ch1 == '/')
            value = 3;

        return value;
    }

    public static String infixToPostifx(String s1) {
        Stack<Character> st = new Stack<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char l = s1.charAt(i);
            if (l >= 'A' && l <= 'Z') {
                s.append(l);
            } else if(l == '+'|| l == '-' || l == '*' || l == '/') {
                while (!st.empty() && precedence(l) < precedence(st.peek()) && st.peek() != '(') {
                    s.append(st.pop());
                }
                st.push(l);
            }
            else if(l == '('){
                st.push(l);
            }
            else if(l == ')'){
                while(!st.empty() && st.peek() != '('){
                    s.append(st.pop());
                }
                st.pop();
            }
        }
        while (!st.empty()) {
            s.append(st.pop());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String s1 = "A*B+C-D/E";
        String s2 = "A+B*C";
        String s3 = "(A+B)*C";
        String s4 = "(A+(B-C)*D)";
        System.out.println(s1 + '\t' + infixToPostifx(s1));
        System.out.println(s2 + '\t' + infixToPostifx(s2));
        System.out.println(s3 + '\t' + infixToPostifx(s3));
        System.out.println(s4 + '\t' + infixToPostifx(s4));

    }
}
