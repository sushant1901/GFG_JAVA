//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leafNodes(int arr[], int N)
    {
        // code here
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            if(!st.isEmpty()&&st.peek()<arr[i]) {
                int add = st.pop();
                int count = 1;
                while(!st.isEmpty()&&st.peek()<arr[i]) {
                    count++;
                    st.pop();
                }
                if(count>=2)
                list.add(add);
            }
            st.add(arr[i]);
        }
        if(!st.isEmpty())
        list.add(st.pop());
        
        int ret[] = new int[list.size()];
        for(int i=0;i<list.size();i++)
        ret[i] = list.get(i);
        
        return ret;
    }
}
