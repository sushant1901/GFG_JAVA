package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG9 {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        String a;
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            String s = sc.nextLine();
            a = findans(s);
            System.out.println(a);
            t--;
        }
    }
    static String findans(String si){
        String s = si;
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            int first = s.indexOf(ch);

            int second1 = s.indexOf(String.valueOf(ch).toLowerCase(), i + 1);
            int second2 = s.indexOf(String.valueOf(ch).toUpperCase(), i + 1);
            int sec;
            if(second2 == -1 && second1 == -1){
                sec = -1;
            }else if(second2 == -1 && second1 != -1){
                sec = second1;
            }else if(second1 == -1 && second2 != -1){
                sec = second2;
            }else{
                sec = second1>=second2?second2:second1;
            }


            if(sec>=0){
                s = charRemoveAt(s,sec);
            }

            i++;
        }
        return s;
    }
    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }
}