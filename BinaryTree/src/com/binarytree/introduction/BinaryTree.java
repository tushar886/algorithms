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
	
	/**
	 * This method recursively computes the height of binary tree.
	 * @param node
	 * @return integer
	 */
	public static int getHeightOfBinaryTree(final BinaryTreeNode node) {
		
		if (node == null) {
			return 0;
		}
		
		int leftHeight = getHeightOfBinaryTree(node.getLeftChild());
		int rightHeight = getHeightOfBinaryTree(node.getRightChild());
		
		if (leftHeight > rightHeight) 
           return leftHeight + 1;
        else
        	return rightHeight + 1;
	}
}