package fantasist.InterviewProblems.leetcode.passed;

public class DecodeWays {

    public int numDecodings(String s) {
    	if (s == null || s.length() < 1)
    		return 0;
        int pre = 1, pre2 = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
        	cur = 0;
        	char c = s.charAt(i);
        	if (c == '0') {
        		if (i > 0 && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
        			cur = pre2;
        		else
        			return 0;
        	} else if (c >= '1' && c <= '9') {
        		cur += pre;
        		if (i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && c <= '6')))
        			cur += pre2;
        	} else {
        		// This character is not a digit
        		return 0;
        	}
        	pre2 = pre;
        	pre = cur;
        }
        return cur;
    }
    
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		
		System.out.println(dw.numDecodings("2"));
		System.out.println(dw.numDecodings("123"));
		System.out.println(dw.numDecodings("2222"));
	}

}
