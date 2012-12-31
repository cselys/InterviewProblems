package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd)
			return null;
		TreeNode node = new TreeNode(preorder[preStart]);
		int count = 0;
		while (inorder[inStart + count] != preorder[preStart])
			count++;
		node.left = buildTreeHelper(preorder, preStart + 1, preStart + count, inorder, inStart, inStart + count - 1);
		node.right = buildTreeHelper(preorder, preStart + count + 1, preEnd, inorder, inStart + count + 1, inEnd);
		
		return node;
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length)
        	return null;
        
        TreeNode root = buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
        return root;
    }
    
	public static void main(String[] args) {
	}

}
