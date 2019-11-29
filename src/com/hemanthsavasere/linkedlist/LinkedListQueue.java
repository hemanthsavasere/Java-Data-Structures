package com.hemanthsavasere.linkedlist;

public class LinkedListQueue {
    LinkedList list;

    LinkedListQueue() {
        list = new LinkedList();
    }

    void insert(int k) {
        if(list.head == null){
            list.head = new Node();
            list.head.data = k;
        }
        else{
            Node temp = list.head;
            while (temp.next != null){
                temp = temp.next;
            }
            Node inserting = new Node();
            inserting.data = k;
            temp.next = inserting;
        }
    }

    int delete() throws Exception{
        int ret;
        if(list.head == null)
            throw new Exception("cannot pop element as queue is empty");
        else{
            ret = list.head.data;
            list.head = list.head.next;
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = list.head;
        while(temp != null){
            sb.append(temp.data).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }

    public static void main (String[] args) throws Exception {
        LinkedListQueue q = new LinkedListQueue();
        q.insert(10);
        q.insert(20);
        q.insert(30);
        System.out.println(q);
        q.delete();
        System.out.println(q);
    }
}
