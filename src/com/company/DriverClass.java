package com.company;
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");
            int sum = Integer.parseInt(str[0]);

            Solution20 ob = new Solution20();

            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
                out.print("Empty");
            }

            // Print all combinations stored in res.
            for (int i = 0; i < res.size(); i++) {
                if (res.size() > 0) {
                    out.print("(");
                    List<Integer> ij = res.get(i);
                    for (int j = 0; j < ij.size(); j++) {

                        out.print(ij.get(j));
                        if(j < ij.size()-1)
                            out.print(" ");
                    }
                    out.print(")");
                }
            }
            out.println();
            res.clear();
        }
        out.flush();
    }

}// } Driver Code Ends


//User function template for JAVA

class Solution20
{
    //Function to return a list of indexes denoting the required
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> finalRes = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> a = new HashSet<>(A);
        ArrayList<Integer> mainList = new ArrayList<Integer>();
        mainList.addAll(a);
        Collections.sort(mainList);
        startSumAgain(B, 0, res, mainList);
        return finalRes;
    }

    static void startSumAgain(int sum, int i, List<Integer> res, ArrayList<Integer> a){
        if(i == a.size()){
            return;
        }
        if(sum == 0){
            ArrayList<Integer> subRes = new ArrayList<>();
            for(Integer val : res){
                subRes.add(val);
            }
            Collections.sort(subRes);
            finalRes.add(subRes);
            return;
        } else if(sum < 0){
            return;
        } else {
            res.add(a.get(i));
            startSumAgain(sum - a.get(i) , i, res, a);
            res.remove(new Integer(a.get(i)));
            startSumAgain(sum, i+1, res, a);
        }

    }
}