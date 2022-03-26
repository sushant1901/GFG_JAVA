package com.company;
// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution30
{
    public static void sort012(int a[], int n)
    {
        // code here
        int zero =0;
        int one =0;
        int two =0;

        for(int i :a){
            if(i == 0){
                zero++;
            }else if(i==1){
                one++;
            }else{
                two++;
            }
        }

        int insert = 0;
        while(insert<zero){
            a[insert++] = 0;
        }
        while(insert<zero+one){
            a[insert++] = 1;
        }
        while(insert<n){
            a[insert++] = 2;
        }
    }
}

// { Driver Code Starts.

class GFG40 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution30 ob=new Solution30();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends