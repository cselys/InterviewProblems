package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
		if (inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(postorder[poEnd]);
		int count = 0;
		while (inorder[inStart + count] != postorder[poEnd])
			count++;
		node.left = buildTreeHelper(inorder, inStart, inStart + count - 1, postorder, poStart, poStart + count - 1);
		node.right = buildTreeHelper(inorder, inStart + count + 1, inEnd, postorder, poStart + count, poEnd - 1);
		
		return node;
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length < 1)
        	return null;
        
        TreeNode root = buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, inorder.length - 1);
        return root;
    }
    
	public static void main(String[] args) {
		
	}

}
