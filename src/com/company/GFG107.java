//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution{

    static List<Integer> minPartition(int N)

    {

        // code here

        List<Integer> list=new ArrayList<Integer>();

        int arr[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

        int ln =arr.length-1;

        for(int i=ln; i>=0; i--){

            while(N>=arr[i]&& N>0){

                N=N-arr[i];

                list.add(arr[i]);

            }

            if(N==0){

                break;

            }

        }

        return list;

    }

}
