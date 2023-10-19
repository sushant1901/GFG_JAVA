//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    

int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {


        boolean[] vis= new boolean[V];
        
        Queue<Integer> qq= new LinkedList<>();
        qq.add(0);
        int level=0;
        
        while(!qq.isEmpty()){
            int s=qq.size();
            
            while(s!=0){
                
                int x=qq.poll();
                
                if(x==X) return level;
                
                vis[x]=true;
                
                for(int k: adj.get(x)){
                    if(vis[k]==false) qq.add(k);
                }
                s--;
            }
            level++;
            
        }
        return -1;
    }
}
