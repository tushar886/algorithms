package com.binarytree.traversals;

import com.binarytree.introduction.BinaryTree;
import com.binarytree.introduction.BinaryTreeNode;
import com.binarytree.util.BinaryTreePrinter;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		//create a basic binary tree 
		final BinaryTreeNode root = BinaryTree.createBinaryTree();

		BinaryTreePrinter.printNode(root);
		
		System.out.println("Exit level order traversal");
	}

}
