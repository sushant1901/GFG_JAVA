//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    static void dfsUtil(int u, ArrayList<ArrayList<Integer>> adj, boolean[]visited, Stack<Integer> stack){
        visited[u] = true;
        for(int v : adj.get(u)){
             if(!visited[v]){
                dfsUtil(v, adj, visited, stack);
             }
        }
        stack.push(u);
    }
    static int[] dfs(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack = new Stack<Integer>();
        boolean[]visited = new boolean[V];
        for(int u = 0; u < V; u++){
            if(!visited[u]){
                dfsUtil(u, adj, visited, stack);
            }
        }
        int[]topological = new int[V];
        for(int u = 0 ; u < V; u++){
            topological[u] = stack.pop();
        }
        return topological;
    }
    static int[] bfs(int V, ArrayList<ArrayList<Integer>> adj){
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
        int count = 0;
        List<Integer> topologicalOrder = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topologicalOrder.add(u);
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0)
                    queue.add(v);
            }
            count++;
        }
        if (count != V) {
            System.out.println("There exists a cycle in the graph");
            return null;
        }
        int[] array = new int[topologicalOrder.size()];
        for (int i = 0; i < V; i++) {
            array[i] = topologicalOrder.get(i);
        }
        return array;
    }
     
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // return bfs(V, adj);
        return dfs(V, adj);
    }
}
