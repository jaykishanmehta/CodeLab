package com.code.practice.sample.problem.number1;

public class Solution {

	public ListNode mergeKLists(ListNode[] lists) {
		
		
		if (lists == null || lists.length == 0)
			return null;
		
		ListNode merged = lists[0];
		for (int i = 1; i < lists.length; i++) {
			merged = mergeTwoList(merged, lists[i]);
			printListNode(merged);
		}
		printListNode(merged);		
		//mergeTwoList(lists[1], lists[2]);
		
		return new ListNode(-1);
	}
	
	private ListNode mergeTwoList(ListNode point, ListNode point2) {
		
		
		ListNode tempNode = null;
		ListNode finalNode = null;
		ListNode listNode = point; 
		ListNode listNode2 = point2;
		
		//System.out.println();
		if(point2 == null && point == null)
            return null;
        if(point2 == null)
            return point;
        if(point == null)
            return point2;
        if(!hasNext(listNode2) && !hasNext(listNode)) {
			if(listNode.val <= listNode2.val) {
				listNode.next = listNode2;
				return listNode;
			} else {
				listNode2.next = listNode;
				return listNode2;
			}
		}
        
		
		if(listNode.val <= listNode2.val) {
			finalNode = new ListNode(listNode.val);
			listNode = listNode.next;
		} else {
			finalNode = new ListNode(listNode2.val);
			listNode = listNode2.next;
		}
			
		ListNode lastNode = finalNode;
		while(hasNext(listNode) && hasNext(listNode2)) {
			
			if(listNode.val <= listNode2.val) {
				tempNode = new ListNode(listNode.val);
				listNode = listNode.next;
				lastNode.next = tempNode;
			} else {
				tempNode = new ListNode(listNode2.val);
				listNode2 = listNode2.next;
				lastNode.next = tempNode;
			}
			lastNode = tempNode;
		}
		
		
		if(!hasNext(listNode2) && !hasNext(listNode)) {
			if(listNode.val <= listNode2.val) {
				tempNode = new ListNode(listNode.val);
				lastNode.next = tempNode;
				lastNode = tempNode;
				tempNode = new ListNode(listNode2.val);
				lastNode.next = tempNode;
			} else {
				tempNode = new ListNode(listNode2.val);
				lastNode.next = tempNode;
				lastNode = tempNode;
				tempNode = new ListNode(listNode.val);
				lastNode.next = tempNode;
			}
		} else if(!hasNext(listNode2)) {
			
			tempNode = new ListNode(listNode2.val);
			lastNode.next = tempNode;
			lastNode = tempNode;
			lastNode.next = listNode;
		} else if(!hasNext(listNode)) {
			
			tempNode = new ListNode(listNode.val);
			lastNode.next = tempNode;
			lastNode = tempNode;
			lastNode.next = listNode2;
		}
		
		//System.out.println();
		//printListNode(finalNode);
		//System.out.println();
		
		return finalNode;
	}

	private static String seperator = "->";
	public void printListNode(ListNode node) {
		ListNode point = node;
		StringBuilder str = new StringBuilder();
		System.out.println();
		
		if(point != null) {
			System.out.print(point.val + "->");
			str.append(point.val);
			str.append(seperator);
			while(hasNext(point)) {
				point = point.next;
				str.append(point.val);
				str.append(seperator);
			}			
		}
		
		System.out.println(str.substring(0,str.lastIndexOf(seperator)));
	}
	
	boolean hasNext(ListNode node) {
		if(node!=null && node.next != null)
			return true;
		return false;
	}
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        for(ListNode list : lists) {
            node = merge(node,list);
        }
        return node;
    }
   
    public ListNode merge(ListNode node1, ListNode node2) {
        if(node1 == null && node2 == null)
            return null;
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;
        if(node1.val <= node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else if(node2.val < node1.val) {
            node2.next = merge(node1, node2.next);
            return node2;
        }
        return null;
    }
}*/ 
 
