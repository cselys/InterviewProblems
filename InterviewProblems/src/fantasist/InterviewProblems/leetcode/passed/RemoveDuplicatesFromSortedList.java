package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null)
    		return null;
    	
    	ListNode newHead = null, cur = null;
    	int pre = 0;
    	while (head != null) {
    		if (newHead == null) {
    			newHead = head;
    			pre = head.val;
    			cur = newHead;
    		} else if (head.val != pre) {
				cur.next = head;
				cur = cur.next;
				pre = head.val;
    		}
			head = head.next;
    	}
    	if (cur != null)
    		cur.next = null;
    	
    	return newHead;
    }
    
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		
		ListNode newHead = r.deleteDuplicates(head);
		if (newHead != null) {
			ListNode cur = newHead;
			while (cur != null) {
				System.out.print(cur.val + "->");
				cur = cur.next;
			}
			System.out.println("null");
		}
	}

}
