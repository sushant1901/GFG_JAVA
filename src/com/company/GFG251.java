//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
	public boolean findTriplets(int arr[] , int n)
    {
        for(int i=0;i<n;i++){
            if(findPair(arr,i,arr[i])==true) return true;
        }
        return false;
    }
    boolean findPair(int arr[],int idx,int sum){
        int count=0;
        Set<Integer> set=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(i!=idx){
                if(set.contains(-(arr[i]+sum))){
                    return true;
                }
                set.add(arr[i]);
            }
        }
        return false;
    }
}
