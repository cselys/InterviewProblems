package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (num == null)
    		return res;
    	if (num.length == 0) {
    		res.add(new ArrayList<Integer>());
    		return res;
    	}
    	
    	Arrays.sort(num);
    	for (int i = 0; i < (int)Math.pow(2, num.length); i++) {
    		ArrayList<Integer> set = new ArrayList<Integer>();
    		int temp = i;
        	int lastUnselected = -1;
        	boolean add = true;
    		for (int j = 0; j < num.length; j++) {
    			if ((temp & 1) != 0) {
    				if (lastUnselected >= 0 && lastUnselected + 1 == j && num[lastUnselected] == num[j]) {
    					add = false;
    					break;
    				}
    				set.add(num[j]);
    			} else {
    				lastUnselected = j;
    			}
    			temp >>= 1;
    		}
    		if (add)
    			res.add(set);
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		SubsetsII s = new SubsetsII();
		int[] num = {1, 1};
		ArrayList<ArrayList<Integer>> res = s.subsetsWithDup(num);
		for (ArrayList<Integer> set : res) {
			if (set.isEmpty())
				System.out.println("[]");
			else {
				for (Integer i : set)
					System.out.print(i + " ");
				System.out.println();
			}
		}
	}

}
