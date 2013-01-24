package fantasist.InterviewProblems.other;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class FindLowestAncestor {

	class Status {
		TreeNode commonAncestor;
		boolean hasNode1;
		boolean hasNode2;
		public Status() {
			commonAncestor = null;
			hasNode1 = false;
			hasNode2 = false;
		}
	}
	
	private Status findLowestAncestor_helper(TreeNode node, TreeNode node1, TreeNode node2) {
		if (node == null)
			return null;
		Status left = findLowestAncestor_helper(node.left, node1, node2);
		Status right = findLowestAncestor_helper(node.right, node1, node2);
		if (left != null && left.commonAncestor != null)
			return left;
		if (right != null && right.commonAncestor != null)
			return right;
		
		Status current = new Status();
		if ((left != null && left.hasNode1) || (right != null && right.hasNode1))
			current.hasNode1 = true;
		if ((left != null && left.hasNode2) || (right != null && right.hasNode2))
			current.hasNode2 = true;
		if (node.val == node1.val)
			current.hasNode1 = true;
		if (node.val == node2.val)
			current.hasNode2 =true;
		if (current.hasNode1 && current.hasNode2)
			current.commonAncestor = node;
		
		return current;
	}
	
	public TreeNode findLowestAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null)
			return null;
		
		Status s = findLowestAncestor_helper(root, node1, node2);
		return s.commonAncestor;
	}
	
	public static void main(String[] args) {
		FindLowestAncestor f = new FindLowestAncestor();
		String[] treeStr = {"1", "2", "5", "8", "3", "#", "4"};
		TreeNode root = TreeNode.constructFromArray(treeStr);
		TreeNode common = f.findLowestAncestor(root, new TreeNode(3), new TreeNode(4));
		if (common != null)
			System.out.println(common.val);
	}

}
