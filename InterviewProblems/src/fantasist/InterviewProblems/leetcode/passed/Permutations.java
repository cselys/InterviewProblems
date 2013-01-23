package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class Permutations {

	private void swap(int[] num, int pos1, int pos2) {
		int temp = num[pos1];
		num[pos1] = num[pos2];
		num[pos2] = temp;
	}
	
	private void permute_helper(int[] num, int pos, ArrayList<ArrayList<Integer>> res) {
		if (pos == num.length) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int i = 0; i < num.length; i++)
				arr.add(num[i]);
			res.add(arr);
			return;
		}
		for (int i = pos; i < num.length; i++) {
			swap(num, pos, i);
			permute_helper(num, pos+1, res);
			swap(num, pos, i);
		}
	}
	
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0) {
    		return res;
    	}
    	
    	permute_helper(num, 0, res);
    	
    	return res;
    }
    
	public static void main(String[] args) {

	}

}
