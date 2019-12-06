package com.hemanthsavasere.tree;

public class BinarySearchTree {
    Node root;
    int count = 0;

    void insert(int key) {
        if (root == null)
            return;
        else {
            Node cur = root;
            Node prev = null;
            while (cur != null) {
                if (cur.data == key) {
                    System.out.println("No duplicate elements allowed");
                    break;
                }

                prev = cur;

                if (key < cur.data)
                    cur = cur.left;

                else if (key > cur.data)
                    cur = cur.right;
            }
            if (key < prev.data) {
                prev.left = new Node();
                prev.left.data = key;
            } else if (key > prev.data) {
                prev.right = new Node();
                prev.right.data = key;
            }
        }
    }


    void delete(int key) {
        if (root == null)
            return;
        else {
            Node q = null;
            Node parent = null;
            Node cur = root;
            while (cur != null) {
                if (cur.data == key) {
                    break;
                } else if (key < cur.data) {
                    parent = cur;
                    cur = cur.left;

                } else if (key > cur.data) {
                    parent = cur;
                    cur = cur.right;
                }

            }

            if (cur == null) {
                System.out.println("Not found");
            } else if (cur.left == null)
                q = cur.right;
            else if (cur.right == null)
                q = cur.left;
            else {
                Node suc = cur.right;
                while (suc.left != null)
                    suc = suc.left;
                suc.left = cur.left;
                q = cur.right;
            }

            if (cur == parent.left)
                parent.left = q;
            else if(cur == parent.right)
                parent.right = q;
        }
    }

    void display(Node root, int level) {
        if (root == null)
            return;
        display(root.right, level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("      ");
        System.out.println(root.data);
        display(root.left, level + 1);
    }

    int countNodes(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }


    int countLeafNodes(Node root) {
        if (root == null)
            return 0;

        else if (root.left == null && root.right == null)
            return 1;

        else
            return countLeafNodes(root.left) + countLeafNodes(root.right);
    }


    int getMaxHeight(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(getMaxHeight(root.left), getMaxHeight(root.right));
    }

    static Node copy(Node root) {
        if (root == null)
            return null;

        else {
            Node temp = new Node();
            temp.data = root.data;
            temp.left = copy(root.left);
            temp.right = copy(root.right);
            return temp;
        }
    }


    static boolean compareTrees(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 != null && root2 != null)
            return root1.data == root2.data && compareTrees(root1.left, root2.left) && compareTrees(root1.right, root2.right);
        else
            return false;

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node();
        bst.root.data = 10;

        bst.insert(20);
        bst.insert(5);
        bst.insert(0);
        bst.insert(100);
        bst.insert(-10);
        bst.insert(2);

        bst.display(bst.root, 0);
        System.out.println("No. of nodes are " + bst.countNodes(bst.root));
        System.out.println("Max height is " + bst.getMaxHeight(bst.root));
        System.out.println("Leaf Nodes " + bst.countLeafNodes(bst.root));

        System.out.println();
        System.out.println();

        bst.delete(2);
        bst.display(bst.root, 0);

        System.out.println();
        System.out.println();

        bst.delete(0);
        bst.display(bst.root, 0);

        bst.delete(-999);
        bst.display(bst.root, 0);


//        BinarySearchTree treeCopy = new BinarySearchTree();
//        treeCopy.root = copy(bst.root);
//        treeCopy.display(treeCopy.root, 0);
//
//        System.out.println(compareTrees(bst.root, treeCopy.root));

    }
}