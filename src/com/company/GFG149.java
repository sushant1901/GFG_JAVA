//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution{

    static boolean ispossible(int[] arr, int n, int k,long mid)
     {
        int man=1;
        long paintersum=0;
         for(int i=0; i<n; i++)
         {
             if(paintersum+arr[i]<=mid)
             {
                 paintersum+=arr[i];
             }
             else
             {
             man++;
             if(man>k || arr[i]>mid)
             {
                 return false;
             }
             paintersum=arr[i];
            }
        }
        return true;
     }
    static long minTime(int[] arr,int n,int k){
          long s=0;
         long e=0;
         long ans=0;
          for(int i=0; i<n;i++)
          {
              e+=arr[i];
          }
         
          //long e=sum;
          long mid=s+(e-s)/2;
          //if(k>n) return ans;
          while(s<=e)
          {
              if(ispossible(arr,n,k,mid))
              {
                  ans=mid;
                  e=mid-1;
              }
              else
              s=mid+1;
              mid=s+(e-s)/2;
          }
          return ans;
    }

 }

 

