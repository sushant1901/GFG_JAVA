package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG15 {
    public static void main (String[] args) {
        //code
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0)
        {
            int n=sc.nextInt();
            Queue<String>q=new LinkedList<>();
            q.offer("1");
            q.offer("2");
            for(int i=1;i<n;i++)
            {
                String curr=q.poll();
                q.offer(curr+"1");
                q.offer(curr+"2");
            }
            System.out.println(q.peek());
        }
    }
}