//{ Driver Code Starts
//Initial template for JAVA

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        // int v= matrix.length;
        // int[][] costs= new int[v][v];
        
        // for(int i=0;i<v;i++)
        //     for(int j=0;j<v;j++){
        //         if(matrix[i][j]==-1) costs[i][j]=Integer.MAX_VALUE;
        //         else costs[i][j]=matrix[i][j];
        //     }
            
        // for(int mid=0;mid<v;mid++)
        //     for(int src=0;src<v;src++)
        //         for(int dest=0;dest<v;dest++){
        //             if(matrix[src][mid] !=Integer.MAX_VALUE && costs[mid][dest]!=Integer.MAX_VALUE){
        //                 costs[src][dest]=Math.min(costs[src][dest], costs[src][mid]+costs[mid][dest]);
        //             }
        //         }
        // for(int i=0;i<v;i++)
        //     for(int j=0;j<v;j++){
        //         if(costs[i][j]==Integer.MAX_VALUE) matrix[i][j]=-1;
        //         else matrix[i][j]=costs[i][j];
        //     }
        
        int n = matrix.length;
        
        for(int k=0; k<n; k++)
        {
            for(int j=0; j<n; j++)
            {
                for(int i=0; i<n; i++)
                {
                    if(matrix[i][k]==-1 || matrix[k][j]==-1) continue;
                    
                    if(matrix[i][j]==-1 || (matrix[i][j] > matrix[i][k] + matrix[k][j]))
                    {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        
    }
}
