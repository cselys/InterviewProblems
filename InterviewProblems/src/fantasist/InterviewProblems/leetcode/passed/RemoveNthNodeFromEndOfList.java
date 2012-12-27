package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (n == 0)
    		return head;
    	
        ListNode pioneer = head;
        while(n-- > 0) {
        	pioneer = pioneer.next;
        }
        if (pioneer == null)
        	return head.next;
        ListNode cur = head;
        while (pioneer.next != null) {
        	pioneer = pioneer.next;
        	cur = cur.next;
        }
        cur.next = cur.next.next;
        
        return head;
    }
    
	public static void main(String[] args) {
		
	}

}
