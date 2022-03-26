package com.company;
// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG39 {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t=sc.nextInt();

        while(t-->0)
        {
            int n=sc.nextInt();

            int arr[]=new int[n];

            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            int k=sc.nextInt();
            Solution86 ob = new Solution86();
            out.println(ob.kthSmallest(arr, 0, n-1, k));
        }
        out.flush();
    }
}

class Solution86{
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        int n = r-l+1;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        int K = 0;
        while(!pq.isEmpty() && K < k - 1) {
            pq.poll();
            K++;
        }
        int ans = -1;
        if (!pq.isEmpty()) {
            ans = pq.poll();
        }
        return ans;
    }
}
