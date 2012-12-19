package fantasist.InterviewProblems.coding;

public class WildcardMatching {
	
    public boolean isMatch(String s, String p) {
    	if (s == null || p == null)
    		return false;
    	if (s.isEmpty() && p.isEmpty()) {
    		return true;
    	} else if (s.isEmpty()) {
    		for (int i = 0; i < p.length(); i++) {
    			if (p.charAt(i) != '*')
    				return false;
    		}
    		return true;
    	} else if (p.isEmpty()) {
    		return false;
    	}
    	
    	boolean[][] matrix = new boolean[p.length()][s.length()];
    	for (int i = 0; i < p.length(); i++) {
    		for (int j = 0; j < s.length(); j++) {
    			if (p.charAt(i) == '*') {
    				if (i == 0) {
    					matrix[i][j] = true;
    				} else {
	    				if (j > 0 && matrix[i][j-1] == true) {
	    					matrix[i][j] = true;
	    				} else if (j > 0 && matrix[i-1][j-1] == true) {
	    					matrix[i][j] = true;
	    				} else if (matrix[i-1][j] == true) {
	    					matrix[i][j] = true;
	    				}
    				}
    			} else if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) {
    				if (i == 0 && j == 0) {
    					matrix[i][j] = true;
    				} else if (i > 0 && j > 0 && matrix[i-1][j-1] == true) {
    					matrix[i][j] = true;
    				} else if (i > 0 && p.charAt(i-1) == '*' && matrix[i-1][j] == true) {
    					matrix[i][j] = true;
    					int k = i - 2;
    					while(k >= 0) {
    						if (p.charAt(k) != '*') {
    							matrix[i][j] = false;
    							break;
    						}
    						k--;
    					}
    				}
    			}
    		}
    	}
    	
    	return matrix[p.length()-1][s.length()-1];
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
			System.out.println("Test of s=\"" + s + "\" p=\"" + p + "\" failed!");
	}

}