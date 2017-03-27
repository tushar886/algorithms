package com.binarytree.introduction;

import com.binarytree.util.BinaryTreePrinter;

public class BinaryTree {

	private static BinaryTreeNode root;

	public static void main(String[] args) {

		root = createBinaryTree();

		BinaryTreePrinter.printNode(root);
	}

	public static BinaryTreeNode createBinaryTree() {

		/*create root*/
		final BinaryTreeNode rootNode = new BinaryTreeNode(1);

		/* following is the tree after above statement

	              1
	            /   \
	          null  null     */

		rootNode.setLeftChild(new BinaryTreeNode(2));
		rootNode.setRightChild(new BinaryTreeNode(3));

		/* 2 and 3 become left and right children of 1
	               1
	             /   \
	            2      3
	          /    \    /  \
	        null null null null  */


		rootNode.getLeftChild().setLeftChild(new BinaryTreeNode(4));
		/* 4 becomes left child of 2
	                    1
	                /       \
	               2          3
	             /   \       /  \
	            4    null  null  null
	           /   \
	          null null
		 */

		rootNode.getLeftChild().setRightChild(new BinaryTreeNode(5));
		/* 5 becomes left child of 2
	                    1
	                /       \
	               2          3
	             /   \       /  \
	            4     5  null  null
	           /   \
	          null null
		 */

		rootNode.getRightChild().setLeftChild(new BinaryTreeNode(6));
		/* 6 becomes left child of 3
	                    1
	                /       \
	               2          3
	             /   \       /  \
	            4     5     6  null
	           /   \
	          null null
		 */

		rootNode.getRightChild().setRightChild(new BinaryTreeNode(7));
		/* 7 becomes right child of 3
	                    1
	                /       \
	               2          3
	             /   \       /  \
	            4     5     6    7
	           /   \
	          null null
		 */
		
		return rootNode;
	}
}