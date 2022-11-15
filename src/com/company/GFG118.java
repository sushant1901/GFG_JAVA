//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


    class Solution {
    static int longestPerfectPiece(int[] nums, int N) {
        int ele1 = nums[0];
        int ele2 = nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 1;
        int left = 0;
        int right = -1;
        while(true) {
            right++;
            if(right>=N)
            break;
            if(ele1==ele2&&nums[right]!=ele1) {
                if(nums[right]-1==ele1||nums[right]+1==ele2)
                ele2 = nums[right];
            }
            if(nums[right]!=ele1&&nums[right]!=ele2) {
                if(nums[right]-1==ele1||nums[right]+1==ele1) {
                    left = map.get(ele2)+1;
                    ele2 = nums[right];
                }
                else if(nums[right]-1==ele2||nums[right]+1==ele2) {
                    left = map.get(ele1)+1;
                    ele1 = nums[right];
                }
                else {
                    left = right;
                    ele1 = ele2 = nums[right];
                }
            }
            ans = Math.max(ans,right-left+1);
            map.put(nums[right],right);
        }
        return ans;
    }
};
