package com.company;

import java.util.*;
class Replace{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Solution2 g=new Solution2();
            g.convertFive(n);
        }
    }
}
 class Solution2{
    public static void convertFive(int n){
//add code here.
        String num=Integer.toString(n);
        char[] arr=num.toCharArray();
        char temp='5';
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='0')
            {
                arr[i] =temp;
            }
            sb.append(arr[i]);
        }
        int num1=Integer.parseInt(sb.toString());
        System.out.println(num1);
    }
}
