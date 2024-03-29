//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int t = 1;
        while(t <= s.length()){
            ArrayList<String> temp = new ArrayList<>();
            String str = s.substring(0,t);
            for(int i = 0 ; i < n ; i++){
                if(contact[i].startsWith(str)){
                    if(!temp.contains(contact[i])){
                        temp.add(contact[i]);
                    }
                }
            }
            if(temp.size()==0){
                temp.add("0");
            }
            Collections.sort(temp);
            result.add(temp);
            t+=1;
        }
        return result;
    }
}
