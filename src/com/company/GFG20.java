package com.company;
import java.io.*;
import java.util.*;

class GFG20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution4 g = new Solution4();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution4 {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer>list= new ArrayList<>();
        int cnt[]= new int[n];
        for(int i=0;i<n;i++){
            cnt[arr[i]] += 1;
        }
        for(int i=0;i<n;i++)
            if(cnt[i]>1)
                list.add(i);

        if(list.size()>0) return list;
        else{
            list.add(-1);
            return list;
        }
    }
}
