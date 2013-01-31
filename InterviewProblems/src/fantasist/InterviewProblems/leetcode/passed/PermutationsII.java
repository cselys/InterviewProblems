package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
	
	private void swap(int[] num, int pos1, int pos2) {
		int temp = num[pos1];
		num[pos1] = num[pos2];
		num[pos2] = temp;
	}
	
	private void reverse(int[] num, int start, int end) {
	    while(start < end) {
	        int temp = num[start];
	        num[start] = num[end];
	        num[end] = temp;
	        start++;
	        end--;
	    }
	}
	
	private ArrayList<Integer> arrToArrayList(int[] num) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++)
            list.add(num[i]);
        return list;
	}
	
	private boolean nextPermutation(int[] num) {
	    int i = num.length - 2;
	    while (i >= 0) {
	        if (num[i] < num[i + 1])
	            break;
	        else
	            i--;
	    }
	    if (i < 0)
	        return false;
	    int j = num.length - 1;
	    while (j > i) {
	        if (num[j] > num[i])
	            break;
	        else
	            j--;
	    }
	    swap(num, i, j);
	    reverse(num, i + 1, num.length - 1);
	    
	    return true;
	}
	
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0) {
    		return res;
    	}
    	
    	Arrays.sort(num);

    	ArrayList<Integer> list = arrToArrayList(num);
    	res.add(list);
    	
    	while (nextPermutation(num)) {
    	    list = arrToArrayList(num);
    	    res.add(list);
    	}
    	
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
