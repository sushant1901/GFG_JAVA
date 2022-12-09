//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String buildLowestNumber(String S, int K) {
        // code here
        StringBuilder sb = new StringBuilder();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<S.length();i++)
        {
            while(!st.isEmpty() && st.peek()>(S.charAt(i)-'0') && K>0)
            {
                st.pop();
                K--;
            }
            if(!st.isEmpty() || S.charAt(i)!='0')
            {
                st.push(S.charAt(i)-'0');
            }
            
        }
        while(!st.isEmpty()&&K>0)
        {
            st.pop();
            K--;
        }
        if(st.isEmpty())
        {
            return "0";
        }
        while(!st.isEmpty())
        {
            //char temp=(st.pop()+'0');
            sb.append(st.pop());
        }
         String str = sb.reverse().toString();
        return str;
    }
}
