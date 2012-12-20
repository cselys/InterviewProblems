package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.definitions.TreeNode;

public class ValidateBST {

	private final long MIN = -9999999999L;
	private final long MAX = 9999999999L;
	private boolean isValidBST(TreeNode node, long min, long max) {
		if (node == null)
			return true;
		
		if ((long)node.val > min && (long)node.val < max) {
			return isValidBST(node.left, min, (long)node.val) &&
					isValidBST(node.right, (long)node.val, max);
		} else {
			return false;
		}
	}
	
    public boolean isValidBST(TreeNode root) {
    	if (root == null)
    		return true;
    	
    	return isValidBST(root.left, MIN, (long)root.val) &&
    			isValidBST(root.right, (long)root.val, MAX);
    }
    
	public static void main(String[] args) {
	
	}

}
