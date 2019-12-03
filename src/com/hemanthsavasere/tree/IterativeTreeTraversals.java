package com.hemanthsavasere.tree;

import javax.print.attribute.standard.NumberOfDocuments;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTreeTraversals {
    public static void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        else {
            List<Node> queue = new ArrayList<>();
            queue.add(root);
            while (queue.size() > 0) {
                Node cur = queue.remove(0);
                System.out.print(cur.data + " ");
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }
        System.out.println();
    }

    public static void iterativePostOrderTraversal(Node root) {
        if (root == null)
            return;
        else {
            Stack<Node> st1 = new Stack<>();
            Stack<Node> st2 = new Stack<>();
            st1.push(root);
            while (!st1.empty()) {
                Node cur = st1.pop();
                st2.push(cur);
                if (cur.right != null)
                    st1.push(cur.left);
                if (cur.left != null)
                    st1.push(cur.right);
            }
            while (!st2.empty())
                System.out.print(st2.pop().data + " ");
        }
        System.out.println();
    }

    public static void iterativeInorderTraversal(Node root) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while (st.size() > 0 || cur != null) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
    }

    public static void iterativePreOrderTraversal(Node root) {
        if (root == null)
            return;
        else {
            Stack<Node> st = new Stack<>();
            st.push(root);
            while (!st.empty()) {
                Node cur = st.pop();
                System.out.print(cur.data + " ");
                if (cur.right != null)
                    st.push(cur.right);
                if (cur.left != null)
                    st.push(cur.left);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.root = new Node();
        tree1.root.data = 10;

        tree1.root.left = new Node();
        tree1.root.left.data = 20;

        tree1.root.right = new Node();
        tree1.root.right.data = 30;

        tree1.root.left.left = new Node();
        tree1.root.left.left.data = 40;

        tree1.root.left.right = new Node();
        tree1.root.left.right.data = 50;

        tree1.root.right.left = new Node();
        tree1.root.right.left.data = 60;

        tree1.root.right.right = new Node();
        tree1.root.right.right.data = 70;

        levelOrderTraversal(tree1.root);
        iterativePostOrderTraversal(tree1.root);
        iterativePreOrderTraversal(tree1.root);
        iterativeInorderTraversal(tree1.root);
    }
}
