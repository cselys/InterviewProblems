package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class PartitionList {
	
    public ListNode partition(ListNode head, int x) {
    	if (head == null || head.next == null)
    		return head;
    	ListNode dummyHead = new ListNode(0);
    	dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;
        ListNode smaller = dummyHead;
        while (cur != null) {
        	if (cur.val < x && pre != smaller) {
        		pre.next = cur.next;
        		cur.next = smaller.next;
        		smaller.next = cur;
        		smaller = cur;
        		cur = pre.next;
        	} else if (cur.val < x) {
        		smaller = smaller.next;
        		pre = cur;
        		cur = cur.next;
        	} else {
        		pre = cur;
        		cur = cur.next;
        	}
        }
        
        return dummyHead.next;
    }
    
	public static void main(String[] args) {
		PartitionList p = new PartitionList();
		
		int[] arr = {1, 4, 3, 2, 5, 2};
		ListNode head = ListNode.constructFromArray(arr);
		ListNode newHead = p.partition(head, 3);
		ListNode.printList(newHead);
	}
}
