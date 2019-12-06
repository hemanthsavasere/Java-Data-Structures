package com.hemanthsavasere.graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
    ArrayList<ArrayList<Integer>> adj;

    Graph() {
        adj = new ArrayList<ArrayList<Integer>>();
    }

    void initialize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of nodes");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int k = sc.nextInt();
                temp.add(k);
            }
            adj.add(temp);
        }
        System.out.println(adj);
    }

    void BFS() {
        int[] s = new int[adj.size()];
        s[0] = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0, 0);
        System.out.println(0);
        while (arr.size() > 0) {
            int u = arr.remove(0);
            for (int v = 0; v < adj.size(); v++) {
                if (adj.get(u).get(v) == 1 && s[v] != 1) {
                    arr.add(0, v);
                    System.out.println(v);
                    s[v] = 1;
                }
            }
        }
    }


    void DFS(){
        Stack<Integer> st = new Stack<>();
        int[] s = new int[adj.size()];
        s[0] = 1;
        st.push(0);
        System.out.println(0);
        while(st.size() > 0){
            int u = st.pop();
            for(int v = 0; v < adj.size(); v++){
                if(adj.get(u).get(v) == 1 && s[v] == 0){
                    System.out.println(v);
                    st.push(v);
                    s[v] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph();
        g1.initialize();
        g1.BFS();
        System.out.println();
        g1.DFS();
    }
}
