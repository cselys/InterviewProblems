package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Stack;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class RecoverBinarySearchTree {

    //Ugly O(n) space solution
    
    class Bundle {
        public int val;
        public TreeNode node;
        public Bundle(int v, TreeNode n) {
            val = v;
            node = n;
        }
    }
    
    private ArrayList<Bundle> inOrderTraversal(TreeNode root) {
        ArrayList<Bundle> arr = new ArrayList<Bundle>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        TreeNode cur = root;
        while (!stack.empty()) {
            if (cur == null) {
                cur = stack.pop();
                arr.add(new Bundle(cur.val, cur));
                if (cur.right != null) {
                    stack.push(cur.right);
                    cur = cur.right;
                } else {
                    cur = null;
                }
            } else {
                while (cur.left != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                }
                cur = null;
            }
        }
        
        return arr;
    }
	
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        
        ArrayList<Bundle> arr = inOrderTraversal(root);
        if (arr.size() < 2)
            return;
        
        Bundle first = null, second = null;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).val > arr.get(i + 1).val) {
                first = arr.get(i);
                break;
            }
        }
        for (int i = arr.size() - 1; i > 0; i--) {
            if (arr.get(i).val < arr.get(i - 1).val) {
                second = arr.get(i);
                break;
            }
        }
        
        if (first == null || second == null)
            return;
        int temp = first.node.val;
        first.node.val = second.node.val;
        second.node.val = temp;
    }
    
	public static void main(String[] args) {
	    RecoverBinarySearchTree r = new RecoverBinarySearchTree();
	    
//	    String[] nodes = {"4","2","6","7","3","5","1"};
	    String[] nodes = {"3", "1", "2"};
//        String[] nodes = {"2", "3", "1"};
	    TreeNode root = TreeNode.constructFromArray(nodes);
	    r.recoverTree(root);
	    TreeNode.printTreeLevelOrder(root);
	}

}
