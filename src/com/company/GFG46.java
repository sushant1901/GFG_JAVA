package com.company;
// { Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class GFG46 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solu().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solu {
    int print2largest(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        for(int i=n-1;i>0;i--){
            if(arr[n-1]>arr[i-1]) return arr[i-1];
        }
        return -1;
    }
}