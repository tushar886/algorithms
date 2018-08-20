package com.binarytree.introduction;

public class BinaryTreeNode {
	
	private int key;
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;
	
	public BinaryTreeNode(int key) {
		super();
		this.key = key;
		//assign the left and right childs as null as they will be assigned later through their setters.
		this.leftChild = null;
		this.rightChild = null;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(final int key) {
		this.key = key;
	}

	/**
	 * @return the leftChild
	 */
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(final BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(final BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	@Override
	public String toString() {
		return new Integer(this.key).toString();
	}
}
