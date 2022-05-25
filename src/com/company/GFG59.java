package com.company;
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

}
class GFG59{
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){

            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            Solution59 ob = new Solution59();
            head = ob.reverseList(head);
            printList(head);
            t--;
        }
    }
}

class Solution59
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        if(head== null || head.next==null) return head;
        Node newHead=reverseList(head.next);
        Node headNext=head.next;
        headNext.next=head;
        head.next=null;
        return newHead;
    }
}
