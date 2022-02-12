package com.company;
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class S{
    static long nineDivisors(long N){
        //Code Here
        int c = 0;

        int limit = (int) Math.sqrt(N);

// Sieve array
        int prime[] = new int[limit + 1];

// initially prime[i] = i
        for (int i = 1; i <= limit; i++) {
            prime[i] = i;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
// mark all factors of i
                for (int j = i * i; j <= limit; j += i) {
                    if (prime[j] == j) {
                        prime[j] = i;
                    }
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
// p prime factor
            int p = prime[i];

// q prime factor
            int q = prime[i / prime[i]];

//
// if p*q<=n and q!=
            if (p * q == i && q != 1 && p != q) {
                c += 1;
            } else if (prime[i] == i) {

// Check if it can be expressed as p^8
                if (Math.pow(i, 8) <= N) {

                    c += 1;
                }
            }
        }

        return c;
    }
}

// { Driver Code Starts.
class GFG12
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());

            S ob = new S();
            System.out.println(ob.nineDivisors(N));
        }
    }
}  // } Driver Code Ends