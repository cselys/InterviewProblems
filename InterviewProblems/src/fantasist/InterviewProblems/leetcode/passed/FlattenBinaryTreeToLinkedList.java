package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	private TreeNode flatten_helper(TreeNode node) {
		if (node.left != null) {
			TreeNode right = node.right;
			node.right = node.left;
			node.left = null;
			TreeNode lastOfLeft = flatten_helper(node.right);
			if (right != null) {
				lastOfLeft.right = right;
				return flatten_helper(right);
			}
			return lastOfLeft;
		} else if (node.right != null) {
			return flatten_helper(node.right);
		} else {
			return node;
		}
	}
	
    public void flatten(TreeNode root) {
    	if (root == null)
    		return;
        flatten_helper(root);
    }
    
	public static void main(String[] args) {
//		String[] nodes = {"1", "2", "#", "3"};
		String[] nodes = {"3", "1", "4", "#", "2"};
		TreeNode root = TreeNode.constructFromArray(nodes);
		FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
		f.flatten(root);
		TreeNode.printTreeLevelOrder(root);
	}

}
