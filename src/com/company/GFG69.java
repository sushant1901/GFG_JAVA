import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int capacity, int val[], int wt[])
    {
        // code here
        int[][] dp=new int[N][capacity+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<capacity+1;j++){
                dp[i][j]=-1;
            }
        }
        return maxProfit(wt,val,0,capacity,N,dp);
    }
    private static int maxProfit(int[]wt,int[]val,int currentItem,int capacity,int N,int[][]dp){
        if(capacity==0) return 0;
        if(currentItem==N) return 0;
        
        int currentItemWeight=wt[currentItem];
        int currentItemProfit=val[currentItem];
        
        //String currentKey=Integer.toString(currentItem)+"-"+Integer.toString(capacity);
        
        //if(memo.containsKey(currentKey))
        //return memo.get(currentKey); 
        if(dp[currentItem][capacity]!=-1)
        return dp[currentItem][capacity];
        
        
        int consider =0;
        if(currentItemWeight<=capacity){
            consider=currentItemProfit+maxProfit(wt,val,currentItem,capacity-currentItemWeight,N,dp);
        }
        int notConsider=maxProfit(wt,val,currentItem+1,capacity,N,dp);
        //memo.put(currentKey,Math.max(consider,notConsider));
        
        dp[currentItem][capacity]=Math.max(consider,notConsider);
        return dp[currentItem][capacity] ;
    }
}
