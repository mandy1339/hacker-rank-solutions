import java.util.*;
import java.io.*;

// CLASS NODE
//-	-	-	-	-	-	-	-
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
//-	-	-	-	-	-	-	-



// CLASS SOLUTION
//-	-	-	-	-	-	-	-
public class Solution {
	public static int getHeight(Node root){
      //Write your code here
		//The height of the tree, 
		//height(t) = 1 + (max(height(root.leftChild), height(root.rightChild)))
		
		// If there's no left or right node, return 0
		if(root == null) {
			return 0;
		}
	
		if(root.left == null && root.right == null) {
			return 0;
		}
		
		// Else return 1 and keep recursing
		return (1 + Math.max(getHeight(root.left), getHeight(root.right)));

		//return 0;
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
	
	// Main
	 public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
