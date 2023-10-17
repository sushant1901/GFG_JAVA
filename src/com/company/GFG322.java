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
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int adj[][], int N, int node, boolean vis[])
    {
        vis[node] = true;

        for(int i = 0; i < adj[node].length; i++) {
            if(i == node || adj[node][i] == 0)
                continue;

            if(vis[i])
                continue;

            dfs(adj, N, i, vis);
        }
    }
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       boolean vis[] = new boolean[N];
       
       for(int i = 0; i < N; i++)
       {
            vis = new boolean[N];
            dfs(graph, N, i, vis);
            ArrayList<Integer> temp = new ArrayList<>();
           
            for(boolean b : vis)
                temp.add( b == true ? 1 : 0 );
            ans.add(temp);
       }
        return ans;
    }
}
