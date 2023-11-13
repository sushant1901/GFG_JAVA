//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends
class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int f(String x,String y,int i,int j,int dp[][]){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(x.charAt(i)==y.charAt(j)){
            return dp[i][j]=1+f(x,y,i-1,j-1,dp);
        }
        else{
            int movei=f(x,y,i-1,j,dp);
            int movej=f(x,y,i,j-1,dp);
            return dp[i][j]=Math.max(movei,movej);
        }
    }
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return (m+n)-f(X,Y,m-1,n-1,dp);
    }
}
