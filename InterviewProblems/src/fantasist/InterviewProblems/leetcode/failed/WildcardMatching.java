package fantasist.InterviewProblems.leetcode.failed;

public class WildcardMatching {

	// DP solution Should be O(NM) complexity. But timed out on large test (A similar C++ version was accepted)
	public boolean isMatch(String s, String p) {
    	if (s == null || p == null)
    		return false;
    	if (s.isEmpty() && p.isEmpty()) {	//Both are empty string -> true
    		return true;
    	} else if (s.isEmpty()) {	// If s is empty, p must not contain any character other than '*'
    		for (int i = 0; i < p.length(); i++) {
    			if (p.charAt(i) != '*')
    				return false;
    		}
    		return true;
    	} else if (p.isEmpty()) {	// If p is empty, return false
    		return false;
    	}
    	
    	char[] pArr = p.toCharArray();
    	char[] sArr = s.toCharArray();
    	// handles test cases like s = "c", p = "*?*?"
    	int leadingStars = -1;
    	while (++leadingStars < pArr.length && pArr[leadingStars] == '*') {}
    	leadingStars--;
    	
    	boolean[][] T = new boolean[2][pArr.length];
    	for (int i = 0; i < sArr.length; i++) {
    		for (int j = 0; j < pArr.length; j++) {
    			char c = pArr[j];
    			if (c == '*') {
    				T[1][j] = (i > 0 ? T[0][j] : false)
    						|| ((i > 0 && j > 0) ? T[0][j-1] : false)
    						|| (j > 0 ? T[1][j-1] : true)
    						|| ((i == 0 && j == 0) ? true : false);
    			} else if (c == '?' || c == sArr[i]) {
    				T[1][j] = ((i > 0 && j > 0) ? T[0][j-1] : false)
    						|| ((i == 0 && j == 0) ? true : false)
    						|| ((leadingStars >= 0 && leadingStars == j - 1) ? true : false);
    			} else {
    				T[1][j] = false;
    			}
    		}
    		
    		boolean[] temp = T[0];
    		T[0] = T[1];
    		T[1] = temp;
    	}
		
    	return T[0][pArr.length-1];
	}

	public boolean isMatch_recursive(String s, String p) {
		if (s == null || p == null)
			return false;
		if (p.isEmpty() && s.isEmpty())
			return true;
		else if (s.isEmpty() && p.charAt(0) == '*')
			return isMatch(s, p.substring(1));
		else if (s.isEmpty() || p.isEmpty())
			return false;
		
		if (p.charAt(0) == '*') {
			return isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(1)) || isMatch(s, p.substring(1));
		} else if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
			return isMatch(s.substring(1), p.substring(1));
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		
		wm.testMatch("a", "b", false);
		wm.testMatch("aa", "a", false);
		wm.testMatch("aa", "aa", true);
		wm.testMatch("aa", "*", true);
		wm.testMatch("ab", "?*", true);
		wm.testMatch("aab", "*c*a*b", false);
		wm.testMatch("c", "*?*", true);
		wm.testMatch("c", "?*?*", false);
		wm.testMatch("ab", "*?*?*", true);
		wm.testMatch("ho", "ho**", true);
		wm.testMatch("baabaa", "a****", false);
		wm.testMatch("aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab", "*ab***ba**b*b*aaab*b", true);
	}
	
	public void testMatch(String s, String p, boolean expected) {
		boolean ans = isMatch(s, p);
		if (ans != expected)
			System.out.println("Test of s=\"" + s + "\" p=\"" + p + "\" failed! (Expected " + (expected ? "true" : "false") + ")");
	}

}
