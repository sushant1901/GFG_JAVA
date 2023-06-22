//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        
        if(bills[0]==10 || bills[0]==20)
        return false;
        
        int five_freq=0;
        int ten_freq=0;
        int tw_freq=0;
        
        for(int i=0;i<N;i++){
            if(bills[i]==5)
            five_freq++;
            
            else if(bills[i]==10){
                 
                 if(five_freq>=1){
            ten_freq++;
            five_freq--;
            }
            
            else
            return false;
            }
            
             else if(bills[i]==20) {
                 
                 if(ten_freq>=1 && five_freq>=1)
                 {
                     five_freq--;
                     ten_freq--;
                     tw_freq++;
                 }
                 
                 else if(five_freq>=3){
                 five_freq-=3;
                 tw_freq++;
                 }
                 
                 else
                 return false;
                 
             }
            
        }
        
        return true;
    }
}
