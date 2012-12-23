package fantasist.InterviewProblems.leetcode.utils;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    
    public static TreeNode constructFromArray(String[] nodes) {
    	TreeNode root = null;
    	if (nodes == null || nodes.length == 0)
    		return root;
    	
    	root = new TreeNode(Integer.parseInt(nodes[0]));
    	LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    	list.add(root);
    	int count = 1;
    	while (count < nodes.length) {
    		TreeNode cur = list.get(0);
    		list.remove(0);
    		if (nodes[count].equals("#")) {
    			cur.left = null;
    		} else {
    			cur.left = new TreeNode(Integer.parseInt(nodes[count]));
    			list.add(cur.left);
    		}
    		count++;
    		if (count < nodes.length) {
    			if (nodes[count].equals("#")) {
    				cur.right = null;
    			} else {
    				cur.right = new TreeNode(Integer.parseInt(nodes[count]));
    				list.add(cur.right);
    			}
    		}
    		count++;
    	}
    	
    	return root;
    }
    
    public static void printTreeLevelOrder(TreeNode root) {
    	if (root == null)
    		return;
    	
    	List<TreeNode> list = new LinkedList<TreeNode>();
    	list.add(root);
    	int num = 1;
    	while(num > 0) {
    		int count = 0;
    		while (count++ < num) {
    			TreeNode node = list.get(0);
    			System.out.print(node.val + " ");
    			if (node.left != null)
    				list.add(node.left);
    			if (node.right != null)
    				list.add(node.right);
    			list.remove(0);
    		}
    		System.out.println();
    		num = list.size();
    	}
    }
}
