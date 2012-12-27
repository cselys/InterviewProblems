package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null)
    		return null;
        ListNode newHead = null, cur = null;
        Integer pre = null;
        int count = 0;
        while (head != null) {
        	if (pre == null) {
        		pre = head.val;
        		count++;
        	} else {
        		if (pre != head.val) {
        			if (count == 1) {
	        			if (newHead == null) {
	        				newHead = new ListNode(pre);
	        				cur = newHead;
	        			} else {
	        				cur.next = new ListNode(pre);
	        				cur = cur.next;
	        			}
        			}
    				count = 1;
    				pre = head.val;
        		} else {
        			count++;
        		}
        	}
        	
        	head = head.next;
        }
        
        if (count == 1) {
        	if (newHead == null)
        		return new ListNode(pre);
        	else {
        		cur.next = new ListNode(pre);
        		cur = cur.next;
        	}
        }
        
        return newHead;
    }
    
	public static void main(String[] args) {
		
	}

}
