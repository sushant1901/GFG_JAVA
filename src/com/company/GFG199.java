//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    int i;
    int j;
    
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> qq = new LinkedList<>();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
               if(i==0 || i==N-1 || j==0 || j==M-1){
                   if(matrix[i][j]==1){
                       qq.add(new Pair(i,j));
                       visited[i][j]=true;
                   }
               }
            }
        }
        
        bfs(visited,matrix,qq,N,M);
        
        int count =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]==1 && visited[i][j]==false){
                    Queue<Pair> tq = new LinkedList<>();
                    visited[i][j]=true;
                    tq.add(new Pair(i,j));
                    bfs(visited,matrix,tq,N,M);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bfs(boolean[][] visited,int[][] matrix, Queue<Pair> qq,int N,int M){
        
        
        int[] r={-1,0,1,0};
        int[] c={0,1,0,-1};
        while(!qq.isEmpty()){
            
            Pair p= qq.poll();
            for(int k=0;k<4;k++){
                int inew= p.i+r[k];
                int jnew= p.j+c[k];
                
                if(inew>=0 && inew<N && jnew>=0 && jnew<M && visited[inew][jnew]==false && matrix[inew][jnew]==1){
                    visited[inew][jnew]=true;
                    qq.add(new Pair(inew,jnew));
                }
            }
       }
    }
}

