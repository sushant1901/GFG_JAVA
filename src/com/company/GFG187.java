//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here 
        
        long answer=0;
        int z0=0;
        int z1=0;
        int z2=0;
        
        HashMap<String,Integer>memo= new HashMap<>();
        String expr=(z1-z0)+"-"+(z2-z1);
        memo.put(expr,1);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0') z0++;
            else if(str.charAt(i)=='1') z1++;
            else z2++;
            
            expr=(z1-z0)+"-"+(z2-z1);
            
            if(memo.containsKey(expr)){
                answer+=memo.get(expr);
                memo.put(expr,memo.get(expr)+1);
            }else{
                memo.put(expr,1);
            }
        }
        return answer;
    }
} 
