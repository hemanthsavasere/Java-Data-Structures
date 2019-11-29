package com.hemanthsavasere.linkedlist;

class Node {
    int data;
    Node next;

    public Node() {
        this.data = 0;
        this.next = null;
    }
}

public class LinkedList {
    Node head;
    void insert(int n, int k) {
        if (head == null) {
            head = new Node();
            head.data = n;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.data == n)
                    break;
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Cannot find element after which insertion should take place");
            } else {
                Node inserting = new Node();
                inserting.data = k;
                Node temp_address = temp.next;
                temp.next = inserting;
                inserting.next = temp_address;
            }
        }
    }

    void delete(int n) {
        if (head == null) {
            System.out.println("Cannot delete as the list is empty");
        } else {
            Node temp = head;
            Node prev = null;
            while (temp != null) {
                if (temp.data == n)
                    break;
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Element to be deleted is not found");
            } else if (prev == null) {
                head = head.next;
            } else {
                prev.next = temp.next;
            }
        }
    }

    @Override
    public String toString() {
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.data).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10, 20); // Insertion happens for first time since head is null
        list.insert(10, 20);
        list.insert(20, 30);
        list.insert(30, 40);
        list.insert(40, 50);
        list.insert(50, 60);
        list.delete(10);
        list.delete(20);
        list.delete(50);
        list.delete(30);
        list.delete(60);
        list.delete(40);
        System.out.println(list);
    }
}
