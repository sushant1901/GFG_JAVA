//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.sort(range,new Comparator<int[]>() {
            public int compare(int a[],int b[]){
                return a[0]-b[0];
            }
        } );
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        arr.add(range[0][0]);arr.add(range[0][1]);
        list.add(arr);
        for(int i=1;i<n;i++){
            if(list.get(list.size()-1).get(1)>=range[i][0]){
                list.get(list.size()-1).set(1,Math.max(list.get(list.size()-1).get(1),range[i][1]));
            }
            else{
                List<Integer> array=new ArrayList<>();
                array.add(range[i][0]);array.add(range[i][1]);
                list.add(array);
            }
        }
        for(int i=0;i<q;i++)
        {
            int ele=queries[i];
            boolean added=false;
            for(int j=0;j<list.size();j++){
                int window=list.get(j).get(1)-list.get(j).get(0)+1;
                if(window<ele){
                    ele=ele-window;
                }
                else{
                    added=true;
                    ans.add(list.get(j).get(0)+ele-1);
                    break;
                }
            }
            if(added==false){
                ans.add(-1);
            }
        }
        return ans;
    }
}      
