package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG16 {
    public static void main (String[] args) {
        //code
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t!=0)
        {
            t--;
            int x=sc.nextInt();
            int arr[]=new int[x];
            for(int i=0;i<x;i++)
                arr[i]=sc.nextInt();
            Stack<Integer> st=new Stack<>();
            int r[]=new int[x];
            st.push(x-1);
            r[x-1]=-1;
            for(int i=x-2;i>=0;i--)
            {
                while(!st.isEmpty() && arr[i]<=arr[st.peek()])
                {
                    st.pop();
                }
                if(st.isEmpty())
                    r[i]=-1;
                else
                    r[i]=st.peek()+1;
                st.push(i);
            }
            for(int a:r)
                System.out.print(a+" ");
            System.out.println();
        }

    }
}