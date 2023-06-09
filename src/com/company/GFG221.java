//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> ans = new ArrayList<String>();
        getPerm(0,S.length(),S,ans);
        HashSet<String> set = new HashSet<String>();
        for(String i:ans)
        {
            set.add(i);
        }
        ans.clear();
        for(String i:set)
        {
            ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
    public void getPerm(int ind,int n,String str,List<String> ans)
    {
        if(ind==n-1)
        {
            ans.add(str);
            return;
        }
        for(int i=ind;i<n;i++)
        {
            str=swap(str,i,ind);
            getPerm(ind+1,n,str,ans);
            str=swap(str,i,ind);
        }
    }
    public String swap(String s,int i,int j)
    {
        char arr[]=s.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
        String res = new String(arr);
        return res;
    }
}
