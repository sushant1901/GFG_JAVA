package com.company;
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG36
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution28 obj = new Solution28();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
        }
    }
}
class Solution28
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int count=0;
        pair sorted[]=new pair[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            sorted[i]=new pair(nums[i],i);
        }
        Arrays.sort(sorted,(a,b)->a.value-b.value);
        for(int i=0;i<nums.length;i++)
        {
            while(i!=sorted[i].index)
            {
                swap(sorted,i,sorted[i].index);
                count++;
            }
        }
        return count;
    }
    void swap(pair sorted[],int i,int j)
    {
        pair temp=sorted[i];
        sorted[i]=sorted[j];
        sorted[j]=temp;
    }
}
class pair
{
    int index,value;
    pair(int value,int index)
    {
        this.value=value;
        this.index=index;
    }
}