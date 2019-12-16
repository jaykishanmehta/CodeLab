package com.code.practice.tree.problem.core;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private TreeNode root;
	
	public void insert(int data) {
		if(root == null) {
			root = new TreeNode(data);
		} else {
			root.insert(data);
		}		
	}

	public void traverseInOrder() {
		
		System.out.println("\n In-Order Traversal");
		if(root != null) {
			root.traverseInOrder();
		}
	}
	
	public TreeNode get(int value) {
		if(root != null) {
			return root.get(value);
		}
		return null;
	}

	public int findMin() {
		if(root != null) {
			return root.min();
		}
		return Integer.MIN_VALUE;
	}

	public int findMax() {
		if(root != null) {
			return root.max();
		}
		return Integer.MAX_VALUE;
	}

	public void delete(int value) {
		root = delete(root, value);
	}

	private TreeNode delete(TreeNode subtreeRoot, int value) {
		
		if(subtreeRoot == null)
			return null;
		
		if(subtreeRoot.getData() == value) {
			//Node to delete has 0 or 1 children
			if(subtreeRoot.getLeftNode() == null) {
				return subtreeRoot.getRightNode();
			} else if(subtreeRoot.getRightNode() == null) {
				return subtreeRoot.getLeftNode();
			} else {
				//Node to delete which has left & right node available
				subtreeRoot.setData(subtreeRoot.getRightNode().min());
				subtreeRoot.setRightNode(delete(subtreeRoot.getRightNode(), subtreeRoot.getData()));
			}
		} else if(subtreeRoot.getData() > value) {
			subtreeRoot.setLeftNode(delete(subtreeRoot.getLeftNode(), value));
		} else {
			subtreeRoot.setRightNode(delete(subtreeRoot.getRightNode(), value));
		}
		
		return subtreeRoot;
	}

	public void traversePreOrder() {
		System.out.println("\n Pre-Order Traversal");
		if(root != null) {
			root.traversePreOrder();
		}
	}

	public void traversePostOrder() {
		System.out.println("\n Post-Order Traversal");
		if(root != null) {
			root.traversePostOrder();
		}
	}

	public void printTree() {
		System.out.println("\n Tree print");
		if(root != null) {
			List<TreeNode> nodes = new ArrayList<TreeNode>();
			nodes.add(root);
			System.out.println();
			printTree(nodes);
		}
	}

	private void printTree(List<TreeNode> nodes) {
		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		for (TreeNode treeNode : nodes) {
			System.out.print(treeNode.getData() + " ");
			
			if(treeNode.getLeftNode() != null)
				newNodes.add(treeNode.getLeftNode());
			if(treeNode.getRightNode() != null)
				newNodes.add(treeNode.getRightNode());
		}
		System.out.println();
		if(!newNodes.isEmpty())
			printTree(newNodes);
	}

	public int nodeHeight(int value) {
		
		if(root == null)
			return -1;
		if(root.getData() == value)
			return 1;
		return root.nodeHeight(value);
	}

	public int getHeight() {
		
		if(root == null)
			return -1;
		
		return root.getHeight();
	}
	
	@Override
	public String toString() {
		return "Tree [root=" + root + "]";
	}
}
