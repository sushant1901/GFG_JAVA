//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
        // code here
          int l = 0, r = 0, u = 0,d = 0;
        int  dx = 0, dy = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'L':
                    dx--;
                    break;
                case 'R':
                    dx++;
                    break;
                case 'U':
                    dy--;
                    break;
                case 'D':
                    dy++;
                    break;
            }
            l = Math.min(l, dx);
            r = Math.max(r, dx);
            u = Math.max(u, dy);
            d = Math.min(d, dy);
        }
        return (r - l < m) && (u - d < n) ? 1 : 0;
    }
}
