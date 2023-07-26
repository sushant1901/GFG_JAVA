//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String arr[] = br.readLine().split(" ");
	            int k = Integer.parseInt(arr[0]);
	            int node = Integer.parseInt(arr[1]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution g = new Solution();
        		System.out.println(g.kthAncestor(root,k,node));
                    t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
Structure of Node class is:

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class Solution
{
    void mapping(Node root,Map<Node,Node> map){
        Queue<Node> qu = new LinkedList<>();
        
        qu.add(root);
        
        while(!qu.isEmpty()){
            Node curnode = qu.remove();
            
            if(curnode.left != null){
                qu.add(curnode.left);
                map.put(curnode.left,curnode);
            }
            if(curnode.right != null){
                qu.add(curnode.right);
                map.put(curnode.right,curnode);
            }
        }
    }
    Node head;
    public int kthAncestor(Node root, int k, int node) throws NullPointerException
    {
        try{
            head = null;
            Map<Node,Node> map = new HashMap<>();
            mapping(root,map);
            helper(root,node);
            
            while(k-->0){
                Node temp = map.get(head);
                head = temp;
            }
            return head.data;     
        }catch(NullPointerException ex){
            return -1;
        }
    }
    void helper(Node curnode,int target){
        if(curnode == null) return;
        
        if(curnode.data == target){
            head = curnode;
        }
        
        helper(curnode.left,target);
        helper(curnode.right,target);
    }
}
