package com.code.practice.tree.problem.core;

/**
 * KNOWLEDGE :: Tree implementation and many different tree functionality 
 * 
 * @author jaykishan.mehta
 */
public class TreeRunner {

	public static void main(String[] args) {

		Tree intTree = new Tree();
		intTree.insert(25);
		intTree.insert(20);
		intTree.insert(15);
		intTree.insert(27);
		intTree.insert(30);
		intTree.insert(29);
		intTree.insert(26);
		intTree.insert(22);
		intTree.insert(32);
		intTree.insert(17);
		//intTree.insert(31);		//Un-Comment this and height should be 4
		
		System.out.println("********** Tree Info ********");
		System.out.println("Root Node:: " + intTree);
		
		/** Traversal **/
		intTree.traverseInOrder();
		intTree.traversePreOrder();
		intTree.traversePostOrder();
		
		System.out.println("\n Tree Height == Height of Root :: " + intTree.getHeight());
		
		/** Min/Max **/
		System.out.println(" Find Min: " + intTree.findMin());
		System.out.println(" Find Max: " + intTree.findMax());
		
		System.out.println(" Find 27: " + intTree.get(27));
		System.out.println(" Find 17: " + intTree.get(17));
		
		System.out.println("\n Root Node height :: 25 -> " + intTree.nodeHeight(25));
		System.out.println("\n Node height :: 29 -> " + intTree.nodeHeight(29));

		
		System.out.println(" Deletion of node ");
		intTree.traverseInOrder();
		System.out.println("\n Delete -> 17 ");
		intTree.delete(17);
		intTree.traverseInOrder();
		System.out.println("\n Delete Root -> 25 ");
		intTree.delete(25);
		intTree.traverseInOrder();
		System.out.println("\n Delete -> 27 ");
		intTree.delete(27);
		intTree.traverseInOrder();
		
		//intTree.printTree();
		
	}

}
