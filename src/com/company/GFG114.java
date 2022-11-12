// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        // taking testcases
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            String[] starr = str.split(" ");

            // input n and d
            int N = Integer.parseInt(starr[0]);
            int S = Integer.parseInt(starr[1]);

            // calling rotateArr() function
            int res = Solution.solve(N, S);
            System.out.println(res);
        }
    }
}

// Position this line where user code will be pasted.
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int solve(int N, int S) {
        // add your code here
        return S-N+1;
        
    }
}
