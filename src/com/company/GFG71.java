import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

// } Driver Code Ends


class Solution{
   long maxSubarraySum(int arr[], int n){
       int cSum=arr[0];
       int oSum=arr[0];
       for(int i=1;i<n;i++){
           if(cSum>=0)
            cSum+=arr[i];
           else
            cSum=arr[i];
        
           if(cSum>oSum)
            oSum =cSum;
            
       }
       return (long)oSum;
   }
}
