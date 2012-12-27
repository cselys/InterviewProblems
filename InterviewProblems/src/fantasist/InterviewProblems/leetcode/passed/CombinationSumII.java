package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {

	int[] candidates;
	
	private void getCombination(int idx, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
		if (idx >= candidates.length) {
			return;
		}
		if (candidates[idx] == target) {
			ArrayList<Integer> ans = new ArrayList<Integer>(temp);
			ans.add(candidates[idx]);
			res.add(ans);
		} else if (candidates[idx] < target) {
			temp.add(candidates[idx]);
			getCombination(idx+1, target - candidates[idx], res, temp);
			temp.remove(temp.size()-1);
			
			int newIdx = idx + 1;
			while(newIdx < candidates.length) {
				if (candidates[newIdx] != candidates[idx])
					break;
				newIdx++;
			}
			if (newIdx < candidates.length) {
				getCombination(newIdx, target, res, temp);
			}
		} else {
			return;
		}
	}
	
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 1 || target <= 0) {
        	return res;
        }
        Arrays.sort(num);
        candidates = num;
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        getCombination(0, target, res, temp);
        
        return res;
    }
    
	public static void main(String[] args) {
		CombinationSumII cs = new CombinationSumII();
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		
		ArrayList<ArrayList<Integer>> res = cs.combinationSum2(num, target);
		if (res != null && !res.isEmpty()) {
			for (ArrayList<Integer> sol : res) {
				if (!sol.isEmpty()) {
					for (Integer i : sol) {
						System.out.print(i + " ");
					}
					System.out.println();
				}
			}
		}
	}

}
