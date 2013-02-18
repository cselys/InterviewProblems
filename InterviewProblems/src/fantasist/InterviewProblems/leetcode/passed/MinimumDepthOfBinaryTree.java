package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class MinimumDepthOfBinaryTree {

    int min;
    
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        min = Integer.MAX_VALUE;
        calcMin(root, 1);
        return min;
    }
    
    private void calcMin(TreeNode node, int level) {
        if (level >= min)
            return;
        if (node.left == null && node.right == null) {
            min = level;
            return;
        } else {
            if (node.left != null)
                calcMin(node.left, level + 1);
            if (node.right != null)
                calcMin(node.right, level + 1);
        }
    }
    
    public static void main(String[] args) {
        String[] nodes = {"0", "#", "1"};
        TreeNode root = TreeNode.constructFromArray(nodes);
        MinimumDepthOfBinaryTree m = new MinimumDepthOfBinaryTree();
        System.out.println(m.minDepth(root));
    }

}
