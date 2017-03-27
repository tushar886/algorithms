package com.binarytree.traversals;

import com.binarytree.introduction.BinaryTree;
import com.binarytree.introduction.BinaryTreeNode;
import com.binarytree.util.BinaryTreePrinter;

public class BasicTreeTraversal {

	public static void main(String args[]) {
		
		BinaryTreeNode root = BinaryTree.createBinaryTree();
		
		BinaryTreePrinter.printNode(root);
		
		printInorderTraversalRecusrion(root);
		System.out.println("--------------------------");
		printPreOrderTraversalRecusrion(root);
		System.out.println("--------------------------");
		printPostOrderTraversalRecusrion(root);
	}

	public static void printInorderTraversalRecusrion(final BinaryTreeNode root) {
		
		if (root == null)
			return;

		printInorderTraversalRecusrion(root.getLeftChild());
		System.out.print(root.getKey() + " ");		
		printInorderTraversalRecusrion(root.getRightChild());
	}

	public static void printPreOrderTraversalRecusrion(final BinaryTreeNode root) {
		
		if (root == null)
			return;
		
		System.out.print(root.getKey() + " ");	
		printPostOrderTraversalRecusrion(root.getLeftChild());
		printPostOrderTraversalRecusrion(root.getRightChild());
	}

	public static void printPostOrderTraversalRecusrion(final BinaryTreeNode root) {
		
		if (root == null)
			return;
		
		printPostOrderTraversalRecusrion(root.getLeftChild());
		printPostOrderTraversalRecusrion(root.getRightChild());
		System.out.print(root.getKey() + " ");		
	}
}
