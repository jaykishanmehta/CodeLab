package com.code.practice.sample.problem.number1;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 * @author jaykishanm
 */
public class MergeList {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.mergeKLists(generateInput());
	}

	private static ListNode[] generateInput() {
		ListNode[] listNodes = new ListNode[3];
		
		ListNode listNode11 = new ListNode(1);
		ListNode listNode12 = new ListNode(4);
		ListNode listNode13 = new ListNode(5);
		listNode11.next = listNode12;
		listNode12.next = listNode13;
		
		ListNode listNode21 = new ListNode(6);
		ListNode listNode22 = new ListNode(7);
		ListNode listNode23 = new ListNode(8);
		listNode21.next = listNode22;
		listNode22.next = listNode23;
		
		ListNode listNode3 = new ListNode(2);
		listNode3.next = new ListNode(6);
		
		listNodes[0] = listNode11;
		listNodes[1] = listNode21;
		listNodes[2] = listNode3;
		
		return listNodes;
	}

}
