package day4and5;

import java.util.Scanner;

public class Node {
	private Node left;
	private int data;
	private Node right;
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	public static Scanner getScanner() {
		return scanner;
	}
	
	public static void closeScanner() {
		scanner.close();
	}
	
	public Node() {
		super();
		System.out.print("Enter data of the new Node: ");
		data = scanner.nextInt();
	}

	public Node(Node left, int data, Node right) {
		super();
		this.left = left;
		this.data = data;
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [left=" + left + ", data=" + data + ", right=" + right + "]";
	}
}
