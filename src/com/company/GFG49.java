package com.company;
// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array1 {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);

            int arr [] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for(int i = 0;i<sizeOfArray;i++){
                arr[i] = Integer.parseInt(elements[i]);
            }
            int K = Integer.parseInt(br.readLine());

            GFG49 obj = new GFG49();
            int ans = obj.minSwap(arr, sizeOfArray, K);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class GFG49{


    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        int g=0;
        int b=0;
        for(int i=0;i<n;i++){
            if(arr[i] <= k){
                g++;
            }
        }
        for(int i=0;i<g;i++){
            if(arr[i] > k){
                b++;
            }
        }
        int i=0,j=g,ans=b;
        while(j<n){
            if(arr[i]>k) b--;
            if(arr[j]>k) b++;
            ans=Math.min(ans,b);
            i++;j++;
        }
        return ans;
    }


}
