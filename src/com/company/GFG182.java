//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    public static int countSubstring(String S) {
    int count = 0;
  
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int diff = 0;
    for (int i = 0; i < S.length(); i++) {
        char c = S.charAt(i);
        diff += Character.isUpperCase(c) ? 1 : -1;
        
        if (map.containsKey(diff)) {
            count += map.get(diff);
        }
        map.put(diff, map.getOrDefault(diff, 0) + 1);
    }
    return count;
}
} 
