package com.company;
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


class GfG28 {

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
    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Spiral g = new Spiral();
            ArrayList<Integer> result = g.findSpiral(root);
            for(int value : result)
                System.out.print(value + " ");
            System.out.println();

        }
    }
}


class Spiral
{
    //Function to return a list containing the level order
    //traversal in spiral form.
    ArrayList<Integer> findSpiral(Node root)
    {
        // Your code here
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        if(root == null)
            return al;

        q.add(root);
        int size = 0;
        int count = 0;

        while(!q.isEmpty()) {
            size = q.size();
            count++;

            for(int i=0;i<size;i++) {

                Node temp = q.poll();
                st.push(temp.data);

                if(temp.left != null)
                    q.add(temp.left);

                if(temp.right != null)
                    q.add(temp.right);

            }

            if(count % 2 != 0) {
                while(!st.isEmpty())
                    al.add(st.pop());
            }

            else {
                for(Integer a:st)
                    al.add(a);

                st.clear();
            }
        }

        return al;
    }
}
