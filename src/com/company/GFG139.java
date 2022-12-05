//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair {
    int row, col, allowedObstacleCounts;
    
    public Pair(int row, int col, int allowedObstacleCounts) {
        this.row = row;
        this.col = col;
        this.allowedObstacleCounts = allowedObstacleCounts;
    }
    
    public String toString() {
        return this.row + ", " + this.col + ", " + this.allowedObstacleCounts;
    }
}

class Solution {
    
    static int shotestPath(int[][] mat, int n, int m, int k) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] obstacles = new int[n][m];
        
        for (int[] obstacleArray : obstacles) {
            Arrays.fill(obstacleArray, Integer.MIN_VALUE);
        }
        
        if (mat[0][0] == 0) {
            obstacles[0][0] = k;
            queue.offer(new Pair(0, 0, k));
        } else {
            obstacles[0][0] = k - 1;
            queue.offer(new Pair(0, 0, k - 1));
        }

        int steps = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                Pair curr = queue.poll();

                if (curr.row == n - 1 && curr.col == m - 1) {
                    return steps;
                }
                
                for (int[] dir : dirs) {
                    int nRow = dir[0] + curr.row;
                    int nCol = dir[1] + curr.col;
                    int countOfObstaclesAllowed = curr.allowedObstacleCounts;
                    
                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                        if (obstacles[nRow][nCol] < countOfObstaclesAllowed) {
                            if (mat[nRow][nCol] == 0) {
                                queue.offer(new Pair(nRow, nCol, countOfObstaclesAllowed));
                                obstacles[nRow][nCol] = countOfObstaclesAllowed;
                            } else if (countOfObstaclesAllowed > 0) {
                                queue.offer(new Pair(nRow, nCol, countOfObstaclesAllowed - 1));
                                obstacles[nRow][nCol] = countOfObstaclesAllowed - 1;
                            }
                        }
                    } 
                }
            }
            steps++;
        }
    
        return -1;
    }
}
