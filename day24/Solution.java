import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution
{
    public static Node removeDuplicates(Node head) {
        //Write your code here
	if(head == null){
	    return null;
	}
        Node traverser = head;
        while(traverser != null && traverser.next != null) {    // While not reached end of list
            if(traverser.data == traverser.next.data) {         // If current node = next node
                Node secondNode = traverser.next;           
                if(secondNode.next != null) {                       // If next node is not the tail
                    traverser.next = secondNode.next;               // Connect current node to the next next
                }
                else {                                              // If it was the tail
                    traverser.next = null;                          // Just remove the tail
                }
            }
	    if(traverser.next != null && traverser.data != traverser.next.data) { // If the new next is also repeated, dont advance the traverser
                traverser = traverser.next;
	    }
        }
        return head;
    }
	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }

