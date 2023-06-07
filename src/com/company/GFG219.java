//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=i;
        }
        for(int i=2;i*i<=n;i++){
            if(arr[i]==i){
                for(int j=i*i;j<=n;j=j+i){
                    if(arr[j]==j)
                    arr[j]=arr[i];
                }
            }
        }
        return arr;
    }
}
