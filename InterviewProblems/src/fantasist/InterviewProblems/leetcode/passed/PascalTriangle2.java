package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class PascalTriangle2 {

    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if (rowIndex < 0)
    		return res;
    	
    	int[] pre = new int[rowIndex + 1];
    	int[] cur = new int[rowIndex + 1];
    	for (int i = 0; i <= rowIndex; i++) {
    		if (i == 0) {
    			cur[0] = 1;
    		} else {
    			for (int j = 0; j <= i; j++) {
    				if (j == 0 || j == i)
    					cur[j] = 1;
    				else
    					cur[j] = pre[j-1] + pre[j];
    			}
    		}
			for (int j = 0; j <= i; j++) {
	    		if (i < rowIndex)
					pre[j] = cur[j];
				else
					res.add(cur[j]);
			}
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		PascalTriangle2 p = new PascalTriangle2();
		ArrayList<Integer> res = p.getRow(2);
		for (Integer i : res)
			System.out.println(i + " ");
		System.out.println();
	}

}
