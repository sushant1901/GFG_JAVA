package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG13 {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int[] pr = {1,2,5,10};

        int t = sc.nextInt();

        while(t-->0){
            int p = sc.nextInt();
            int counter = 0,in = 3;

            if(p/10>0){
                counter+=p/10;
                p = p%10;
            }
            if(p/5>0){
                counter+=p/5;
                p = p%5;
            }
            if(p/2>0){
                counter+=p/2;
                p = p%2;
            }
            if(p/1>0){
                counter+=p/1;
                p = p%1;
            }

            System.out.println(counter);
        }
    }
}