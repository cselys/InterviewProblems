package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class ReverseLinkedListII {

	private ListNode reverse(ListNode head, int n) {
		ListNode tempHead = head;
		ListNode pre = null, cur = head, next = null;
		while (n-- > 0) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		tempHead.next = next;
		
		return pre;
	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (n < 1 || m > n)
    		return null;
    	if (n == m)
    		return head;
    	ListNode pre = head;
    	if (m > 1) {
    		int skip = m-2;
	    	while (skip-- > 0)
	    		pre = pre.next;
	    	
	    	pre.next = reverse(pre.next, n-m+1);
	    	return head;
    	} else {
    		return reverse(head, n);
    	}
    }
    
	public static void main(String[] args) {
		ReverseLinkedListII r = new ReverseLinkedListII();
		
		int[] arr = {1, 2, 3, 4, 5, 6};
		ListNode head = ListNode.constructFromArray(arr);
		ListNode.printList(head);
		
		ListNode.printList(r.reverseBetween(head, 2, 2));
	}

}
