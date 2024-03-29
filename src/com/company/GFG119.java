//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        // code here
        int ans =0;
        int n= s.length();
        for(int size=3;size<=n;size++){
            int i=0;
            int j=size;
            int[] freq= new int[26];
            for(int k=i;k<j;k++){
                freq[s.charAt(k)-'a']++;
            }
            ans+=beauty(freq);
            
            while(j<n){
                freq[s.charAt(j)-'a']++;
                freq[s.charAt(i)-'a']--;
                ans+=beauty(freq);
                j++;
                i++;
            }
        }
        return ans;
    }
    
    static int beauty(int[] freq){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i:freq ){
            if(i!=0){
                min=Math.min(min,i);
                max=Math.max(max,i);
            }
        }
        return max-min;
        
    }
}
        
