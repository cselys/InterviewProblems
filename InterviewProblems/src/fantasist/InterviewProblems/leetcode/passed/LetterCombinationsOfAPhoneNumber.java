package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {

	char[] buff;
	char[][] table = {
			{' '},
			{},
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
	};
	
	private void recursive(String digits, int pos, ArrayList<String> res) {
		if (pos == digits.length()) {
			String str = String.copyValueOf(buff);
			res.add(str);
			return;
		}
		
		char[] choices = table[(int)(digits.charAt(pos) - '0')];
		for (int i = 0; i < choices.length; i++) {
			buff[pos] = choices[i];
			recursive(digits, pos+1, res);
		}
	}
	
    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
        	res.add("");
        	return res;	
        }
        
        buff = new char[digits.length()];
        recursive(digits, 0, res);
        
        return res;
    }
    
	public static void main(String[] args) {

	}

}
