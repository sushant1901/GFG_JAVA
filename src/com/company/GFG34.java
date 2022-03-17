package com.company;
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG34
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //reading total testcases
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            //inserting the values
            for(int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");

            //inserting the weigths
            for(int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            //calling method knapSack() of class Knapsack
            System.out.println(new Solution26().knapSack(w, wt, val, n));
        }
    }
}
class Solution26
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int weights[], int values[], int n)
    {
        return maxProfit(weights,values,capacity,n,0,new HashMap<String,Integer>());
    }
    public static int maxProfit(int[] weights,int[] values,int capacity,int n,int currentItem,HashMap<String,Integer> memo)
    {
        if(currentItem >= n)
            return 0;

        String currentKey = Integer.toString(currentItem) + "_" + Integer.toString(capacity);

        if(memo.containsKey(currentKey))
            return memo.get(currentKey);

        int consider = 0;
        if(weights[currentItem] <= capacity){
            consider = values[currentItem] + maxProfit(weights, values, capacity - weights[currentItem], n, currentItem + 1,memo);
        }

        int notConsider = maxProfit(weights, values, capacity, n, currentItem + 1,memo);

        memo.put(currentKey,Math.max(consider,notConsider));

        return memo.get(currentKey);
    }
}


