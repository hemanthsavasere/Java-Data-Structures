package com.hemanthsavasere.linkedlist;

public class LinkedListStack {
    LinkedList list;

    public LinkedListStack() {
        list = new LinkedList();
    }

    public void push(int n){
        if (list.head == null) {
            list.head = new Node();
            list.head.data = n;
        } else {
            Node heading = new Node();
            heading.data = n;
            heading.next = list.head;
            list.head = heading;
        }
    }

    public int pop() throws Exception{
        if(list.head == null){
            throw new Exception("cannot pop element as stack is empty");
        }
        else{
            Node temp = list.head;
            list.head = list.head.next;
        }
        return list.head.data;
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

    public static void main(String[] args) throws Exception {
        LinkedListStack st = new LinkedListStack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);
        st.pop();
        System.out.println(st);
    }
}
