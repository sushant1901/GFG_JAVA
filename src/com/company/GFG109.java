//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

class Solution

{

    public int[] twoOddNum(int Arr[], int N)

    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
                map.put(Arr[i], map.getOrDefault(Arr[i],0)+1);
            
        }
        int k=0;
        int [] arr= new int[2];
        for(Map.Entry<Integer, Integer>  entry: map.entrySet()){
            if(entry.getValue() %2 != 0 ){
                arr[k] = entry.getKey();
                k++;
            }
            if(k==2) break;
        }
        if(arr[0] < arr[1]){
            int temp=arr[1];
            arr[1]=arr[0];
            arr[0]=temp;
        }
        return arr;
    }
}
