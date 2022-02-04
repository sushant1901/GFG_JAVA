package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class WeightOfString {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
//       input
            String s1= sc.next();
            String s2 = sc.next();
            int sum1 =0;
            int sum2 =0;
//          Making char arrays
            char a[] = s1.toLowerCase().toCharArray();
            char b[] = s2.toLowerCase().toCharArray();
//          Loops for sum

            for(int j=0; j<s1.length();j++){
                sum1 = sum1 + a[j];
            }
            for(int j=0; j<s2.length();j++){
                sum2 = sum2 + b[j];
            }
//          Checker
            if(sum1>sum2){
                System.out.println("1");
            }else if(sum1<sum2){
                System.out.println("2");
            }else{
                System.out.print("equal");
            }
        }
    }

}
