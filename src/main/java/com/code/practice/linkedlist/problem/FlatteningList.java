package com.code.practice.linkedlist.problem;

class ListNode{
	int val;
	ListNode next;
	ListNode down;
	
	ListNode(int val){
		this.val=val;
	}
}


public class FlatteningList {
	public static void main(String args[]) {
		ListNode head=new ListNode(4);
		head.down=new ListNode(5);
		head.down.down=new ListNode(8);
		head.down.down.down=new ListNode(10);

		head.next=new ListNode(5);
		head.next.down=new ListNode(7);
		head.next.down.down=new ListNode(15);
		head.next.down.down.down=new ListNode(18);
		head.next.down.down.down.down=new ListNode(25);
		
		head.next.next=new ListNode(6);
		head.next.next.down=new ListNode(17);
		head.next.next.down.down=new ListNode(25);
		head.next.next.down.down.down=new ListNode(31);

//		head.next.next.next=new ListNode(7);
//		head.next.next.next.down=new ListNode(8);
//		head.next.next.next.down.down=new ListNode(9);
//		head.next.next.next.down.down.down=new ListNode(19);
		
		printList(head);
		System.out.println("Flattening");
		head = flattenMyList(head);
		printList(head);
		
	}

	private static ListNode flattenMyList(ListNode head) {
		
		if(head.next == null)
			return head;
		
		return head;
	}

	private static ListNode flattenList(ListNode head) {
		while(head.next!=null) {
			ListNode newHead = new ListNode(head.val);
			ListNode tmpNode = newHead;
			ListNode lst1=head.down;
			ListNode lst2=head.next;
			while(lst1!=null && lst2!=null) {
				if(lst1.val>lst2.val)
				{
					tmpNode.down=new ListNode(lst2.val);
					lst2=lst2.down;
				}else {
					tmpNode.down=new ListNode(lst1.val);
					lst1=lst1.down;
				}
				tmpNode=tmpNode.down;					
			}
			if(lst1==null)
				lst1=lst2;
			
			while(lst1!=null) {
				tmpNode.down=new ListNode(lst1.val);
				tmpNode=tmpNode.down;
				lst1=lst1.down;
			}
			newHead.next = head.next.next;
			head=newHead;
		}
		return head;
	}

	private static void printList(ListNode head) {
		while(head!=null) {
			ListNode tmp=head;
			while(tmp!=null) {
				System.out.print(tmp.val+"->");
				tmp=tmp.down;
			}
			System.out.println();
			head=head.next;
		}
	}
}
