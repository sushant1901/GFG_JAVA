//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    static int longestSubsequence(int size, int a[])
    {
        int[] ans = new int[size];
        int length = 1;
        ans[0] = a[0];

        for (int i = 1; i < size; i++) {
            
            if (a[i] < ans[0]) {
                ans[0] = a[i];
            } 
            else if (a[i] > ans[length - 1]) {
                ans[length] = a[i];
                length++;
            } 
            else {
                int idx = binarySearch(ans, 0, length - 1, a[i]);
                ans[idx] = a[i];
            }
        }

        return length;
    }

    private static int binarySearch(int[] ans, int left, int right, int key) {
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (ans[mid] == key)
                return mid;
            
            else if (ans[mid] < key)
                left = mid + 1;
            
            else
                right = mid - 1;
            
        }
        return left;
    }
} 
