package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class GrayCode {

    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if (n < 0)
    		return res;
    	if (n > 31)
    		return res;
        int rounds = (int)Math.pow(2, n);
        
        for (int i = 0; i < rounds; i++) {
        	int num = i ^ (i >> 1);
        	res.add(num);
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		GrayCode g = new GrayCode();
		ArrayList<Integer> res = g.grayCode(2);
		for (Integer i : res)
			System.out.println(i);
	}

}
