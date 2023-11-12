//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    public static boolean isRotated(String str1, String str2)
    {
        // Your code here
        
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int size = a.length;
        boolean flagRight =true;
        boolean flagLeft = true;
        for(int i =0;i<size;i++){
            if(flagRight && a[(i+2)%size] != b[i]){
                flagRight = false;
            }
            
             if(flagLeft && a[(size +i-2)%size] != b[i]){
                flagLeft = false;
            }
        }
        return flagLeft || flagRight;
    }
    
}
