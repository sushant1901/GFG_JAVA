//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] a) {
        Stack<Integer> st = new Stack<>();
        st.push(a[0]);
        for(int i=1;i<N;i++){
            if(st.peek()>0 && a[i]<0){
                while(!st.isEmpty() && st.peek()>0 && st.peek()<=Math.abs(a[i])){
                    if(st.peek()==Math.abs(a[i])){
                        st.pop();
                        break;
                    }
                    else{
                        st.pop();  
                        if(st.isEmpty() || st.peek()<0){
                            st.push(a[i]);
                            break;
                        } 
                    }
                } 
            }
            else st.push(a[i]);
        }
        Object[] arr1 = st.toArray();
        int[] arr2 = new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            arr2[i]=(int) arr1[i];
        }
        return arr2;
    }
}
