package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class GenerateParentheses {
	
	private void generate_helper(ArrayList<String> res, int left, int right, char[] buff, int pos) {
		if (left == 0 && right == 0) {
			String str = String.copyValueOf(buff);
			res.add(str);
			return;
		}
		if (left > 0) {
			buff[pos] = '(';
			generate_helper(res, left-1, right, buff, pos+1);
		}
		if (right > 0 && right > left) {
			buff[pos] = ')';
			generate_helper(res, left, right-1, buff, pos+1);
		}
	}

    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> res = new ArrayList<String>();
    	if (n < 1)
    		return res;
    	
    	char[] buff = new char[n * 2];
    	generate_helper(res, n, n, buff, 0);
    	
    	return res;
    }
    
	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		ArrayList<String> res = g.generateParenthesis(3);
		for (String s : res) {
			System.out.println(s);
		}
	}

}
