package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (S == null)
    		return res;
    	if (S.length == 0) {
    		res.add(new ArrayList<Integer>());
    		return res;
    	}
    	
    	Arrays.sort(S);
    	for (int i = 0; i < (int)Math.pow(2, S.length); i++) {
    		ArrayList<Integer> set = new ArrayList<Integer>();
    		int temp = i;
    		for (int j = 0; j < S.length; j++) {
    			if ((temp & 1) != 0)
    				set.add(S[j]);
    			temp >>= 1;
    		}
    		res.add(set);
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] S = {0};
		ArrayList<ArrayList<Integer>> res = s.subsets(S);
		if (res.isEmpty())
			System.out.println("Empty");
		else {
			for (ArrayList<Integer> list : res) {
				if (list.isEmpty())
					System.out.println("[]");
				else {
					for (Integer i : list)
						System.out.print(i + " ");
					System.out.println();
				}
			}
		}
	}

}
