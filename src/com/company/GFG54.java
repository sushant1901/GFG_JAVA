package com.company;
import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();
            Solution54 ob = new Solution54();
            System.out.println(ob.RedOrGreen(N, S));
        }
    }
}// } Driver Code Ends


//User function template for Java

class Solution54 {
    static int RedOrGreen(int N, String S) {
        //code here
        int r=0,g=0;
        for(int i=0;i<N;i++){
            if(S.charAt(i)=='R')
                r++;
            else
                g++;
        }
        return Math.min(r,g);
    }
}