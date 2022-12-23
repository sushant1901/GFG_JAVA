//{ Driver Code Starts
//Initial Template for Java

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
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
  private static int[][] dp;
    
  // matrix chain multiplication
  private static int mcm(int[] v, int l, int r) {
    if (l >= r)
      return 0;
    else if (dp[l][r] != -1)
      return dp[l][r];
    int ans = 0;
    for (int i = l; i < r; i++) {
      ans = Math.max(ans, mcm(v, l, i) + mcm(v, i + 1, r) + v[l - 1] * v[i] * v[r]);
    }
    return dp[l][r] = ans;
  }

  public static int maxCoins(int N, int[] arr) {
    // array init
    int[] v = new int[N + 2];
    v[0] = v[N + 1] = 1;
    for (int i = 0; i < N; i++)
      v[i + 1] = arr[i];
      
    // dp init
    dp =  new int[N+2][N+2];
    for (int i = 0; i < N + 2; i++)
      for (int j = 0; j < N + 2; j++)
        dp[i][j] = -1;
    
    // run algo
    return mcm(v, 1, N + 1);
  }
}
     
