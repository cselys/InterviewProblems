package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	
	int[] cand;
	
	private void findCombination(int minIdx, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
		for (int i = 0; i <= target; i += cand[minIdx]) {
			if (i > 0)
				list.add(cand[minIdx]);
			if (target - i == 0) {
				ArrayList<Integer> newList = new ArrayList<Integer>(list);
				res.add(newList);
			} else if (minIdx+1 < cand.length && target-i >= cand[minIdx+1]) {
				findCombination(minIdx+1, target-i, res, list);
			}
		}
		while (!list.isEmpty() && list.get(list.size() - 1) == cand[minIdx]) {
			list.remove(list.size() - 1);
		}
	}
	
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (candidates == null || candidates.length == 0)
    		return res;
    	
    	Arrays.sort(candidates);
    	cand = candidates;
		ArrayList<Integer> list = new ArrayList<Integer>();
		findCombination(0, target, res, list);
    	
    	
    	return res;
    }
    
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		
//		int[] candidates = {2, 3, 6, 7};
//		int target = 2;
		int[] candidates = {1};
		int target = 2;
		ArrayList<ArrayList<Integer>> res = cs.combinationSum(candidates, target);
		if (res != null && !res.isEmpty()) {
			for (int i = 0; i < res.size(); i++) {
				ArrayList<Integer> comb = res.get(i);
				if (!comb.isEmpty()) {
					for (Integer n : comb) {
						System.out.print(n + " ");
					}
					System.out.println();
				}
			}
		}
	}

}
