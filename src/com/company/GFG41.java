package com.company;
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG41 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim()); // size of array
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
            }

            Solution41 ob = new Solution41();

            System.out.println(ob.maxIndexDiff(arr, n)); // print the result
        }
    }
}
class Solution41{
    static int maxIndexDiff(int A[], int N) {

        int MaxDiff = -1;

        for(int i=0;i<N;i++) {
            for(int j=N-1; j>=i; j--) {
                if(A[i] <= A[j]) {
                    MaxDiff = Math.max(MaxDiff, j-i);
                    break;
                }
            }
        }

        return MaxDiff;

    }
}


