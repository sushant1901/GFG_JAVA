//{ Driver Code Starts

//Initial Template for Java



import java.io.*;

import java.util.*;

import java.lang.*; 

class GfG

{

    public static void main (String[] args)

    {

        

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        

        while(t-- > 0)

        {

            long n = sc.nextLong();

    		System.out.println (new Solution().colName (n));

        }

        

    }

}
class Solution

{

    String colName (long n)

    {

        // your code here

        StringBuilder sb = new StringBuilder();

        int i = 1;

        while (n > 0) {

            long num = n % 26;

            if (num == 0) {

                num = 26;

                n--;

            }

            n = n / 26;

            sb.append((char)(65+num-1));

        }

        return sb.reverse().toString();

    }

          }
