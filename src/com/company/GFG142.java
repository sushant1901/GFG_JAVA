//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        long max = 0;
        for(int i=0;i<q;i++){
            max = Math.max(max,query.get(i));
        }
        long nmax = (long)Math.sqrt(max); //nmax means new maximum
        boolean arr[] = new boolean[(int)nmax+1];
        Arrays.fill(arr,true);
        for(int i=2;i<=nmax;i++){
            if(arr[i]){
                for(int j=2;j*i<=nmax;j++){
                    arr[j*i] = false;
                }
            }
        }
        int sum = 0;
        int ans[] = new int[arr.length];
        for(int i=2;i<arr.length;i++){
            if(arr[i]){
                sum++;
            }
            ans[i] = sum;
        }
        for(int i=0;i<query.size();i++){
            res.add((int)ans[(int)Math.sqrt(query.get(i))]);
        }
        return res;
    }
    
    
   
}
