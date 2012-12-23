package fantasist.InterviewProblems.leetcode.utils;

public class ListNode {
	 public int val;
	 public ListNode next;
	 public ListNode(int x) {
	     val = x;
	     next = null;
	 }
	 
	 public static void printList(ListNode head) {
		 if (head == null) {
			 System.out.println("Empty list");
			 return;
		 }
		 ListNode cur = head;
		 while (cur != null) {
			 System.out.print(cur.val + "->");
			 cur = cur.next;
		 }
		 System.out.println("null");
	 }
}
