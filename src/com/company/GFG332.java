//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
     static int findLCS(String s1, String s2, int i, int j, int [][] dp){
        int len = s1.length();
        
        if(i == len || j == s2.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + findLCS(s1, s2, i+1, j+1, dp);
        }else {
            return dp[i][j] = Math.max( findLCS(s1, s2, i+1, j, dp), findLCS(s1, s2, i, j+1, dp) );
        }
    }
    static int minimumNumberOfDeletions(String S) {
         StringBuilder sb= new StringBuilder(S);
        sb.reverse();
        int len = S.length();
        int [][] dp = new int[len][len];
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++) dp[i][j] = -1;
        }
        
        int lcslen = findLCS(S, sb.toString(), 0, 0, dp);
        return len-lcslen;
    }
}
