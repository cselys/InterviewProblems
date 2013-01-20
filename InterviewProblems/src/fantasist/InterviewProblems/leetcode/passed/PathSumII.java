package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class PathSumII {
    
	//TLE on large
	private void pathSumHelper(TreeNode node, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
		if (node == null)
			return;
		temp.add(node.val);
		if (node.val == sum && node.left == null && node.right == null) {
			ArrayList<Integer> sol = new ArrayList<Integer>(temp);
			res.add(sol);
		} else {
			pathSumHelper(node.left, sum - node.val, temp, res);
			pathSumHelper(node.right, sum - node.val, temp, res);
		}
		temp.remove(temp.size()-1);
	}
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
        	return res;
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        pathSumHelper(root, sum, temp, res);
        
        return res;
    }
    
	public static void main(String[] args) {
		
	}

}
