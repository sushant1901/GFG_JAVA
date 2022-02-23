package com.company;
import java.io.*;
import java.util.*;

class GFG27 {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution12 ob = new Solution12();
            System.out.println(ob.getGray(n));
        }
    }
}// } Driver Code Ends


class Solution12 {
    static int getGray(int n) {
        // code here
        return n^(n>>1);
    }
}