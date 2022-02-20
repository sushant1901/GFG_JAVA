package com.company;
import java.util.*;


class Find_All_Possible_Strings
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =  sc.nextInt();
        sc.nextLine();
        while(t>0)
        {
            String str = sc.nextLine();
            GfG g = new GfG();
            ArrayList<String> arr = g.spaceString(str);
            for(String s : arr){
                System.out.print(s+"$");
            }
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


/*You have to complete this function*/
class GfG
{
    ArrayList<String> spaceString(String str)
    {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        if(str.length() == 0) return res;

        String op = ""+str.charAt(0);
        str = str.substring(1);
        return solve(str, op, res);

    }
    ArrayList<String> solve(String ip, String op, ArrayList<String> res){
        if(ip.length() == 0){
            res.add(op);
            return res;
        }
        String op1 = op;
        String op2 = op;
        op1 += " "+ip.charAt(0);
        op2 += ip.charAt(0);

        ip = ip.substring(1);

        solve(ip, op2, res);
        solve(ip, op1, res);


        return res;
    }
}
