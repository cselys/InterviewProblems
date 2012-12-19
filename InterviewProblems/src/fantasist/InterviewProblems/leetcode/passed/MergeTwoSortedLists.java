package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.definitions.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode head = null;
    	ListNode cur = null;
        while (true) {
        	if (l1 == null && l2 == null) {
        		break;
        	} else if (l1 == null) {
        		if (head == null) {
        			head = l2;
        			break;
        		} else {
        			cur.next = l2;
        			break;
        		}
        	} else if (l2 == null) {
        		if (head == null) {
        			head = l1;
        			break;
        		} else {
        			cur.next = l1;
        			break;
        		}
        	} else if (l1.val < l2.val) {
        		if (head == null) {
        			head = new ListNode(l1.val);
        			cur = head;
        			l1 = l1.next;
        		} else {
        			cur.next = new ListNode(l1.val);
        			cur = cur.next;
        			l1 = l1.next;
        		}
        	} else {
        		if (head == null) {
        			head = new ListNode(l2.val);
        			cur = head;
        			l2 = l2.next;
        		} else {
        			cur.next = new ListNode(l2.val);
        			cur = cur.next;
        			l2 = l2.next;
        		}
        	}
        }
    	
    	return head;
    }
    
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode cur = l1;
		for (int i = 2; i <= 5; i++) {
			ListNode newNode = new ListNode(i * 3);
			cur.next = newNode;
			cur = newNode;
		}
		
		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(8);
		
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		ListNode merged = m.mergeTwoLists(l1, l2);
		for (ListNode node = merged; node != null; node = node.next) {
			System.out.print(node.val + "->");
		}
		System.out.println("NULL");
	}

}
