package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG4 {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T-->0){
            String s = sc.nextLine();
            String p = sc.nextLine();

            while(s.contains(p+p))
                s = s.replaceAll(p+p,p);
            s = s.replaceAll(p,"X");
            System.out.println(s);
        }
    }
}