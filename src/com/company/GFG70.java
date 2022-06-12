import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
class Solution{
    public int cutRod(int price[], int n) {
        int[][] arr = new int[price.length][n+1];
        return maxValue(price, 0, n, arr);
    }
    public int maxValue(int[] price, int currentIndex, int n, int[][] memo)
    {
        if(n==0){
            return 0;
        }
        if(currentIndex >= price.length){
            return 0;
        }
        
        if(memo[currentIndex][n]!=0){
            return memo[currentIndex][n];
        }
        
        int consider = 0;
        if(currentIndex + 1 <= n){
            consider = price[currentIndex] + maxValue(price, currentIndex, n - (currentIndex + 1), memo);
        }
        else
        return 0;
        int notConsider = maxValue(price, currentIndex + 1, n, memo);
        
        memo[currentIndex][n] = Math.max(consider, notConsider);
        return memo[currentIndex][n];
        
    }
}
