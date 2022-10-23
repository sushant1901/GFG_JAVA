//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int steppingNumbers(int n, int m){
        // code here
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        if(n == 0) {
            count++;
        }
        
        for(int i=1;i<=9;i++) {
            queue.add(i);
            
            while(queue.isEmpty() == false) {
                int top = queue.remove();
                
                if(top > m) {
                    continue;
                }
                
                if(top >= n && top <= m) {
                    count++;
                }
                
                if(top % 10 == 0) {
                    queue.add(top * 10 + 1);
                } else if(top % 10 == 9) {
                    queue.add(top * 10 + 8);
                } else {
                    queue.add(top * 10 + ((top % 10) -1));
                    queue.add(top * 10 + ((top % 10) +1));
                }
            }
        }
        
        return count;
    }
}
