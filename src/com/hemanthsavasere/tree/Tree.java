package com.hemanthsavasere.tree;

class Node {
    int data;
    Node left;
    Node right;
}

public class Tree {
    Node root;

    public static void preorderRecursive(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    public static void inorderRecursive(Node root) {
        if (root == null)
            return;
        inorderRecursive(root.left);
        System.out.print(root.data + " ");
        inorderRecursive(root.right);
    }

    public static void postorderRecursive(Node root) {
        if (root == null)
            return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    public static void displayTree(Node root, int level) {
        if (root == null)
            return;
        displayTree(root.right, level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("        ");
        System.out.println(root.data);
        displayTree(root.left, level + 1);
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

        preorderRecursive(tree1.root);
        System.out.println();
        inorderRecursive(tree1.root);
        System.out.println();
        postorderRecursive(tree1.root);
        System.out.println();
        displayTree(tree1.root, 1);

    }
}
