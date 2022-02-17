package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG21{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            Solution5 obj = new Solution5();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution5
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> res=new ArrayList<Integer> ();
        int sum=0,k=1,i=0,z=0;
        while(i<n)
        {
            sum=sum+arr[i];
            if(sum==s)
            {
                res.add(z+1);
                res.add(i+1);
                return res;
            }else if(sum>s)
            {
                sum=0;
                i=k;
                z=k;
                k++;
                continue;
            }
            else
                i++;
        }
        res.add(-1);
        return res;

    }
}