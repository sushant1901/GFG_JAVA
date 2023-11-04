//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int transitionPoint(int arr[], int n) {
        // code here
    int l=0,r=n-1;
        int k = n-1;
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(arr[mid]==0)
            l = mid+1;
            else 
            r = mid-1;
        }
        if( l>k) return -1;
        return l;
    }
}
