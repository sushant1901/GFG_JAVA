package com.company;
// { Driver Code Starts
//Initial Template for Java

import java.util.*;

class Product
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Long arr[] = new Long[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextLong();

            Long mod = 1000000007L;
            GFG48 gfg = new GFG48();
            System.out.println(gfg.product(arr, mod, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
     arr[] is the array
     n = number of element in array
     mod = modulo value;
*/
class GFG48
{
    public static Long product(Long arr[], Long mod, int n)
    {
        //yout code here
        long fact=1;
        for(int i=0;i<n;i++){
            fact=(fact*arr[i])%mod;

        }
        return fact;
    }
}
