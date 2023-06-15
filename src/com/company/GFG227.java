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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static void checkForOddEven(String s,int n,int container[], boolean even){
        for(int i = 0; i<n;i++){
            int l = i,r = i;
            if(even)l--;    // if evene length check even wise
            
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            
            r--; l++;
            
            int k = r-l+1;        // length of current string
            if(k>container[2]){
                container[2] = k;  
                container[1] = r;
                container[0] = l;
            }
        }
    }
    
    static String longestPalin(String s){
        int n = s.length();
        
        int container[]=new int[3];
        
        checkForOddEven(s,n,container,false);
        checkForOddEven(s,n,container,true);
        
        
        String res = "";
        for(int i = container[0]; i<=container[1]; i++)res += s.charAt(i);
        return res ;
    }
}
