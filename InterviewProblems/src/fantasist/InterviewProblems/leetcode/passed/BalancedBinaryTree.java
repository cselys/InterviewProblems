package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class BalancedBinaryTree {

	private int validateBalance(TreeNode node) {
		if (node == null)
			return 0;
		int left = validateBalance(node.left);
		int right = validateBalance(node.right);
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}
	
    public boolean isBalanced(TreeNode root) {
        int ret = validateBalance(root);
        if (ret == -1)
        	return false;
        else
        	return true;
    }
    
	public static void main(String[] args) {
		
	}

}
