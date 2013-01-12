package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

	private TreeNode convertHelper(int[] num, int start, int end) {
		if (start > end)
			return null;
		
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = convertHelper(num, start, mid - 1);
		node.right = convertHelper(num, mid + 1, end);
		
		return node;
	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
        	return null;
        
        TreeNode head = convertHelper(num, 0, num.length-1);
        
        return head;
    }
    
	public static void main(String[] args) {

	}

}
