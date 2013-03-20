package fantasist.InterviewProblems.other;

import java.util.LinkedList;
import java.util.Queue;

public class QuadTree {

	public QuadTree p, q, s, t;
	public Boolean val;
	
	public QuadTree() {
		p = null;
		q = null;
		s = null;
		t = null;
		val = null;
	}
	
	public QuadTree(boolean v) {
		val = v;
		p = null;
		q = null;
		s = null;
		t = null;
	}
	
	public void merge(QuadTree tree) {
		if (tree == null)
			return;
		if (val != null) {
			if (val != true)
				shallowCopy(tree);
		} else if (tree.val != null) {
			if (tree.val == true)
				shallowCopy(tree);
		} else {
			p.merge(tree.p);
			q.merge(tree.q);
			s.merge(tree.s);
			t.merge(tree.t);
			
			if (p.val == null || q.val == null || s.val == null || t.val == null)
				return;
			else if (p.val == true && q.val == true && s.val == true && t.val == true) {
				val = true;
				fillChildren(null, null, null, null);
			} else if (p.val == false && q.val == false && s.val == false && t.val == false) {
				val = false;
				fillChildren(null, null, null, null);
			}
		}
	}
	
	private void fillChildren(QuadTree p, QuadTree q, QuadTree s, QuadTree t) {
		this.p = p;
		this.q = q;
		this.s = s;
		this.t = t;
	}
	
	private void shallowCopy(QuadTree tree) {
		val = tree.val;
		p = tree.p;
		q = tree.q;
		s = tree.s;
		t = tree.t;
	}
	
	public void printTree() {
		Queue<QuadTree> q = new LinkedList<QuadTree>();
		q.add(this);
		while (!q.isEmpty()) {
			int n = q.size();
			while (n-- > 0) {
				QuadTree node = q.poll();
				if (node.val != null) {
					System.out.print(node.val + " ");
				} else {
					System.out.print("node ");
					q.add(node.p);
					q.add(node.q);
					q.add(node.s);
					q.add(node.t);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		QuadTree tree1 = new QuadTree();
		tree1.p = new QuadTree(true);
		tree1.q = new QuadTree(true);
		tree1.s = new QuadTree(true);
		tree1.t = new QuadTree();
		tree1.t.p = new QuadTree(true);
		tree1.t.q = new QuadTree(false);
		tree1.t.s = new QuadTree(false);
		tree1.t.t = new QuadTree(false);
		
		QuadTree tree2 = new QuadTree();
		tree2.p = new QuadTree();
		tree2.p.p = new QuadTree(false);
		tree2.p.q = new QuadTree(false);
		tree2.p.s = new QuadTree(true);
		tree2.p.t = new QuadTree(true);
		tree2.q = new QuadTree(false);
		tree2.s = new QuadTree(false);
		tree2.t = new QuadTree();
		tree2.t.p = new QuadTree(false);
		tree2.t.q = new QuadTree(true);
		tree2.t.s = new QuadTree(true);
		tree2.t.t = new QuadTree(true);
		
		System.out.println("Tree 1:");
		tree1.printTree();
		System.out.println("\nTree 2:");
		tree2.printTree();
		System.out.println("\nMerged:");
		tree1.merge(tree2);
		tree1.printTree();
	}

}
