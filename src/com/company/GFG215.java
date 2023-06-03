//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        int ii = 0, j = 0 , k = 0, s1 = 0, s2 = 0, s3 = 0;
        for(int i = 0 ; i < N1 ; i++) s1 += S1[i];
        for(int i = 0 ; i < N2 ; i++) s2 += S2[i];
        for(int i = 0 ; i < N3 ; i++) s3 += S3[i];
        while(ii < N1 && j < N2 && k < N3){
            boolean flag = true;
            int min = Math.min(s1, Math.min(s2, s3));
            if(s1 > min){s1 -= S1[ii++];flag = false;}
            if(s2 > min) {s2 -= S2[j++];flag = false;}
            if(s3 > min) {s3 -= S3[k++];flag = false;}
            if(flag) return s1;
        }
        return 0;
    }
}      
