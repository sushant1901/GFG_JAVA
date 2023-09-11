//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());//testcases
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(reader.readLine());//input n
            //printing "1" if isLucky() returns true else "0"
            Solution s = new Solution();
            System.out.println(s.isLucky(n)? "1" : "0");
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
      public static boolean isLucky(int n)
    {
        // Your code here
        int ind=2;
        if(isL(n,ind)) return true;
        return false;
    }
    public static boolean isL(int n,int ind){
        if(n%ind==0) return false;
        if(n<ind) return true;
        return isL(n-(n/ind),++ind);
    }
}
