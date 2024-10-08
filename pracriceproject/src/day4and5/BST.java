package day4and5;

import java.util.Scanner;

public class BST {
	private Node root; // this holds reference value of the root node. Thus it points to the BST

	public void addNode() {
		Node newNode = new Node();
		
		if(root == null) { // if tree is empty, then the new-node becomes root of the root
			root = newNode;
			return;
		}
		// if the tree is not empty, then we must traverse the tree in the proper path and attach the new node as leaf node.
		Node temp1 = root;
		Node temp2 = null;
		while(temp1 != null) {
			temp2 = temp1;
			if(newNode.getData() < temp1.getData())
				temp1 = temp1.getLeft();
			else
				temp1 = temp1.getRight();
		}
		if(newNode.getData() < temp2.getData())
			temp2.setLeft(newNode);
		else
			temp2.setRight(newNode);
	}
	
	public void addNodeRecursively(Node root, Node newNode) {
		if(root == null) {
			root = newNode;
			return;
		}
		if(newNode.getData() < root.getData())
			addNodeRecursively(root.getLeft(), newNode);
		else
			addNodeRecursively(root.getRight(), newNode);
	}

	public void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.getData() + "  ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void inOrder(Node root) {
		if(root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + "  ");
			inOrder(root.getRight());
		}
	}

	public void postOrder(Node root) {
		if(root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData() + "  ");
		}
	}
	
	public int searchNode(Node root, int key, int count) {
		if(root == null) {
			return count;
		}
		if(root.getData() == key) {
			return count+1;
		}
		else if(key < root.getData())
			return searchNode(root.getLeft(), key, count+1);
		else
			return searchNode(root.getRight(), key, count+1);
	}
	
	public boolean deleteNode(Node root, int data) {
		boolean result = false;
		if(root == null) { 
			return result;
		}
		Node temp1 = root;
		Node temp2 = null;
		while(temp1 != null && temp1.getData() != data) {
			temp2 = temp1;
			if(data < temp1.getData())
				temp1 = temp1.getLeft();
			else
				temp1 = temp1.getRight();
		}
		if(temp1.getLeft() == null && temp1.getRight() == null) { // if leaf node is reached
			if(temp1.getData() == data) { // leaf node is to be deleted
				if(temp2.getLeft() == temp1)
					temp2.setLeft(null);
				else
					temp2.setRight(null);
				result = true;
			}
		}
		if( (temp1.getLeft() != null && temp1.getRight() == null) || (temp1.getRight() != null && temp1.getLeft() == null) ) {
			if(temp1.getData() == data) {
				if
			}
		}
		
	}

	public static void main(String[] args) {
		int choice = 0;
		BST bst = new BST();
		Scanner scanner = Node.getScanner();
		do {
			System.out.print("\n1:Add 2:Inorder 3:PreOrder 4:PostOrder 5:Search 6:Exit \t Your choice? ");
			choice = scanner.nextInt();
			switch(choice) {
			case 1 : bst.addNode(); break;
			case 2 : bst.inOrder(bst.root); break;
			case 3 : bst.preOrder(bst.root); break;
			case 4 : bst.postOrder(bst.root); break;
			case 5 : System.out.print("Enter the number to be searched: ");
			         int searchKey = scanner.nextInt();
				     int count = bst.searchNode(bst.root, searchKey, 0); 
				     System.out.println("Number of searches = " + count);
				     break;
			case 6 : System.out.print("Enter data of the node to be deleted: ");
					 int data = scanner.nextInt();
		     	     data = bst.deleteNode(bst.root, data); 
		     	     if(data != -1)
		     	    	 System.out.println("Node with data = " + data + " is deleted");
		     	     else
		     	    	System.out.println("Node with data = " + data + " not found");
		     	     break;
			case 7 : System.out.println("End of Program");
					 choice = 0;
					 break;
			default: System.out.println("Invalid choice enetered");
			}
		}while(choice != 0);
		Node.closeScanner();
	}
}
