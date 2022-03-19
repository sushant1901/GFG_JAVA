package com.company;
// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution29 obj = new Solution29();

            //calling trappingWater() function
            System.out.println(obj.trappingWater(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution29{

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {
        // Your code here
        long[] mxl = new long[n];
        long[] mxr = new long[n];
        mxl[0] = arr[0];
        long sum = 0;
        for(int i=1;i<n;i++){
            mxl[i] = Math.max(mxl[i-1], arr[i]);
        }
        mxr[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            mxr[i] = Math.max(mxr[i+1],arr[i]);
        }
        long[] water = new long[n];
        for(int i=0;i<n;i++){
            water[i] = Math.min(mxl[i], mxr[i])- arr[i];
        }
        for(long num: water)
            sum += num;
        return sum;
    }
}


