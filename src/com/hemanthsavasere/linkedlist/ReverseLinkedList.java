package com.hemanthsavasere.linkedlist;

public class ReverseLinkedList {
    /**
     * 1. Storing the link's address in the temp variable
     * 2. Assigning the current Node's link to the prev variable
     * 3. Making prev variable point to current node
     * 4. Making current node point to next node.
     */

    public static void reverse(LinkedList list) {
        Node curr = list.head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        list.head = prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10, 20);
        list.insert(10, 20);
        list.insert(20, 30);
        list.insert(30, 40);
        list.insert(40, 50);
        System.out.println(list);
        reverse(list);
        System.out.println(list);
    }
}
