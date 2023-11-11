//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends
class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length()!=str2.length()){
            return false;
        }
        HashMap <Character, Character> map = new HashMap<>();
        for(int i =0; i<str1.length(); i++){
            if(!map.containsKey(str1.charAt(i)) && !map.containsValue(str2.charAt(i))){
                map.put(str1.charAt(i), str2.charAt(i));
            }else{
                boolean ans = compare(map, str1.charAt(i), str2.charAt(i));
                if(!ans){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compare(HashMap<Character, Character> map, char a, char b){
        if(map.containsKey(a)){
            if(map.get(a) == b){
            return true;
            }
        }
        return false;
    }
  }
