//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        if(hand.length % groupSize != 0) return false;
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for (int values : hand){
            pq.add(values);
        }
        while(!pq.isEmpty()){
            int smallest = pq.poll();
            for(int i =1;i<groupSize;i++){
                if(pq.remove(smallest+i)) continue;
                else return false;
            }
        }
        return true;
    }
}
