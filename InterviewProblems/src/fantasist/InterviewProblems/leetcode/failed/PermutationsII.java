package fantasist.InterviewProblems.leetcode.failed;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {

	/**
	 * Note: The algorithm is not correct at all! 
	 */
	
	boolean[] swapped;
	
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
			if (!swapped[pos]) {
				swapped[pos] = true;
				swap(num, pos, i);
				permute_helper(num, pos+1, res);
				swap(num, pos, i);
				swapped[pos] = false;
			}
		}
	}
	
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0) {
    		return res;
    	}
    	
    	Arrays.sort(num);
    	swapped = new boolean[num.length];
    	Arrays.fill(swapped, false);
    	permute_helper(num, 0, res);
    	
    	return res;
    }
    
	public static void main(String[] args) {
//		int[] num = {0, 1, 0, 0, 9};
		int[] num = {3, 3, 0, 3};
		PermutationsII p = new PermutationsII();
		ArrayList<ArrayList<Integer>> res = p.permuteUnique(num);
		for (ArrayList<Integer> perm : res) {
			for (Integer i : perm)
				System.out.print(i + " ");
			System.out.println();
		}
	}

}
