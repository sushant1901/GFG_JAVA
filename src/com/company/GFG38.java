import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}// } Driver Code Ends


class Solution
{
    public BigInteger findCatalan(int n)
    {
        return nthCatalan(n,new HashMap<Integer, BigInteger>());
    }
    public BigInteger nthCatalan(int n, HashMap<Integer, BigInteger> memo){
        if(n <= 1){
            return BigInteger.ONE;
        }
        
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        
        BigInteger num = BigInteger.ZERO;
        
        for(int i = 0; i < n; i++){
            num = num.add(nthCatalan(i, memo).multiply(nthCatalan(n -i -1, memo)));
        }
        
        memo.put(n, num);
        return memo.get(n);
    }
}
