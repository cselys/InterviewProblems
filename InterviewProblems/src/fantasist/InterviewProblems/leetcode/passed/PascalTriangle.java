package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows < 1)
        	return res;
        
        ArrayList<Integer> last = null;
        for (int i = 0; i < numRows; i++) {
    		ArrayList<Integer> row = new ArrayList<Integer>();
        	if (i == 0) {
        		row.add(1);
        	} else {
        		for (int j = 0; j <= i; j++) {
        			if (j == 0 || j == i)
        				row.add(1);
        			else
        				row.add(last.get(j - 1) + last.get(j));
        		}
        	}
        	res.add(row);
        	last = row;
        }
        
        return res;
    }
    
	public static void main(String[] args) {

	}

}
