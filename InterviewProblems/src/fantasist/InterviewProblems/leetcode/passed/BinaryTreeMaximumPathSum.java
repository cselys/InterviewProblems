package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class BinaryTreeMaximumPathSum {
	
	class TreeNodeStatus {
		int maxInclude;
		int maxExclude;
		int maxStop;
	}
	
	private TreeNodeStatus getTreeNodeStatus(TreeNode node) {
		TreeNodeStatus status = new TreeNodeStatus();
		if (node == null) {
			status.maxInclude = Integer.MIN_VALUE;
			status.maxExclude = Integer.MIN_VALUE;
			status.maxStop = Integer.MIN_VALUE;
		} else if (node.left == null && node.right == null) {
			status.maxInclude = node.val;
			status.maxExclude = Integer.MIN_VALUE;
			status.maxStop = node.val;
		} else {
			TreeNodeStatus leftStatus = getTreeNodeStatus(node.left);
			TreeNodeStatus rightStatus = getTreeNodeStatus(node.right);
			status.maxExclude = Math.max(leftStatus.maxExclude, leftStatus.maxInclude);
			status.maxExclude = Math.max(status.maxExclude, leftStatus.maxStop);
			status.maxExclude = Math.max(status.maxExclude, rightStatus.maxExclude);
			status.maxExclude = Math.max(status.maxExclude, rightStatus.maxInclude);
			status.maxExclude = Math.max(status.maxExclude, rightStatus.maxStop);
			
			status.maxStop = node.val;
			if (node.left != null)
				status.maxStop = Math.max(status.maxStop, leftStatus.maxStop + node.val);
			if (node.right != null)
				status.maxStop = Math.max(status.maxStop, rightStatus.maxStop + node.val);
			
			status.maxInclude = Math.max(status.maxStop,
					(node.left == null ? 0 : leftStatus.maxStop) + (node.right == null ? 0 : rightStatus.maxStop) + node.val);
		}
		
		return status;
	}
    public int maxPathSum(TreeNode root) {
		TreeNodeStatus status = getTreeNodeStatus(root);
		
		int max = Math.max(status.maxExclude, status.maxStop);
		max = Math.max(max, status.maxInclude);
		return max;
    }
    
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		String[] nodes = {"-2", "#", "-3"};
		TreeNode root = TreeNode.constructFromArray(nodes);
		System.out.println(b.maxPathSum(root));
	}

}
