//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head){
        // add your code here
        Node temp = head;
        int n0 = 0;
        int n1 = 0;
        int n2 = 0;
        
        while(temp!=null){
            
            if(temp.data==0){
                n0++;
            }
            else if(temp.data==1){
                n1++;
            }
            else{
                n2++;
            }
            
            temp = temp.next;
        }
        
        temp = head;
        
        while(temp != null){
            
            if(n0 > 0){
                temp.data = 0;
                n0--;
            }
            else if(n1 > 0){
                temp.data = 1;
                n1--;
            }
            else{
                temp.data = 2;
                n2--;
            }
            
            temp = temp.next;
        }
        
        return head;
        
    }
}

