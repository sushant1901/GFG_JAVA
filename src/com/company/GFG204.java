//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public Node construct(int l1, int r1, int l2, int r2, int[] pre, int[] preM){
        if(l1==r1 && l2==r2){
            return new Node(pre[l1]);
        }
        int val=pre[l1];
        Node root=new Node(val);
        int m1=(l1+r1+2)/2;
        int m2=(l2+r2+2)/2;
        root.left=construct(l1+1, m1-1, m2, r2, pre, preM);
        root.right=construct(m1, r1, l2+1, m2-1, pre, preM);
        return root;
    }
    public Node constructBTree(int pre[], int preM[], int size)
    {
        return construct(0, size-1, 0, size-1, pre, preM);
    }
}

