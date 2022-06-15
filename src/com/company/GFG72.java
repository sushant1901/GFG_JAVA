import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();
            
            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        int[] score = {3,5,10};
        return totalWays(score, 0, n, new HashMap<String,Integer>());
    }
    public int totalWays(int[] score, int currentIndex, int n, HashMap<String,Integer> memo){
        if(n==0)
            return 1;
        if(currentIndex >= score.length)
            return 0; 
        
        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(n);
        
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        
        int consider = 0; 
        if(score[currentIndex] <= n){
            consider = totalWays(score, currentIndex, n - score[currentIndex], memo);
        }
        
        int notConsider = totalWays(score, currentIndex + 1, n, memo);
        
        memo.put(currentKey, consider + notConsider);
        
        return memo.get(currentKey); 
    }
}
