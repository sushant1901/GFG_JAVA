package com.company;
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
            Sol g=new Sol();
            if(g.findTriplets(a,n))
                System.out.println("1");
            else
                System.out.println("0");

        }
    }
}// } Driver Code Ends


/*Complete the function below*/


class Sol
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int z=j+1;z<arr.length;z++){
                    if(arr[i]+arr[j]+arr[z]==0){
                        return true;
                    }
                }
            }
        }
        return false;

    }
}