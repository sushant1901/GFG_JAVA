package com.company;
import java.util.*;
class GFG10 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Testcases=scanner.nextInt();
        while(Testcases!=0)
        {
            int N,X,count=0;
            N=scanner.nextInt();
            X=scanner.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++)
            {
                arr[i]=scanner.nextInt();
            }

            for(int i=0;i<N;i++)
            {
                if(arr[i]>X)
                {
                    count++;
                }
            }
            Testcases--;
            System.out.println(count);
        }
    }

}
