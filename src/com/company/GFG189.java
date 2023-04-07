import java.io.*;
import java.util.*;
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}

class Solution{
    public static int lenOfLongSubarr (int nums[], int N, int k) {
        //Complete the function
        int answer=0;
        int prefixSum=0;

        HashMap<Integer,Integer> memo= new HashMap<>();
        memo.put(prefixSum,-1);

        for(int i=0;i<N;i++){
            prefixSum+=nums[i];
            if(memo.containsKey(prefixSum-k)) answer=Math.max(answer,i-memo.get(prefixSum-k));
            if(!memo.containsKey(prefixSum)) memo.put(prefixSum,i);
        }

        return answer;
    }
    
    
}


