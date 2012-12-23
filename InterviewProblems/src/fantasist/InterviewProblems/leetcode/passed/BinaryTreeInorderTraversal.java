package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Stack;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class BinaryTreeInorderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
        	return res;
        
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
        	if (cur != null) {
        		while (cur.left != null) {
        			stack.push(cur.left);
        			cur = cur.left;
        		}
        		cur = null;
        	} else {
        		cur = stack.pop();
        		res.add(cur.val);
        		if (cur.right != null) {
        			cur = cur.right;
        			stack.push(cur);
        		}
        		else
        			cur = null;
        	}
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		BinaryTreeInorderTraversal t = new BinaryTreeInorderTraversal();
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		
		ArrayList<Integer> res = t.inorderTraversal(root);
		if (res.size() > 0) {
			for (Integer i : res) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
