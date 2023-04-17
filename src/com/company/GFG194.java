//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a, b)-> a.deadline-b.deadline);
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b)-> b.profit-a.profit);
        
        int count = 0, sum = 0;
        for(int i=n-1; i>=0; i--) {
            
            int slot = 0;
            if(i == 0) slot = arr[i].deadline;
            else slot = arr[i].deadline-arr[i-1].deadline;
            
            pq.add(arr[i]);
            
            while(slot>0 && pq.size()>0) {
                
                Job job = pq.poll();
                count++;
                sum+=job.profit;
                
                slot--;
            }
        }
        
        return new int[]{count, sum};
    }
}
