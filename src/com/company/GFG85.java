//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

class Node { 
	int data; 
	Node left, right; 
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 


class GFG {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputline[i]);
            }
            
            Node res = post_order(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }
    
    
    
    
// } Driver Code Ends
//User function Template for Java


//Function that constructs BST from its preorder traversal.
private static Node f(Node root,int ele){
   if(ele<root.data){
       if(root.left==null){
           root.left=new Node(ele);
           return root;
       }
       return f(root.left,ele);
   }
   else{
       if(root.right==null){
           root.right=new Node(ele);
           return root;
       }
       return f(root.right,ele);
   }
}
public static Node post_order(int pre[], int size) 
{
   //Your code here
   Node root=new Node(pre[0]);
   for(int i=1;i<size;i++){
       f(root,pre[i]);
   }
   return root;
} 

//{ Driver Code Starts.


public static 	void printInorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 
	
public static 	void printPostorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printPostorder(node.left); 
		printPostorder(node.right);
		System.out.print(node.data + " "); 
	} 
	
public static 	void printPreorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		printPreorder(node.left); 
		printPreorder(node.right);
	} 

}
// } Driver Code Ends
