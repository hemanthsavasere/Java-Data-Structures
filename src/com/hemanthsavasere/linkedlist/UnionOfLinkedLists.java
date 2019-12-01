package com.hemanthsavasere.linkedlist;

public class UnionOfLinkedLists {
    public static OrderedLinkedList unionOfLinkedLists(OrderedLinkedList list, OrderedLinkedList list2) {
        OrderedLinkedList res = new OrderedLinkedList();
        Node temp = list.head;
        /**
         * Traversing through the list1 for removing the duplicate elements
         * and adding to the result list
         */
        while (temp != null) {
            if (res.head == null) {
                res.head = new Node();
                res.head.data = temp.data;
            } else {
                Node temp2 = res.head;
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
                    prev.next = new Node();
                    prev.next.data = temp.data;
                }
            }
            temp = temp.next;
        }

        /**
         * Traversing through the list2 for removing the duplicate elements
         * and adding to the result list
         */

        temp = list2.head;
        while (temp != null) {
            if (res.head == null) {
                res.head = new Node();
                res.head.data = temp.data;
            } else {
                Node temp2 = res.head;
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
                    prev.next = new Node();
                    prev.next.data = temp.data;
                }
            }
            temp = temp.next;
        }
        return res;
    }

    public static void main(String[] args) {
        OrderedLinkedList list1 = new OrderedLinkedList();
        OrderedLinkedList list2 = new OrderedLinkedList();
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insert(30);
        list1.insert(40);
        list2.insert(20);
        list2.insert(60);
        list2.insert(50);
        OrderedLinkedList union = unionOfLinkedLists(list1, list2);
        System.out.println(union);
    }
}
