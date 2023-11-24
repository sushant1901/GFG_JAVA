//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        
        ArrayList<Long> arr = new ArrayList<>();
        arr.add((long)1);
        
        if(n==1){
            return arr;
        }
        arr.add((long)1);
        if(n == 2){
            return arr;
        }
        long mod = 1000000007;
        n-=2;
        while(n!=0){
            ArrayList<Long> ans = new ArrayList<>();
            long sum = 0;
            ans.add((long)1);
            for(int i = 0;i<arr.size()-1;i++){
                sum = (arr.get(i) + arr.get(i+1))%mod;
                ans.add(sum);
            }
            ans.add((long)1);
            n--;
            arr=ans;
        }
        
        return arr;
    }
}
