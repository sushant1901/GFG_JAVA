//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
class Pair implements Comparable<Pair>{
    int vertex;
    int cost;
    
    Pair(int vertex,int cost){
        this.vertex=vertex;
        this.cost=cost;
    }
    public int compareTo(Pair p){
        return this.cost-p.cost;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    PriorityQueue<Pair> pq= new PriorityQueue<>();
	    boolean[] visited = new boolean[V];
	    int minCost=0;
	    
	    pq.add(new Pair(0,0));
	    
	    while(!pq.isEmpty()){
	        Pair currentPair=pq.remove();
	        int currentVertex=currentPair.vertex;
	        int currentCost=currentPair.cost;
	        
	        if(visited[currentVertex]) continue;
	        visited[currentVertex]=true;
	        minCost+=currentCost;
	        
	        ArrayList<ArrayList<Integer>> neighbours=edges.get(currentVertex);
	        
	        for(ArrayList<Integer> current:neighbours){
	            int currentNeigh= current.get(0);
	            int currentEdgeCost= current.get(1);
	            pq.add(new Pair(currentNeigh,currentEdgeCost));
	        }
	    }
	    
	    return minCost;
	}
}
