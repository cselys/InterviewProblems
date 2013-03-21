package fantasist.InterviewProblems.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import fantasist.InterviewProblems.leetcode.utils.TreeNode;

public class RebuildTreeFromNodePairs {

	public static class Pair {
		int child, parent;
		public Pair(int c, int p) {
			child = c;
			parent = p;
		}
	}
	
	public TreeNode rebuildTree(ArrayList<Pair> pairs) {
		HashMap<Integer, TreeNode> created = new HashMap<Integer, TreeNode>();
		HashSet<Integer> possibleRoot = new HashSet<Integer>();
		HashSet<Integer> notRoot = new HashSet<Integer>();
		for (Pair p : pairs) {
			TreeNode child = created.get(p.child);
			TreeNode parent = created.get(p.parent);
			if (child == null) {
				child = new TreeNode(p.child);
				created.put(p.child, child);
			}
			if (parent == null) {
				parent = new TreeNode(p.parent);
				created.put(p.parent, parent);
			}
			if (parent.left == null)
				parent.left = child;
			else
				parent.right = child;
			possibleRoot.remove(p.child);
			notRoot.add(p.child);
			if (!notRoot.contains(p.parent))
				possibleRoot.add(p.parent);
		}
		if (possibleRoot.size() != 1) {
			System.out.println("Invalid input: possible root count is " + possibleRoot.size());
			return null;
		}
		Object[] roots = possibleRoot.toArray();
		return created.get((Integer)roots[0]);
	}
	
	public static void main(String[] args) {
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		pairs.add(new Pair(0, 3));
		pairs.add(new Pair(1, 3));
		pairs.add(new Pair(2, 4));
		pairs.add(new Pair(3, 4));
		
		RebuildTreeFromNodePairs r = new RebuildTreeFromNodePairs();
		TreeNode root = r.rebuildTree(pairs);
		TreeNode.printTreeLevelOrder(root);
	}

}
