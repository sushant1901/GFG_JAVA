//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] grid, int n) {
        // Your code here
        ArrayList<String> answer = new ArrayList<>();
        
        generateAllPaths(grid, 0, 0, n, "", answer);
        
        //Collections.sort(answer); No need of this for lexicographical Order if we are doing 
        // calls as D L R U // As these calls itself are in lexicographical Order
        return answer;
    }
    
    private static void generateAllPaths(int[][] grid, int currentRow, int currentCol, int n, String current, ArrayList<String> answer ){
        
        if(currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] == 0){
            return;
        }
        
        if(currentRow == n-1 && currentCol == n-1){
            answer.add(current);
            return;
        }
        
        grid[currentRow][currentCol] = 0;
        
        // DOWN move
        generateAllPaths(grid, currentRow + 1, currentCol, n, current + "D", answer);
        
        // LEFT move
        generateAllPaths(grid, currentRow, currentCol - 1, n, current + "L", answer);
        
        // RIGHT move
        generateAllPaths(grid, currentRow, currentCol + 1, n, current + "R", answer);
        
        // UP move
        generateAllPaths(grid, currentRow - 1, currentCol, n, current + "U", answer);
        
        grid[currentRow][currentCol] = 1;
        
        return;
        
    }
    
}
