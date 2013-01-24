package fantasist.InterviewProblems.other;

import java.util.HashMap;
import java.util.LinkedList;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class CompareTwoWeirdTrees {

	public static boolean compareTrees(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		else if (tree1 == null || tree2 == null)
			return false;
		HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
		LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
		list1.add(tree1);
		list2.add(tree2);
		
		int count = 1;
		while (count > 0) {
			for (int i = 0; i < count; i++) {
				TreeNode n1 = list1.get(0);
				TreeNode n2 = list2.get(0);
				list1.removeFirst();
				list2.removeFirst();
				TreeNode target = map.get(n1);
				if (target == null) {
					map.put(n1, n2);
				} else if (n2 != target) {
					return false;
				}
				if (n1.val != n2.val)
					return false;
				if ((n1.left == null && n2.left != null) || (n1.left != null && n2.left == null)) {
					return false;
				} else if (n1.left != null && n2.left != null) {
					list1.add(n1.left);
					list2.add(n2.left);
				}
				if ((n1.right == null && n2.right != null) || (n1.right != null && n2.right == null)) {
					return false;
				} else if (n1.right != null && n2.right != null) {
					list1.add(n1.right);
					list2.add(n2.right);
				}
			}
			count = list1.size();
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		tree1.left = node2;
		tree1.right = node3;
		
		TreeNode tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		tree2.right = new TreeNode(3);

		System.out.println(CompareTwoWeirdTrees.compareTrees(tree1, tree2));
		
		TreeNode tree3 = new TreeNode(1);
		tree3.left = node2;
		node2.right = node3;
		tree3.right = node3;
		tree2.left.right = new TreeNode(3);
		System.out.println(CompareTwoWeirdTrees.compareTrees(tree3, tree2));
	}
}
