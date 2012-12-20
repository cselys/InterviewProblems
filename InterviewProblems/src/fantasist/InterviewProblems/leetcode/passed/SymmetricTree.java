package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.definitions.TreeNode;

public class SymmetricTree {

	private boolean isSymmetricallyEqual(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;
		else if (a == null || b == null)
			return false;
		
		if (a.val != b.val)
			return false;
		else
			return isSymmetricallyEqual(a.left, b.right)
					&& isSymmetricallyEqual(a.right, b.left);
	}
	
    public boolean isSymmetric(TreeNode root) {
    	if (root == null)
    		return true;
    	return isSymmetricallyEqual(root.left, root.right);
    }
    
	public static void main(String[] args) {
	}

}
