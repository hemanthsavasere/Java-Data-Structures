package com.hemanthsavasere.queues;

import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> arr;

    public Queue() {
        arr = new ArrayList<>();
    }

    int pop() {
        if (arr.size() == 0)
            System.out.println("Cannot pop from queue");
        return arr.remove(0);
    }

    void push(int num) {
        arr.add(num);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i: arr){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.push(10);
        q1.push(20);
        q1.push(30);
        System.out.println(q1);
        q1.pop();
        System.out.println(q1);
        q1.pop();
        System.out.println(q1);
    }
}
