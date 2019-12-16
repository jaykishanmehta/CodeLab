package com.code.practice.tree.problem.core;

public class TreeNode {

	private int data;
	private TreeNode leftNode;
	private TreeNode rightNode;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public void insert(int data) {
		if(data == this.data) {
			return;
		}
		
		if(data < this.data) {
			if(leftNode != null) {
				leftNode.insert(data);
			} else {
				leftNode = new TreeNode(data);
			}
		} else {
			if(rightNode != null) {
				rightNode.insert(data);
			} else {
				rightNode = new TreeNode(data);
			}
		}
	}
	
	public void traverseInOrder() {
		if(leftNode != null) {
			leftNode.traverseInOrder();
		}
		System.out.print(" >> " + data);
		if(rightNode != null) {
			rightNode.traverseInOrder();
		}
	}
	
	public TreeNode get(int value) {
		if(this.data == value) {
			return this;
		}
		if(value < this.data) {
			if(leftNode != null) {
				return leftNode.get(value);
			}
		} else {
			if(rightNode != null) {
				return rightNode.get(value);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data 
				+ ", leftNode=" + (leftNode != null ? leftNode.getData()+"" : "*") 
				+ ", rightNode=" + (rightNode != null ? rightNode.getData()+"" : "*") + "]";
	}

	public int min() {
		
		if(leftNode != null)
			return leftNode.min();
		else
			return data;
	}
	
	public int max() {
		
		if(rightNode == null)
			return data;
		else
			return rightNode.max();
	}

	public void traversePreOrder() {
		
		System.out.print(" >> "+ data);
		if(leftNode != null) {
			leftNode.traversePreOrder();
		}
		if(rightNode != null) {
			rightNode.traversePreOrder();
		}
		
	}

	public void traversePostOrder() {
		if(leftNode != null) {
			leftNode.traversePostOrder();
		}
		if(rightNode != null) {
			rightNode.traversePostOrder();
		}
		System.out.print(" >> "+ data);
	}

	public int nodeHeight(int value) {
		
		if(value == this.getData()) {
			return 0;
		}
		
		if(value > this.getData() && this.getRightNode() != null) {
			return this.getRightNode().nodeHeight(value) + 1;
		} else if (value < this.getData() && this.getLeftNode() != null) {
			return this.getLeftNode().nodeHeight(value) + 1;
		}
		
		return -1;
	}

	public int getHeight() {
		
		if(this.getLeftNode() == null && this.getRightNode() == null)
			return 0;
		else if(this.getLeftNode() == null)
			return this.getRightNode().getHeight() + 1;
		else if(this.getRightNode() == null)
			return this.getLeftNode().getHeight() + 1;
		else
			return Integer.max(this.getLeftNode().getHeight(), this.getRightNode().getHeight()) + 1;
		
	}
	
}
