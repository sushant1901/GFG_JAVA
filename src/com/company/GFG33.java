package com.company;
import java.io.*;
import java.util.*;

class GFG33{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i=0; i<n ; i++ ) {
                array[i] = sc.nextInt();
            }
            Solution25 ob = new Solution25();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            t--;
        }
    }
}

class Solution25
{
    public static long[] productExceptSelf(int nums[], int n)
    {
        // code here
        long t[]=new long[n];
        int a=0;
        for(int i=0;i<n;i++){
            long fuk=1;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                else{
                    fuk=fuk*nums[j];
                    continue;
                }
            }
            t[a]=fuk;
            a=a+1;

        }
        return t;
    }

}

