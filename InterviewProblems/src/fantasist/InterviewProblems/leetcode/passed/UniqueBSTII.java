package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class UniqueBSTII {
    
    private void addVal(TreeNode node, int v) {
        if (node == null)
            return;
        node.val += v;
        addVal(node.left, v);
        addVal(node.right, v);
    }
    
    private TreeNode copyTree(TreeNode node) {
        if (node == null)
            return null;
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = copyTree(node.left);
        newNode.right = copyTree(node.right);
        
        return newNode;
    }
    
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (n == 0) {
            res.add(null);
            return res;
        }
        if (n == 1) {
            res.add(new TreeNode(1));
            return res;
        }
        for (int root = 1; root <= n; root++) {
            ArrayList<TreeNode> left = generateTrees(root - 1);
            ArrayList<TreeNode> right = generateTrees(n - root);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = copyTree(leftNode);
                    rootNode.right = copyTree(rightNode);
                    addVal(rootNode.right, root);
                    res.add(rootNode);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        UniqueBSTII u = new UniqueBSTII();
        ArrayList<TreeNode> list = u.generateTrees(3);
        for (TreeNode tree : list) {
            System.out.println("Print tree:");
            TreeNode.printTreeLevelOrder(tree);
            System.out.println();
        }
    }

}
