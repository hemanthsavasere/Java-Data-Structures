package com.hemanthsavasere.linkedlist;

public class OrderedLinkedList {
    Node head;

    void insert(int n) {
        if (head == null) {
            head = new Node();
            head.data = n;
        } else {
            Node temp = head;
            Node prev = null;

            while (temp != null) {
                if (temp.data > n)
                    break;
                prev = temp;
                temp = temp.next;
            }

            Node inserting = new Node();
            inserting.data = n;

            if (prev == null) {  // when inserting before first node
                inserting.next = temp;
                head = inserting;
            } else if (temp == null) {  // when inserting node at end
                prev.next = inserting;
            } else {
                prev.next = inserting;
                inserting.next = temp;
            }
        }

    }


    int delete(int key) {
        int ret = -1;
        if (head == null) {
            System.out.println("Cannot delete as head is empty");
        } else {
            Node temp = head;
            Node prev = null;

            while(temp != null){
                if(temp.data == key)
                    break;
                prev = temp;
                temp = temp.next;
            }
            ret = temp.data;
            if(prev == null){  // deleting the hed node
                head = temp.next;
                temp.next = null;
            }
            else{
                prev.next = temp.next;
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.data).append("->");
            temp = temp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OrderedLinkedList list = new OrderedLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println(list);
        list.insert(0);
        list.insert(90);
        System.out.println(list);
        int deleted = list.delete(0);
        System.out.println("Deleted element " + deleted + " from LinkedList");
        System.out.println(list);
        deleted = list.delete(90);
        System.out.println("Deleted element " + deleted + " from LinkedList");
        System.out.println(list);
        deleted = list.delete(30);
        System.out.println("Deleted element " + deleted + " from LinkedList");
        System.out.println(list);
    }
}
