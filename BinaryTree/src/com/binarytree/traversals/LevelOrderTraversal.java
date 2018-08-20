package com.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;

import com.binarytree.introduction.BinaryTree;
import com.binarytree.introduction.BinaryTreeNode;
import com.binarytree.util.BinaryTreePrinter;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		//create a basic binary tree 
		// returns the root node of binary tree created.
		final BinaryTreeNode root = BinaryTree.createBinaryTree();

		BinaryTreePrinter.printNode(root);
		
		printLevelOrderTraversalRecursive(root);
		System.out.println("Exit level order traversal");
	}

	/**
	 * This method takes in the root node of the binary tree and prints in the level order traversal of that tree.
	 * @param root
	 */
	private static void printLevelOrderTraversal(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> treeQueue = new LinkedList<BinaryTreeNode>();
		treeQueue.add(root);
		
		System.out.println("Start level order traversal-----");
		
		while (!treeQueue.isEmpty()) {
            
			var elem = treeQueue.poll();
			System.out.print(elem + "--");
			if (elem.getLeftChild() != null) {
				treeQueue.add(elem.getLeftChild());			
			}
			if (elem.getRightChild() != null) {
				treeQueue.add(elem.getRightChild());			
			}
		}
	}
	
	private static void printLevelOrderTraversalRecursive(BinaryTreeNode root) {
		
		int height = BinaryTree.getHeightOfBinaryTree(root);
		System.out.println("Height of given tree is: " + height);
		
		for (int i = 1; i <= height ; i++) {
            printGivenHeight(root, i);			
		}
	}

	private static void printGivenHeight(BinaryTreeNode node, int level) {
		
		if (node == null)
            return;
        if (level == 1)
            System.out.print(node + "--");
        else if (level > 1)
        {
        	printGivenHeight(node.getLeftChild(), level-1);
        	printGivenHeight(node.getRightChild(), level-1);
        }
	}
}
