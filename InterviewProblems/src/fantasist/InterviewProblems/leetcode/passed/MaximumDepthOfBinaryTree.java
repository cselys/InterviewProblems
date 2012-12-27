package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null)
        	return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
	public static void main(String[] args) {
	}

}
