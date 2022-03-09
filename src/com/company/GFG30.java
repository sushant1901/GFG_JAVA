package com.company;
import java.util.*;
import java.math.*;

class GFG30{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Sol6 g=new Sol6();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
class Sol6
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        BigInteger num1 = new BigInteger(s1);
        BigInteger num2= new BigInteger(s2);
        BigInteger res= num1.multiply(num2);

        return res.toString();



    }
}