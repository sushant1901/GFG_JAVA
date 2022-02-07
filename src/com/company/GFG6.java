package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG6 {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int x = 0; x < testcases; x++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                pq.add(array[i]);
            }

            while (pq.size() > 0) {
                System.out.print(pq.remove() + " ");
                if (k < n)
                    pq.add(array[k++]);
            }
            System.out.println();
        }
    }
}