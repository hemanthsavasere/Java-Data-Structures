package com.hemanthsavasere.circularlinkedlist;

class Node {
    int data;
    Node next;
}

public class CircularLinkedList {
    Node head;

    public void insert(int n) {
        if (head == null) {
            head = new Node();
            head.data = n;
            head.next = head;
        } else {
            Node prev = null, temp = head;
            while (temp.next != head) {
                if (temp.data > n)
                    break;
                prev = temp;
                temp = temp.next;
            }
            if (prev == null) {
                int k = head.data;
                Node tempo = head.next;
                head.data = n;
                Node insert = new Node();
                head.next = insert;
                insert.data = k;
                insert.next = temp;
                temp.next = tempo;
            } else if (prev == temp) {
                Node insert = new Node();
                insert.data = n;
                prev.next = insert;
                insert.next = temp;
            } else {
                Node insert = new Node();
                insert.data = n;
                prev.next = insert;
                insert.next = temp;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(head.data).append(" ");
        Node temp = head.next;
        while (temp != head) {
            sb.append(temp.data).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularLinkedList list1 = new CircularLinkedList();
        list1.insert(10);
        System.out.println(list1);
        list1.insert(20);
    }
}
