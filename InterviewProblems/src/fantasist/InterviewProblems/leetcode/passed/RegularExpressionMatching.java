package fantasist.InterviewProblems.leetcode.passed;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
        	return false;
        
        int sLen = s.length(), pLen = p.length();
        if (pLen == 0) {
        	if (sLen == 0)
        		return true;
        	else
        		return false;
        }
        
        char[] sStr = s.toCharArray();
        char[] pStr = p.toCharArray();
        
        int validSkips = 0;
    	for (int i = 0; i < pLen; i += 2) {
    		if (pStr[i] == '*')
    			return false;
    		if (i + 1 >= pLen || pStr[i+1] != '*')
    			break;
    		
    		validSkips += 2;
    	}

        if (sLen == 0 && validSkips != pLen)
        	return false;
        else if (sLen == 0)
        	return true;
        
        boolean[][] dp = new boolean[2][pLen];
        for (int i = 0; i < sLen; i++) {
        	for (int j = 0; j < pLen; j++) {
        		dp[0][j] = false;
	        	if (pStr[j] == '*') {
	        		if (j+1 < pLen && pStr[j+1] == '*')  // Assume "**" is invalid
	        			return false;
	        		dp[0][j] = (j > 1 ? dp[0][j-2] : false) ||
	        					((i > 0 && (pStr[j-1] == sStr[i] || pStr[j-1] == '.')) ? (dp[1][j] || 
	        							(j > 1 ? dp[1][j-2]: false)) : false) ||
	        					(i == 0 && (j <= validSkips + 1) && (pStr[j-1] == sStr[i] || pStr[j-1] == '.')) ? true : false;
        		} else if (pStr[j] == '.' || pStr[j] == sStr[i]) {
        			if (j+1 < pLen && pStr[j+1] == '*')
        				continue;
        			
        			dp[0][j] = ((i > 0 && j > 0) ? dp[1][j-1] : false) ||
        						((i == 0 && j == 0) ? true : false) ||  
        						((i == 0 && j == validSkips) ? true : false);   // Edge case like p = "a*b*c" and s = "c"
        		} else {
	        		if (j+1 < pLen && pStr[j+1] == '*')
	        			continue;
	        		dp[0][j] = false;
        		}
        	}
        	
        	boolean[] temp = dp[0];
        	dp[0] = dp[1];
        	dp[1] = temp;
        }
        
        return dp[1][pLen-1];
    }
    
	public static void main(String[] args) {
		RegularExpressionMatching r = new RegularExpressionMatching();
		System.out.println(r.isMatch("abc", "a*bc"));  //true
		System.out.println(r.isMatch("abc", "b*a*bc"));  //true
		System.out.println(r.isMatch("abc", ".*c"));  //true
		System.out.println(r.isMatch("abc", ".*c.*"));  //true
		System.out.println(r.isMatch("aaa", "ab*a"));  //false
		System.out.println(r.isMatch("abbbcd", "ab*bbbcd"));  //true
		System.out.println(r.isMatch("aaba", "ab*a*c*a"));  //false
		System.out.println(r.isMatch("abb", "b*"));  //false
	}

}
