package fantasist.InterviewProblems.leetcode.passed;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class SumRootToLeafNumbers {

    int sum;
    
    private void calcSum(TreeNode node, int pre) {
        if (node.left == null && node.right == null) {
            sum = sum + (pre * 10 + node.val);
            return;
        }
        
        if (node.left != null)
            calcSum(node.left, pre * 10 + node.val);
        if (node.right != null)
            calcSum(node.right, pre * 10 + node.val);
    }
    
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        sum = 0;
        calcSum(root, 0);
        return sum;
    }
    
    public static void main(String[] args) {

    }

}
