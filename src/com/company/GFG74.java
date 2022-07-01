// { Driver Code Starts
import java.util.*;
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

class GfG {
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}




// } Driver Code Ends


/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
   QueueNode front, rear;
   
   //Function to push an element into the queue.
void push(int a)
{
       // Your code here
      QueueNode temp=new QueueNode(a);
      if(front==null){
      front=temp;
      rear=temp;
      }
      else{
      rear.next=temp;
      rear=rear.next;
      }
}

   //Function to pop front element from the queue.
int pop()
{
       // Your code here
       if(front==null || rear.next==front ) 
       return -1;
       int a=front.data;
       front=front.next;
       return a;
}
}
