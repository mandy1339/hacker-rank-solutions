import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution {
	// Instance data

	// IN-ORDER()
	//------------------------------
    static void inOrder(Node root){
        //Write your code here
    	if(root == null)
			return;
		levelOrder(root.left);
		System.out.println(root.data);
		levelOrder(root.right); 
    }


	// LEVEL-ORDER()
	// Takes a node and prints the tree under it in level order
	//------------------------------	
	static void levelOrder(Node root) {
		LinkedList <Node> cloud = new LinkedList <Node>();
		if(root == null) 
			return;
		else									// add root to the cloud
			cloud.add(root);

		// Algorithm here
		while(cloud.size() > 0) {
			Node tempNode = cloud.poll();		// dequeue into a temp node
			System.out.print(tempNode.data + " ");	// print its number
			if(tempNode.left != null)					// if it has a left child enqueue it
				cloud.add(tempNode.left);
			if(tempNode.right != null)					// if it has a right child enqueue it
				cloud.add(tempNode.right);		
		}
	}


public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}
