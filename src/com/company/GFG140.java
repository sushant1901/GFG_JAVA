//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    class Point{
        int x,y,dis;
        Point(int x,int y,int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static final int DIRS = 4;
    public static final int MAX_DISTANCE = 100000;
    public static final int[] dirX = {-1,1,0,0};
    public static final int[] dirY = {0,0,-1,1};
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for(int row = 0;row < n;row ++){
            Arrays.fill(distance[row],MAX_DISTANCE);
        }
        Queue<Point> queue = new LinkedList<Point>();
        for(int row = 0; row <n;row ++){
            for(int col = 0; col<m ; col++){
                int cellValue = grid[row][col];
                if(cellValue == 1){
                    queue.add(new Point(row,col,0));
                    distance[row][col] = 0;
                }
            }
        }
        performMultiSourceBFS(queue,distance,n,m);
        return distance;
    }
    private void performMultiSourceBFS(Queue<Point> queue,int[][] distance,int n,int m){
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int dis = point.dis;
            for(int dir = 0;dir<DIRS;dir++){
                int newX = x + dirX[dir];
                int newY = y + dirY[dir];
                if(isSafe(newX,newY,n,m) && distance[newX][newY] > dis+1){
                    distance[newX][newY] = dis+1;
                    queue.add(new Point(newX,newY,distance[newX][newY]));
                }
            }
        }
    }
    private boolean isSafe(int x,int y,int n,int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
}
