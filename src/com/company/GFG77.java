import java.util.*;

class MaxLenZeroSumSub
{

    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer>memo=new HashMap<Integer,Integer>();
        int prefixSum=0;
        int ans=0;
        memo.put(prefixSum,-1);
        for(int i=0;i<n;i++){
            prefixSum += arr[i];
            if(memo.containsKey(prefixSum)){
                ans=Math.max(ans,i-memo.get(prefixSum));
            }else{
                memo.put(prefixSum,i);
            }
            
        }
        return ans;
    }
}
