package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.ListNode;
import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	
	private TreeNode convertHelper(ListNode start, ListNode end) {
		if (start == null || start == end)
			return null;
		if (start.next == null)
			return new TreeNode(start.val);
		
		ListNode slow = start, fast = start;
		while (fast != null && fast != end) {
			if (fast.next != null && fast.next != end)
				fast = fast.next.next;
			else
				break;
			slow = slow.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = convertHelper(start, slow);
		node.right = convertHelper(slow.next, end);
		
		return node;
	}
	
    public TreeNode sortedListToBST(ListNode head) {
    	TreeNode root = convertHelper(head, null);
    	
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
