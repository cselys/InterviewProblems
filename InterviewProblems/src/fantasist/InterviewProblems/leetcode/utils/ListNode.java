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
	 
	 public static ListNode constructFromArray(int[] arr) {
		 if (arr == null || arr.length == 0)
			 return null;
		 
		 ListNode head = new ListNode(arr[0]);
		 ListNode cur = head;
		 for (int i = 1; i < arr.length; i++) {
			 cur.next = new ListNode(arr[i]);
			 cur = cur.next;
		 }
		 
		 return head;
	 }
}
