//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    String reverseEqn(String S) {
        String[] arr = S.split("[+*-/]");
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (isOperator(c)) {
                st.push(c);
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (!st.isEmpty()) {
                sb.append(st.pop());
            }
        }

        return sb.toString();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
