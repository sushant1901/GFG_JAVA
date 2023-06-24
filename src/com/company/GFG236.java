//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int klengthpref(String[] a, int n, int k, String s)
    {
        if(s.length()<k)return 0;
        
        String x=s.substring(0,k);
        
        int i,cnt=0;
        for(i=0;i<n;i++){
            if(a[i].length()<k)continue;
            
            String temp=a[i].substring(0,k);
            
            if(x.equals(temp))cnt++;
        }
        return cnt;
    }

}
