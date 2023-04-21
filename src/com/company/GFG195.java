//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int prefixSuffixString(String s1[],String s2[])
    {
        Map<String,Boolean> mm = new HashMap<>();
        String temp = "",x="";
        for(int j=0;j<s1.length;j++){
            x=s1[j];
            for(int i=0;i<x.length();i++){
                temp = x.substring(0,i+1);
                mm.putIfAbsent(temp,true);
            }
            for(int i=x.length()-1;i>=0;i--){
                temp = x.substring(i,x.length());
                mm.putIfAbsent(temp,true);
            }
        }
        int ans=0;
        for(int i=0;i<s2.length;i++){
            x=s2[i];
            if(mm.get(x)!=null)ans++;
        }
        return ans;
    
    }
}
