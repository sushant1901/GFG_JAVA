package com.company;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}

class GFG58 {


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
    public static void inorder(Node root){
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution58 obj = new Solution58();
            int res = obj.sumOfLongRootToLeafPath(root);
            System.out.println(res);
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution58{
    class Pair{
        int lvl;
        int sum;

        public Pair(int lvl, int sum){
            this.lvl = lvl;
            this.sum = sum;
        }
    }

    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        if(root == null)return 0;

        Pair ans = solve(root);
        return ans.sum;
    }


    public Pair solve(Node root){
        if(root == null)
            return new Pair(0, 0);

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int ht = Math.max(left.lvl, right.lvl)+1;
        int sum = 0 ;
        if(left.lvl > right.lvl){
            sum = left.sum;
        }else if(left.lvl < right.lvl){
            sum = right.sum;
        }else if(left.lvl == right.lvl){
            sum = left.sum > right.sum ? left.sum : right.sum;
        }

        Pair ans = new Pair(ht, sum+root.data);
        return ans;
    }
}