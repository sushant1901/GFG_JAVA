//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
     public static String betterString(String str1, String str2) {
        // Code here
        long count1=Distinctsub(str1);
        long count2=Distinctsub(str2); 
        if(count1>=count2){
            return str1;
        }else{
            return str2;
        }
    }
    
    public static long Distinctsub(String str){
        int n=str.length();
        long dp[]=new long[n+1];
        dp[0]=1;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=1;i<dp.length;i++){
            dp[i]=2*dp[i-1];
            char ch=str.charAt(i-1);
            if(hm.containsKey(ch)){
                int j=hm.get(ch);
                dp[i]=dp[i]-dp[j-1];
            }
            hm.put(ch,i);
        }
        return dp[n];
    }
}
