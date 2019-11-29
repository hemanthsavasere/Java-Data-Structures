package com.hemanthsavasere.stacks;

import java.util.ArrayList;

public class Stack {
    ArrayList<Integer> arr;

    public Stack(){
        arr = new ArrayList<>();
    }

    void push(int n){
        arr.add(n);
    }

    int pop(){
        return arr.remove(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); i++){
            sb.append(String.valueOf(arr.get(i)));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println(s1);
        s1.pop();
        s1.pop();
        System.out.println(s1);
    }

}
