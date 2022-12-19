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
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
        // Your code here
        int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        List<List<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        
        for (int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        
        dijkstra(adj,dist,k);
        int res = 0;
        for (int i = 1; i <= n; i++) res = Math.max(res, dist[i]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    void dijkstra(List<List<int[]>> adj, int[] dist, int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        dist[start] = 0;
        pq.add(new int[]{start,0});
        while (!pq.isEmpty()){
            int[] c = pq.poll();
            int node = c[0];
            int node_dist = c[1];
            for (int[] vw : adj.get(node)){
                int neighbor_node = vw[0];
                int dist_neighbor = vw[1];
                if (dist[neighbor_node] > dist_neighbor + dist[node]){
                    dist[neighbor_node] = dist_neighbor + dist[node];
                    pq.add(new int[]{neighbor_node, dist[neighbor_node]});
                }
            }
        }
    }
    
}
