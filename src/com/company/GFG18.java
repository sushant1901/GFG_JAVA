package com.company;
import java.io.*;
import java.util.*;

public class GFG18 {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }

            int key =sc.nextInt();
            Sol2 g = new Sol2();
            System.out.println(g.binarysearch(arr,n,key));
            T--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Sol2 {
    int binarysearch(int arr[], int n, int k){
        int l=0,u=n-1,mid=0;
        while(l<=u){
            mid=(l+u)/2;
            if(arr[mid]==k){
                return mid;
            }
            else if(k>arr[mid]){
                l=mid+1;
            }else{
                u=mid-1;
            }
        }
        return -1;

    }
}