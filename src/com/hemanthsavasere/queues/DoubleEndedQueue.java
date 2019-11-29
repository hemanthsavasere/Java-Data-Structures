package com.hemanthsavasere.queues;

import java.util.ArrayList;
import java.util.Deque;

public class DoubleEndedQueue {
    ArrayList<Integer> arr;

    public DoubleEndedQueue() {
        arr = new ArrayList<>();
    }

    void insertAtFront(int n) {
        arr.add(0, n);
    }

    void insertAtBack(int n) {
        arr.add(n);
    }

    int deleteFromFront() {
        return arr.remove(0);
    }

    int deleteFromEnd() {
        return arr.remove(arr.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleEndedQueue dq = new DoubleEndedQueue();
        dq.insertAtFront(10);
        dq.insertAtFront(20);
        dq.insertAtFront(30);
        dq.insertAtBack(40);
        dq.insertAtBack(25);
        System.out.println(dq);
        dq.deleteFromEnd();
        dq.deleteFromFront();
        System.out.println(dq);

    }
}
