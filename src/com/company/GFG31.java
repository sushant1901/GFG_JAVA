package com.company;
import java.util.*;
import java.io.*;
class GFG31 {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Sol9 ob = new Sol9();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Sol9 {
    static long nthFibonacci(long n){
        HashMap<Long,Long> a = new HashMap<Long,Long>((int)n);
        return solve(a,n,1000000007);
    }

    static long solve(HashMap<Long,Long> a,long n,long m){
        if(!a.containsKey(n)){

            if(n==0 || n==1){
                return n;
            }else{
                a.put(n,(solve(a,n-1,m)+solve(a,n-2,m))%m);
            }

        }
        return a.get(n)%m;
    }
}