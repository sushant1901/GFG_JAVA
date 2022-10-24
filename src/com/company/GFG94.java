//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String s[] = new String[N];
            for (int i = 0; i < N; i++) s[i] = read.readLine();
            Solution ob = new Solution();
            alphanumeric ans[] = ob.sortedStrings(N, s);
            for (int i = 0; i < ans.length; i++)
                System.out.println(ans[i].name + " " + ans[i].count);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class alphanumeric {
    public String name;
    public int count;
    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
};
class Solution {
   
 alphanumeric[] sortedStrings(int N, String A[]) {

        

        

        Map<String,Integer> map=new TreeMap<>();

        for(int i=0; i<A.length; i++)

        {

            map.put(A[i],map.getOrDefault(A[i],0)+1);

        }

         alphanumeric[] arr=new alphanumeric[map.size()];

         int i=0;

         for(String ss:map.keySet())

         {

             arr[i++]=new alphanumeric(ss,map.get(ss));

         }

        return arr;

 

    }
};
