package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG2 {
    public static void main (String[] args) {
        //code
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();


        for(int i=0;i<test;i++){
            int count = scan.nextInt();
            int[] arr = new int[count];

            for(int s = 0;s<count;s++){
                arr[s] = scan.nextInt();
            }

            int max=arr[0];
            int min =arr[0];
            int m=0;
            while(m<count){
                if(arr[m]>max)
                    max = arr[m];
                if(arr[m]<min)
                    min = arr[m];
                m++;
            }
            System.out.println(max+" "+min);

        }

    }
}
