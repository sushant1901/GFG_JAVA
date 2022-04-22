package com.company;
import java.io.*;
import java.util.*;
class GfG52
{
    public static void main (String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            String s = sc.next ();

            System.out.println (new Sol52().divisibleBy4 (s));
        }

    }
}

class Sol52
{
    int divisibleBy4 (String N)
    {
        // Your Code Here
        long sum = 0;
        for (int i = 0; i < N.length(); i++) {
            sum = sum * 10 + (N.charAt(i) - '0');
        }
        if (sum == 1 || sum == 2 || sum == 3)
            return 0;
        if (sum % 4 == 0)
            return 1;
        return 0;
    }
}