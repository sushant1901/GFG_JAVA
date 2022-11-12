// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            String S1 = br.readLine().trim();
            String S2 = br.readLine().trim();
            String S3 = br.readLine().trim();
            
            Solution soln = new Solution();
            if(soln.solve(n, S1, S2, S3))
                ot.println(1);
            else
                ot.println(0);
        }

        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public boolean solve(int N, String S1, String S2, String S3){
        // Code your solution here.
        char[] arr1=S1.toCharArray();
        char[] arr2=S2.toCharArray();
        char[] arr3=S3.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        
        String s_1=new String(arr1);
        
        String s_2= new String(arr2);
        
        String s_3=new String(arr3);
        
       if(s_1.equals(s_2) || s_1.equals(s_3) || s_2.equals(s_3)) return true;
       
       return false;
    }
}
