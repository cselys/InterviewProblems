package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class Combinations {

	private int n, k;
	
	private void select(ArrayList<ArrayList<Integer>> res, int[] stack, int pos, int start) {
		stack[pos] = start;
		if (pos == k - 1) {
			ArrayList<Integer> set = new ArrayList<Integer>(k);
			for (int i = 0; i < k; i++) {
				set.add(stack[i]);
			}
			res.add(set);
			return;
		}
		for (int i = start + 1; n - i >= k - pos - 2; i++) {
			select(res, stack, pos + 1, i);
		}
	}
	
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (n <= 0 || k <= 0 || n < k)
    		return res;
    	this.n = n;
    	this.k = k;
    	
    	for (int i = 1; n - i >= k - 1; i++) {
    		int[] stack = new int[k];
    		select(res, stack, 0, i);
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		Combinations c = new Combinations();
		ArrayList<ArrayList<Integer>> res = c.combine(4, 2);
		if (res != null && !res.isEmpty()) {
			for (int i = 0; i < res.size(); i++) {
				ArrayList<Integer> set = res.get(i);
				for (int j = 0; j < set.size(); j++) {
					System.out.print(set.get(j) + " ");
				}
				System.out.println();
			}
		}
	}

}
