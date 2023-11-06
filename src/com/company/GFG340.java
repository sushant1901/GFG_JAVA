//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            int q = Integer.parseInt(in.readLine());
            int queries[][] = new int[q][3];
            for(int i = 0;i < q;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < 3;j++)
                    queries[i][j] = Integer.parseInt(a1[j]);
            }
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.matrixSum(n, m, mat, q, queries);
            for(int i = 0;i < q;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])

    {

        // code here

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int col = queries[i][2];
            int row = queries[i][1];
            int val = queries[i][0];
            int sum = 0;
            int cs = col - val, rs = row - val + 1, re = row + val, ce = col + val;
            for (int j = cs; j <= ce && j < m; j++) {
                if (row - val >= 0 && j < m && j >= 0) {
                    sum += mat[row - val][j];
                }
                if (row + val < n && j < m && j >= 0) {
                    sum += mat[row + val][j];
                }
            }
            for (int j = rs; j < re && j < n; j++) {
                if (col - val >= 0 && j < n && j >= 0) {
                    sum += mat[j][col - val];
                }
                if (col + val < m && j < n && j >= 0) {
                    sum += mat[j][col + val];
                }
            }
            ans.add(sum);
        }
        return ans; 
    }

}
