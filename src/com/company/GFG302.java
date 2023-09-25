//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Node> heap = new PriorityQueue<>();
        Node root=new Node(A[N-1]+B[N-1], N-1, N-1);
        heap.add(root);
        List<Integer> ans = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        visited.add(root);
        while(K-->0){
            // System.out.println(heap);
            Node curr = heap.poll();
            ans.add(curr.sum);
            if(curr.i>0){
                Node next = new Node(A[curr.i-1]+B[curr.j],curr.i-1,curr.j);
                if(visited.add(next))
                    heap.add(next);
            }
                
            if(curr.j>0){
                Node next = new Node(A[curr.i]+B[curr.j-1],curr.i,curr.j-1);
                if(visited.add(next))
                    heap.add(next);
            }
                
        }
        return ans;
        
    }
}
class Node implements Comparable<Node>{
    public int sum;
    int i,j;
    Node(int sum, int i, int j){
        this.sum = sum;
        this.i=i;
        this.j=j;
    }
    public int compareTo(Node other){
        return other.sum-this.sum;
    }
    public String toString(){
        return String.format("(%d, %d, %d)", sum, i, j);
    }
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null ||  this.getClass() != o.getClass())
            return false;
        Node node = (Node) o;
        return node.sum==this.sum && node.i==this.i && node.j==this.j;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(sum, i, j);
    }
}

