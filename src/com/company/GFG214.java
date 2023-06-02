//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete {
    
    //define global variables
    static int maxCount = 0;
    static ArrayList<Integer> primeNumbers;

    public static void precompute() {
    	//Precomputes prime numbers up to a certain limit.
        primeNumbers = new ArrayList<>();
        int limit = 1299227; //according to the constraint 100000th prime number is 1299227
        int[] sieve = new int[limit + 1];
        
        // Sieve of Eratosthenes algorithm to find prime numbers
        for (int i = 2; i <= limit && i * i <= limit; i++) {
            if (sieve[i] == 0) {
                for (int j = i * i; j <= limit; j += i) {
                    sieve[j] = 1;
                }
            }
        }
        
        // Store prime numbers in the list
        for (int i = 2; i <= limit; i++) {
            if (sieve[i] == 0) {
                primeNumbers.add(i);
            }
        }
    }

    public static void calculateGroupSize(List<List<Integer>> adjList, boolean[] visited, int source) {
        //Calculates the size of the group connected to the given source node.
        
        visited[source] = true;
        maxCount++;
        
        for (int neighbor : adjList.get(source)) {
            if (!visited[neighbor]) {
                calculateGroupSize(adjList, visited, neighbor);
            }
        }
    }

    public static int helpSanta(int n, int m, int[][] connections) {
        if (m == 0) {
            return -1;
        }
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int from = connections[i][0] - 1;
            int to = connections[i][1] - 1;
            
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        
        int largestGroupSize = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            maxCount = 0;
            
            if (!visited[i]) {
                calculateGroupSize(adjList, visited, i);
                
                if (maxCount > largestGroupSize) {
                    largestGroupSize = maxCount;
                }
            }
        }
        
        return primeNumbers.get(largestGroupSize - 1);
    }
}
