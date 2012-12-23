package fantasist.InterviewProblems.other;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class LongestPaththInBinaryTree {

	class TreeNodeStatus {
		int maxLength;
		int maxDepth;
	}
	
	private TreeNodeStatus getTreeNodeStatus(TreeNode node) {
		TreeNodeStatus status = new TreeNodeStatus();
		if (node == null) {
			status.maxLength = 0;
			status.maxDepth = 0;
		} else if (node.left == null && node.right == null) {
			status.maxLength = 1;
			status.maxDepth = 1;
		} else {
			TreeNodeStatus leftStatus = getTreeNodeStatus(node.left);
			TreeNodeStatus rightStatus = getTreeNodeStatus(node.right);
			status.maxDepth = Math.max(leftStatus.maxDepth + 1, rightStatus.maxDepth + 1);
			status.maxLength = Math.max(leftStatus.maxLength, rightStatus.maxLength);
			status.maxLength = Math.max(status.maxLength, leftStatus.maxDepth + rightStatus.maxDepth + 1); 
		}
		
		return status;
	}
	
	public int longestPath(TreeNode root) {
		TreeNodeStatus status = getTreeNodeStatus(root);
		
		return status.maxLength;
	}
	
	public static void main(String[] args) {
		String[] treeArray = {"1", "2", "#", "3", "4", "#", "5", "6", "#"};
		TreeNode root = TreeNode.constructFromArray(treeArray);
		LongestPaththInBinaryTree l = new LongestPaththInBinaryTree();
		System.out.println(l.longestPath(root));
	}

}
