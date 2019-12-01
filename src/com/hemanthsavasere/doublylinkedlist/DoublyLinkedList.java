package com.hemanthsavasere.doublylinkedlist;

class Node{
    int data;
    Node next;
    Node prev;
}
public class DoublyLinkedList {
    Node head;

    public void insert(int n){
        if(head == null){
            head = new Node();
            head.data = n;
        }
    }
}
