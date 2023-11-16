//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt(), K = sc.nextInt();
            Solution ob = new Solution();
            String ans = ob.findString(N, K);
            boolean ok = true;
            for(int i = 0; i < ans.length(); i++){
                char c = ans.charAt(i);
                if(c < '0' || c > K - 1 + '0')
                    ok = false;
            }
            if(!ok){
                out.println("-1");
                continue;
            }
            HashSet<String> st = new HashSet<String>();
            for(int i = 0; i + N - 1 < ans.length(); i++){
                st.add(ans.substring(i, i+N));
            }
            int tot = 1;
            for(int i=1;i<=N;i++)
                tot *= K;

            if(st.size() == tot){
                out.println(ans.length());
            }
            else{
                out.println("-1");
            }
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Ja
class Solution{
    public String findString(int n, int k){
       
       StringBuilder ans = new StringBuilder();
       for(int i = 0; i < n; i++){
           ans.append('0'); // intiate with 0. because minimal n can be 1.
       }
       
       HashMap<String, Integer> map = new HashMap<>();
       map.put(ans.toString(), 1);// 1 is just for maintaing the hashmap requirements.
       
       int cnt = k-1;
       StringBuilder curr = new StringBuilder();
       curr.append(ans);
       
       
       while(true){
          StringBuilder temp = new StringBuilder(curr.substring(1));
          temp.append((char)(cnt + '0'));
         
          if(!map.containsKey(temp.toString())){
              map.put(temp.toString(), 1);
              ans.append((char)(cnt + '0'));
              curr = temp;
              cnt = k-1;
          }else{
              cnt--;
          }
          if(cnt == -1){
              break;
          }
       }
       
       return ans.toString();
    }
            }
