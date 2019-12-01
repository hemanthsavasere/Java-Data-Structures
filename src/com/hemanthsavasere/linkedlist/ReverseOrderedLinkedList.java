package com.hemanthsavasere.linkedlist;

public class ReverseOrderedLinkedList {
    public static void reverse(OrderedLinkedList list){
        Node prev = null, temp = list.head;
        while(temp != null){
            Node tempo = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempo;
        }
        list.head = prev;
    }
    public static void main(String[] args) {
        OrderedLinkedList list = new OrderedLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(0);
        reverse(list);
        System.out.println(list);
    }
}
