import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n,m));
        }
    }
}
class Solution
{
     String baseEquiv(int n, int m)

    {

        // code here

        String s=n+"";

        for(int i=2;i<=32;i++){

            String st=Integer.toString(Integer.parseInt(s,10),i);

            if(st.length()==m)

            return "Yes";

        }

        return "No";

    }
}
