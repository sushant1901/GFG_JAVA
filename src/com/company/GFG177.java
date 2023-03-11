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
    public static int max(int[] arr,int n)

    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    public static int sum(int[] arr,int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }
    public static boolean isValid(int[] arr,int n,int M,int res)
    {
        int student = 1 , sum=0;
        for(int i=0;i<n;i++)
        {
            if(sum + arr[i] > res)
            {
                student ++ ;
                sum=arr[i];
            }
            else 
            sum+=arr[i];
        }
        return student<=M;
    }
    public static int findPages(int[] A,int N,int M)
    {
        //Your code here
        if(N<M)
        return -1;
        int min=max(A,N);
        int max=sum(A,N);
        int res=0;
        while(min<=max)
        {
            int mid=min+(max-min)/2;
            if(isValid(A,N,M,mid))
            {
                res=mid;
                max=mid-1;
            }
            else
            min=mid+1;
        }
        return res;
    }
};
