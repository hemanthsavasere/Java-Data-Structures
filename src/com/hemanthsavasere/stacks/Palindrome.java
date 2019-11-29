package com.hemanthsavasere.stacks;

import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String s1, String s2) {
        boolean palindrome = true;
        if (s1.length() != s2.length())
            palindrome = false;

        else {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s1.length(); i++) {
                st.push(s1.charAt(i));
            }

            int i = 0;

            while (!st.empty() && i < s2.length()) {
                if(st.pop() != s2.charAt(i++)) {
                    palindrome = false;
                    break;
                }
            }
        }
        return palindrome;
    }

    public static void main(String[] args) {
        String s1 = "MADAM", s2 = "HEMAN";
        System.out.println(isPalindrome(s1, s2));
    }
}
