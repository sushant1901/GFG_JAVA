package com.company;
import java.io.*;
import java.util.*;

class GFG24
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < N ; i++){
                arr.add(sc.nextInt());
            }
            Solution6 ob = new Solution6();

            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution6{
    void func(int ind,int sum, ArrayList<Integer>arr, int N, ArrayList<Integer> sumSubset){
        if(ind == N){
            sumSubset.add(sum);
            return;
        }
        // pick the element
        func(ind+1,sum + arr.get(ind),arr,N,sumSubset);
        //do not pick the element
        func(ind+1,sum,arr,N,sumSubset);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr,int N){
        ArrayList<Integer> sumSubset = new ArrayList<>();
        func(0,0,arr,N,sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

}