//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    private boolean dfsUtil(int u, ArrayList<ArrayList<Integer>>adj, boolean[]visited, boolean[]pathVisited) {
         if(pathVisited[u]){
             return true;
         }
         if(visited[u]){
             return false;
         }
         visited[u] = true;
         pathVisited[u] = true;
         for(int v : adj.get(u)){
             if(dfsUtil(v, adj, visited, pathVisited)){
                 return true;
             }
         }
         pathVisited[u] = false;
         return false;
    }
    private boolean dfs(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[]visited = new boolean[V];
        boolean[]pathVisited = new boolean[V];
        for(int u = 0; u < V; u++){
             if (!visited[u]){
                 if(dfsUtil(u, adj, visited, pathVisited)){
                    return true;
                 }
             }
        }
        return false;
    }
    private boolean bfs(int V, ArrayList<ArrayList<Integer>> adj){
        int indegree[] = new int[V];
        for (int u = 0; u < V; u++) {
            ArrayList<Integer> neighbours = adj.get(u);
            for (int v : neighbours) {
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int u = 0; u < V; u++) {
            if (indegree[u] == 0)
                queue.add(u);
        }
        List<Integer> topologicalOrder = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topologicalOrder.add(u);
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0)
                    queue.add(v);
            }
        }
        if (topologicalOrder.size() != V) {
            return true;
        }
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // return dfs(V, adj);
        return bfs(V, adj);
    }
}
