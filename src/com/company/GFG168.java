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
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegree= new int[V];
        Queue<Integer> queue= new LinkedList<>();
        boolean[] visited= new boolean[V];
        int visitedVertices=0;
        
        for(int i=0;i<V;i++){// finding indegree
            for(int currentNeigh:adj.get(i))
                inDegree[currentNeigh]+=1;
        }
        // finding vertices with indegree 0.
        
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        // Starting BFS.
        
        while(!queue.isEmpty()){
            int currentVertices=queue.remove();
            
            if(visited[currentVertices]) continue;
            visited[currentVertices]=true;
            visitedVertices+=1;
            
            for(int currentNeigh: adj.get(currentVertices)){
                inDegree[currentNeigh]-=1;
                if(inDegree[currentNeigh]==0){
                    queue.add(currentNeigh);
                }
            }
        }
        return !(visitedVertices==V);
    }
}
