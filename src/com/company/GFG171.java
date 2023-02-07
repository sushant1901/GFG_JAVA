//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Graph {
		private int v;
		private List<ArrayList<Integer>> adj;

		public Graph(int v) {
			this.v = v;
			this.adj = new ArrayList<ArrayList<Integer>>(this.v);
			for (int i = 0; i < this.v; i++) {
				this.adj.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(int u, int v) {
			adj.get(u).add(v);
		}

		public List<Integer> topologicalSort() {
			int indegree[] = new int[this.v];
			List<Integer> topologicalOrder = new ArrayList<Integer>();
			for (int u = 0; u < this.v; u++) {
				for (int v : this.adj.get(u)) {
					indegree[v]++;
				}
			}
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int u = 0; u < this.v; u++) {
				if (indegree[u] == 0) {
					queue.add(u);
				}
			}
			while (!queue.isEmpty()) {
				int u = queue.poll();
				topologicalOrder.add(u);
				for (int v : this.adj.get(u)) {
					if (--indegree[v] == 0) {
						queue.add(v);
					}
				}
			}
			if (topologicalOrder.size() != this.v) {
				return new ArrayList<Integer>();
			}
			return topologicalOrder;
		}
	}

	public String findOrder(String[] dict, int N, int K) {
		Graph graph = new Graph(K);
		for (int i = 0; i < N - 1; i++) {
			String s1 = dict[i];
			String s2 = dict[i + 1];
			int len = Math.min(s1.length(), s2.length());
			for (int j = 0; j < len; j++) {
				if (s1.charAt(j) != s2.charAt(j)) {
					graph.addEdge(s1.charAt(j) - 'a', s2.charAt(j) - 'a');
					break;
				}
			}
		}
		List<Integer> topologicalOrder = graph.topologicalSort();
		StringBuilder sb = new StringBuilder();
		for (int num : topologicalOrder) {
			sb.append((char) (num + (int) ('a')));
		}
		return sb.toString();
	}
}
