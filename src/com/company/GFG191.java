//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] color = IntArray.input(br, N);
            
            
            int[] radius = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.finLength(N, color, radius);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Ball{
    int color;
    int radius;
    public Ball(int color,int radius){
        this.color=color;
        this.radius=radius;
    }
}
class Solution {
    public static int finLength(int N, int[] color, int[] radius) {
        Stack<Ball>S1= new Stack<>();
        Stack<Ball>S2= new Stack<>();
        
        for(int i=0;i<N;i++){
            S1.push(new Ball(color[i],radius[i]));
        }
        while(!S1.isEmpty()){
             Ball Temp1=S1.pop();
            if(S2.isEmpty()){
                S2.push(Temp1);
            }
            else{
                if(S2.peek().color!=Temp1.color ||S2.peek().radius!=Temp1.radius){
                    S2.push(Temp1);
                }
                else
                {
                    S2.pop();
                }
            }
        }
        return S2.size();
    }
}


        
