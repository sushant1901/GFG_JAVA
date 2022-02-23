package com.company;
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}


class GfG28 {
    int transitionPoint(int arr[], int n) {
        // code here
        if(arr[n-1]==0)
            return -1;

        int c=0;
        for(int i=0;i<n;i++)
            if(arr[i]==1){
                c=i;
                break;
            }
        return c;
    }
}