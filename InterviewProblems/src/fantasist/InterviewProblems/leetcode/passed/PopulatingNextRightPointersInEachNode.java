package fantasist.InterviewProblems.leetcode.passed;

import java.util.LinkedList;

import fantasist.InterviewProblems.leetcode.utils.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {

	// The code also works for Populating Next Right Pointers in Each Node II
    public void connect(TreeLinkNode root) {
    	if (root == null)
    		return;
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        list.add(root);
        while (!list.isEmpty()) {
        	int n = list.size();
        	TreeLinkNode pre = null;
        	for (int i = 0; i < n; i++) {
        		if (i == 0) {
        			pre = list.get(0);
        			if (pre.left != null) list.add(pre.left);
        			if (pre.right != null) list.add(pre.right);
        		} else {
        			TreeLinkNode cur = list.get(0);
        			pre.next = cur;
        			if (cur.left != null) list.add(cur.left);
        			if (cur.right != null) list.add(cur.right);
        			pre = cur;
        		}
        		list.removeFirst();
        	}
        }
    }
    
	public static void main(String[] args) {
		
	}

}
