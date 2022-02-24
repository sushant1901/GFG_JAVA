package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG29
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution15 obj = new Solution15();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();

        }
    }
}

// } Driver Code Ends


class Solution15 {
    String swap(String s , int i , int j)
    {
        char ch[] = s.toCharArray();
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
        return String.valueOf(ch);
    }
    void permutate(ArrayList<String> al , String s , int l , int r)
    {
        if(l == r)
        {
            al.add(s);
            return;
        }
        for(int i = l; i <=r ; i++)
        {
            s = swap(s , l , i);
            permutate(al , s , l+1 , r);
            s = swap(s , l , i);
        }
    }
    public List<String> find_permutation(String s)
    {
        ArrayList<String> al = new ArrayList<>();
        permutate(al , s , 0 , s.length()-1);
        Collections.sort(al);
        return al;
    }
}