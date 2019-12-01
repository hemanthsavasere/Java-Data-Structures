package com.hemanthsavasere.linkedlist;

public class ReverseOrderedLinkedList {
    public static void reverse(OrderedLinkedList list){
        /**
         *  1. Storing the link's address in the temp variable
         *  2. Assigning the current Node's link to the prev variable
         *  3. Making prev variable point to current node
         *  4. Making current node point to next node.
         */
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
