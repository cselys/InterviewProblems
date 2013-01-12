package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class RotateList {

	// Not a good solution but ACed
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
        	return null;
        ListNode last = head.next;
        if (last == null || n < 1)
        	return head;
        
        int count = 2;
        while (last.next != null) {
        	last = last.next;
        	count++;
        }
        
        n = count - (n % count);
        while (n-- > 0) {
        	last.next = head;
        	head = head.next;
        	last = last.next;
        	last.next = null;
        }
        
        return head;
    }
    
	public static void main(String[] args) {
		RotateList r = new RotateList();
		int[] arr = {1, 2};
		ListNode head = ListNode.constructFromArray(arr);
		ListNode newHead = r.rotateRight(head, 1);
		ListNode.printList(newHead);
	}

}
