package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (root == null)
    		return res;
    	
    	List<TreeNode> list = new LinkedList<TreeNode>();
    	list.add(root);
    	int num = 1;
    	while(num > 0) {
    		ArrayList<Integer> level = new ArrayList<Integer>(num);
    		int count = 0;
    		while (count++ < num) {
    			TreeNode node = list.get(0);
    			level.add(node.val);
    			if (node.left != null)
    				list.add(node.left);
    			if (node.right != null)
    				list.add(node.right);
    			list.remove(0);
    		}
    		res.add(level);
    		num = list.size();
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {		
		BinaryTreeLevelOrderTraversal t = new BinaryTreeLevelOrderTraversal();
		
		TreeNode root = new TreeNode(1);
		ArrayList<ArrayList<Integer>> res = t.levelOrder(root);
		if (res.size() > 0) {
			for (ArrayList<Integer> level : res) {
				for (Integer i : level) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
	}

}
