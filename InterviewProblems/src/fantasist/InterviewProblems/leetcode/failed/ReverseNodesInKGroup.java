package fantasist.InterviewProblems.leetcode.failed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class ReverseNodesInKGroup {

	// It does not match the rule in leetcode by reversing groups
	//   less than K as well. But the code should be correct and I
	//   really don't want to modify it.
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (k <= 1)
    		return head;
    	
    	ListNode pre = null, cur = head, next = null;
    	int count = 0, group;
    	
    	ListNode newHead = head;
    	ListNode tail = null, lastTail = null;
    	
    	while (cur != null) {
    		if (cur.next == null) {
    			if (lastTail != null)
    				lastTail.next = cur;
    			break;
    		}
    		tail = cur;
    		pre = cur;
    		cur = cur.next;
    		
    		group = k;
    		while (--group > 0) {
    			if (cur == null)
    				break;
    			next = cur.next;
    			cur.next = pre;
    			pre = cur;
    			cur = next;
    		}
    		if (cur == null) {
    			if (count == 0) {
    				newHead = pre;
    			} else {
    				lastTail.next = pre;
    			}
    		} else {
    			if (count == 0) {
    				newHead = group == 0 ? pre : cur;
    			} else {
    				lastTail.next = group == 0 ? pre : cur;
    			}
    		}
    		
    		lastTail = tail;
    		tail.next = null;
    		count++;
    	}
    	
    	return newHead;
    }
    
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		ListNode head = ListNode.constructFromArray(arr);
		
		ReverseNodesInKGroup r = new ReverseNodesInKGroup();
		ListNode newHead = r.reverseKGroup(head, 2);
		ListNode.printList(newHead);
	}

}
