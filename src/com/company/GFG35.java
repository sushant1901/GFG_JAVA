package com.company;
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG35 {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution27().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}// } Driver Code Ends


class Solution27 {

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int k=0,i=0,j=0,max=0;
        for(int x:arr1)
            max=Math.max(max,x);
        for(int x:arr2)
            max=Math.max(max,x);
        max+=1;
        while(i<n && j<m) {
            int x=arr1[i]%max;
            int y=arr2[j]%max;
            if(x<=y) {
                if(k<n)
                    arr1[k]=max*x+(arr1[k]%max);
                else
                    arr2[k-n]=max*x+(arr2[k-n]%max);
                k++; i++;
            } else {
                if(k<n)
                    arr1[k]=max*y+(arr1[k]%max);
                else
                    arr2[k-n]=max*y+(arr2[k-n]%max);
                k++; j++;
            }
        }

        while(i<n) {
            int x=arr1[i]%max;
            if(k<n)
                arr1[k]=max*x+(arr1[k]%max);
            else
                arr2[k-n]=max*x+(arr2[k-n]%max);
            k++; i++;
        }

        while(j<m) {
            int y=arr2[j]%max;
            if(k<n)
                arr1[k]=max*y+(arr1[k]%max);
            else
                arr2[k-n]=max*y+(arr2[k-n]%max);
            k++; j++;
        }

        for(i=0;i<n;i++)
            arr1[i]/=max;
        for(i=0;i<m;i++)
            arr2[i]/=max;
    }
}