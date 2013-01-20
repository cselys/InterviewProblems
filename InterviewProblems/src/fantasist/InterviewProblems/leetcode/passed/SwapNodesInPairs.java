package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null)
    		return head;
    	
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode pre = dummyHead, cur = head, next = null;
        
        while (cur != null) {
        	next = cur.next;
        	if (next == null)
        		break;
        	cur.next = next.next;
        	pre.next = next;
        	next.next = cur;
        	
        	pre = cur;
        	cur = cur.next;
        }
        
        return dummyHead.next;
    }
    
	public static void main(String[] args) {

	}

}
