package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG8 {
    public static String sortString(String str){
        char [] tempArray=str.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        while(T-->0){
            String str= sc.next();
            System.out.println(sortString(str));

        }
    }
}