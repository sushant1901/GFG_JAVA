//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
class Solution
{
    public boolean findPair(int nums[], int size, int n)
    {
        HashMap<Integer,Integer> memo= new HashMap<>();
        for( int i=0;i<nums.length;i++){
            int complement= n+nums[i];
            if(memo.containsKey(complement) || memo.containsKey(nums[i]-n)){
                return true;
            }
            memo.put(nums[i],1);
        }
        return false;

    
}
    
}
