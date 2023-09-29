//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
  int numberOfEnclaves(int[][] grid) {
        boolean[][] dp = new boolean[grid.length][grid[0].length];
        int n = grid.length, m = grid[0].length;
        
        for(int i=0; i<grid.length; i++) {
            if(grid[i][0] == 1) {
                helper(grid, i, 0, dp);
            }
            if(grid[i][m-1] == 1) {
                helper(grid, i, m-1, dp);
            }
        }
        
        for(int j=0; j<grid[0].length; j++) {
            if(grid[0][j] == 1) {
                helper(grid, 0, j, dp);
            }
            if(grid[n-1][j] == 1) {
                helper(grid, n-1, j, dp);
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !dp[i][j]) ans++;
            }
        }
        
        return ans;
    }
    
    void helper(int[][] grid, int i, int j, boolean[][] dp) {
        
        if(!isValid(grid, dp, i, j)) return;
        
        dp[i][j] = true;
        
        helper(grid, i+1, j, dp);
        helper(grid, i-1, j, dp);
        
        helper(grid, i, j+1, dp);
        helper(grid, i, j-1, dp);
    }
    
    boolean isValid(int[][] grid, boolean[][] dp, int i, int j) {
        return i < dp.length && j < dp[0].length && i >= 0 && j >= 0 && !dp[i][j] && grid[i][j] == 1;
    
    }
}

