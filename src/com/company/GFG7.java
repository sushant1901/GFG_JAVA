package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG7
{
    public static void main (String[] args)
    {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
            int count = 3;
            int k=0;
            for(int i1=0;i1<n;i1++){
                k = a+b+c;
                a = b;
                b = c;
                c = k;
                count = count+1;
                if(count==n){
                    break;
                }
            }
            System.out.println(k);
        }
    }
}