package com.company;
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG44 {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

            for(int i=0; i<N-1; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                String S[] = read.readLine().split(" ");
                temp.add(Integer.parseInt(S[0]));
                temp.add(Integer.parseInt(S[1]));
                arr.add(temp);
            }

            Solutio ob = new Solutio();
            System.out.println(ob.maxBinTreeGCD(arr,N));
        }
    }
}// } Driver Code Ends

class Solutio{
    static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
        // code here
        if(N==0 || N==1){
            return 0;
        }

        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for (ArrayList<Integer> item : arr) {
            if(item.size()<=1){
                continue;
            }
            int root = item.get(0);
            int value = item.get(1);
            if (!tree.containsKey(root)) {
                tree.put(root, new ArrayList<Integer>());
            }
            if (!tree.containsKey(value)) {
                tree.put(value, new ArrayList<Integer>());
            }
            tree.get(root).add(value);
        }
        int maxGcd = 0;
        for (java.util.Map.Entry<Integer, ArrayList<Integer>> graph : tree.entrySet()) {
            if (graph.getValue().size() <=1) {
                continue;
            }

            int a = Math.max(graph.getValue().get(0), graph.getValue().get(1));
            int b = Math.min(graph.getValue().get(0), graph.getValue().get(1));

            int gcd = gcd(a, b);
            maxGcd = Math.max(maxGcd, gcd);

        }

        return maxGcd;
    }

    static int gcd(int a, int b)
    {

        if (a == 0)
            return b;
        if (b == 0)
            return a;


        if (a == b)
            return a;


        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);

    }
}