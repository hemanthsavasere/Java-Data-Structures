package com.hemanthsavasere.doublylinkedlist;

class Node {
    int data;
    Node next;
    Node prev;
}

public class DoublyLinkedList {
    Node head;

    public void insert(int n) {
        if (head == null) {
            head = new Node();
            head.data = n;
        } else {
            Node prev = null, temp = head;
            while (temp != null) {
                if (temp.data > n)
                    break;
                prev = temp;
                temp = temp.next;
            }
            if (prev == null) {       // while inserting at the starting of the node
                Node insert = new Node();
                insert.data = n;
                insert.next = temp;
                temp.prev = insert;
                head = insert;
            } else {                   // inserting at end or inserting at the middle
                Node insert = new Node();
                insert.data = n;
                prev.next = insert;
                insert.prev = prev;
                insert.next = temp;
            }
        }
    }


    public void delete(int n) {
        if (head == null) {
            System.out.println("Cannot delete as list is empty");
        } else {
            Node temp = head, prev = null;
            while (temp != null) {
                if (temp.data == n)
                    break;
                prev = temp;
                temp = temp.next;
            }
            if (prev == null) { // while deleting at the starting of the node
                head = temp.next;
                temp.next = null;
            } else if (temp != null) {  // inserting at end or inserting at the middle
                prev.next = temp.next;
            }
            else{
                System.out.println("Key not found " + n);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(0);
        System.out.println(list);
        list.delete(30);
        list.delete(70);
        list.delete(60);
        System.out.println(list);
    }
}
