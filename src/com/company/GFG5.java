package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG5 {
    public static HashMap<Integer, Integer> SortByValue(HashMap<Integer, Integer> hm){
        List<Map.Entry<Integer, Integer>> lst = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
        Collections.sort(lst,new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
                if(m1.getValue() == m2.getValue())
                    return m1.getKey()-m2.getKey();
                else
                    return m2.getValue()-m1.getValue();
            }
        });
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : lst) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;

    }
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i=0;i<n;i++){
                if(hm.containsKey(arr[i])){
                    int temp = hm.get(arr[i]);
                    hm.put(arr[i],temp+1);
                }
                else
                    hm.put(arr[i],1);
            }
            Map<Integer, Integer> mp = SortByValue(hm);
            for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
                int j = entry.getValue();
                while(j-- > 0)
                    System.out.print(entry.getKey() + " " );
            }
            System.out.println();
        }
    }
}