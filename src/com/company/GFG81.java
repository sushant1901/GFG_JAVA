//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// }
class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int unique = 0;
        
        for(int acq = 0 ; acq < k - 1; acq++){
            int currentVal = A[acq];
            int count = memo.containsKey(currentVal) ? memo.get(currentVal) : 0;
            memo.put(currentVal, count + 1);
            if(count == 0){
                unique++;
            }
        }
       
       int release = 0;
       
        for(int acquire = k-1; acquire < n; acquire++){
            int currentVal = A[acquire];
            
            int count = memo.containsKey(currentVal) ? memo.get(currentVal) : 0;
            memo.put(currentVal, count + 1);
            
            if(count == 0){
                unique++;
            }
            
            list.add(unique);
            
            
            int releaseVal = A[release];
            
            memo.put(releaseVal, memo.get(releaseVal) - 1);
            
            if(memo.get(releaseVal) == 0){
                memo.remove(releaseVal);
                unique--;
            }
            
            release++;

        }
        
        return list;
        
    }
}
