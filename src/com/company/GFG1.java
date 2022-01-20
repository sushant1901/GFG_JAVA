package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG1 {
    public static void main (String[] args) {
        //code
        Scanner sc=new Scanner(System.in);
        int arr[];
        int N;
        int T;
        int D;
        T=sc.nextInt();
        for(int i=0;i<T;i++){

            N=sc.nextInt();
            D=sc.nextInt();
            arr=new int[N];
            for(int m=0;m<N;m++)
                arr[m]=sc.nextInt();
            int brr[]=new int[N];
            int j;
            for(j=0;j<N-D ;j++)
            {
                brr[j]=arr[D+j];
            }
            for(int k=0;k<D;k++)
            {
                brr[N-D+k]=arr[k];
            }
            for(int l=0;l<N;l++)
                System.out.print(brr[l]+" ");
            System.out.println();
        }

    }

}
