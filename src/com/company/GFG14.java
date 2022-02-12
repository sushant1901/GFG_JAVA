package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG14 {
    public static void main (String[] args) {
        //code
        Scanner scan = new Scanner (System.in);
        int t= scan.nextInt();
        while(t-->0){
            int q = scan.nextInt();
            Stack <Integer> stack = new Stack<Integer>();
            while(q-->0){
                String str = scan.next();
                if(str.equals("place")){
                    int a= scan.nextInt();
                    stack.push(a);
                }
                else if(stack.size()>0){
                    System.out.print(stack.pop()+" ");
                }
                else{
                    System.out.print("-1"+" ");
                }
            }
            System.out.println();
        }

        scan.close();
    }
}