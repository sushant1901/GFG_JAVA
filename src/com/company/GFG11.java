package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG11 {
    public static void main (String[] args) {
        //code
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();


        for(int i=0;i<test;i++){
            int result = 0;
            int temp = 0;
            int size = scan.nextInt();
            int[] arr = new int[size];

            for(int j=0;j<size;j++){
                arr[j] = scan.nextInt();
            }

            for(int j=size-1;j>=0;j--){
                if(temp%2==0){
                    result +=(arr[j]*arr[j]);
                    temp++;
                }else{
                    result -=(arr[j]*arr[j]);
                    temp++;
                }
            }
            System.out.println(result);
        }


    }
}