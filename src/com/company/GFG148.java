//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(M > N) return -1;
        int lo = Integer.MAX_VALUE, hi = 0, res = -1;
        for(int i : A){
            hi += i;
            lo = i < lo ? i : lo;
        }
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            if(isPossible(mid, A, M)) {
                res = mid;
                hi = mid-1;
            } else lo = mid + 1;
        }
        return res;
    }
    
    private static boolean isPossible(int bar, int[] books, int st){
        int allocation = 1, pages = 0;
        for(int i : books){
            if(bar < i) return false;
            if(pages + i > bar){
                allocation++;
                pages = i;
            } else pages += i;
        }
        return allocation <= st;
    }
   
};
