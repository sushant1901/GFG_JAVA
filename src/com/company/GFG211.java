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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    private boolean dfs(char [][] board,String word,int x,int y,boolean [][] visited){
        //base case
        if(word.length()==0)return true;
        if(x<0 || y<0 || x>=board.length || y>= board[0].length || visited[x][y]==true 
        || word.charAt(0)!=board[x][y]){
            return false;
        }
        //mark to be visited
        visited[x][y]=true;
        //now the word has to update for further character comparison
        word = word.substring(1);
        //call for nbrs
        boolean left = dfs(board,word,x,y-1,visited);
        boolean right = dfs(board,word,x,y+1,visited);
        boolean bottom = dfs(board,word,x-1,y,visited);
        boolean top = dfs(board,word,x+1,y,visited);
        visited[x][y] = false;
        return (left||right||top||bottom);
    }
    public boolean isWordExist(char[][] board, String word)
    {
        //get the row and coloumn
        int row = board.length;
        int col = board[0].length;
        //create a boolean visited array to track the record of visited vertices
        boolean [][] visited = new boolean[row][col];
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(board,word,i,j,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
