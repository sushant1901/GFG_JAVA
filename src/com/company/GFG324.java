//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
         List<List<Integer>> revAdj = new ArrayList<>();
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++) revAdj.add(new ArrayList<>());
        
        for(int i = 0; i < V; i++) {
            for(int node: adj.get(i)) {
                revAdj.get(node).add(i);
                inDegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < V; i++) if(inDegree[i] == 0) q.add(i);
        
        while(q.size() > 0) {
            int curr = q.remove();
            list.add(curr);
            for(int nbr: revAdj.get(curr)) {
                inDegree[nbr]--;
                if(inDegree[nbr] == 0) q.add(nbr);
            }
        }
        Collections.sort(list);
        return list;
    }
}
