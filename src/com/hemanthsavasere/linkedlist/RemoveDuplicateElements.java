package com.hemanthsavasere.linkedlist;

public class RemoveDuplicateElements {
    public static LinkedList removeDuplicateElements(OrderedLinkedList list) {
        LinkedList result = new LinkedList();
        Node temp = list.head;
        while (temp != null) {
            if (result.head == null) {  //inserting when the LinkedList result  is empty
                result.head = new Node();
                result.head.data = temp.data;
            } else {
                Node temp2 = result.head;
                Node prev = null;
                boolean found = false;
                while (temp2 != null) {
                    if (temp2.data == temp.data) {
                        found = true;
                        break;
                    }
                    prev = temp2;
                    temp2 = temp2.next;
                }
                if (!found) {
                    Node tempo = new Node();
                    tempo.data = temp.data;
                    prev.next = tempo;
                }
            }
            temp = temp.next;
        }
        return result;
    }

    public static void main(String[] args) {
        OrderedLinkedList list = new OrderedLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(40);
        list.insert(40);
        list.insert(20);
        System.out.println(list);
        LinkedList list2 = removeDuplicateElements(list);
        System.out.println(list2);
    }
}
