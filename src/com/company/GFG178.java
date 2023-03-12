//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
private static boolean isAllocationPossible(long barrier, int arr[], int n, int students)
    {
        int allocatedStudents = 1;
        long pages = 0;
        for(int i = 0; i < n; i++){
            // if(arr[i] > barrier) return false;
            if(pages + arr[i] <= barrier){
                pages += arr[i];
            }else{
                allocatedStudents++;
                if(allocatedStudents>students ||arr[i]>barrier){
                    return false;
                }
                pages = arr[i];
            }
        }
       
        return true;
    }
    
     
    static long minTime(int[] arr,int n,int k){
        long low = 0, high = 0;
        for(int i = 0; i < n; i++){
            high += arr[i];
        }
        
        long mid, res = -1;
        while(low <= high)
        {
            mid = (low + high) >> 1;
            
            if(isAllocationPossible(mid, arr, n, k) ){
                res = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return res;
    }
}
