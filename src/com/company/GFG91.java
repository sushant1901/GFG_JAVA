//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        // code here
         int k=R*C-1;
        int ans[]=new int[R*C];
        
        int col_left=0;
        int col_right=C-1;
        int row_top=0;
        int row_bottom=R-1;
        
        while(k>=0){
            
            for(int i=col_left;i<=col_right;i++){
                ans[k--]=a[row_top][i];
            }
            row_top++;
            
            if(k==-1) break;
            
            for(int i=row_top;i<=row_bottom;i++){
                ans[k--]=a[i][col_right];
            }
            col_right--;
            
            if(k==-1) break;
            
            for(int i=col_right;i>=col_left;i--){
                ans[k--]=a[row_bottom][i];
            }
            
            row_bottom--;
            
            if(k==-1) break;
            
            for(int i=row_bottom;i>=row_top;i--){
                ans[k--]=a[i][col_left];
            }
            
            col_left++;
            
            if(k==-1) break;
            
        }
        
        return ans;
    }
}
