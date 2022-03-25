package com.company;
// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG38 {
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc=new Scanner(System.in);

        //taking total count of testcases
        int t=sc.nextInt();
        while(t-->0){

            //taking number of elements
            int n=sc.nextInt();

            //calling findCatalan() method
            System.out.println(new Solution69().findCatalan(n));
        }
    }
}// } Driver Code Ends



class Solution69
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        BigInteger[]arr=new BigInteger[n+1];
        arr[0]=BigInteger.ONE;
        arr[1]=BigInteger.ONE;
        for(int i=2;i<=n;i++)
        {
            int j=0,k=i-1;
            BigInteger count=BigInteger.ZERO;
            BigInteger a=BigInteger.ZERO;
            while(j!=i)
            {
                count=count.add(arr[j].multiply(arr[k]));
                j++;k--;
            }
            arr[i]=count;

        }
        return arr[n];


    }
}