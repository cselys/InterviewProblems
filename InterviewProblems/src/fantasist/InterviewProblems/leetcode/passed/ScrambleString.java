package fantasist.InterviewProblems.leetcode.passed;

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		if (s1.length() != s2.length())
			return false;
		int len = s1.length();
		boolean[][][] dp = new boolean[len][len][len+1];
		for (int k = 1; k <= len; k++) {
			for (int i = 0; i + k <= len; i++) {
				for (int j = 0; j + k <= len; j++) {
					dp[i][j][k] = false;
					if (s1.substring(i, i + k).equals(s2.substring(j, j + k)))
						dp[i][j][k] = true;
					else if (k > 1) {
						for (int l = 1; l < k; l++) {
							dp[i][j][k] |= (dp[i][j][l] && dp[i+l][j+l][k-l])
									|| (dp[i][j+k-l][l] && dp[i+l][j][k-l]);
							if (dp[i][j][k] == true)
								break;
						}
					}
				}
			}
		}
		return dp[0][0][len];
	}
	
	// Recursive solution times out on large test set.
    public boolean isScramble_recursive(String s1, String s2) {
        if (s1 == null || s2 == null)
        	return false;
        if (s1.length() != s2.length())
        	return false;
        if (s1.equals(s2))
        	return true;
        int len = s1.length();
        for (int i = 1; i < len; i++) {
        	if (isScramble_recursive(s1.substring(0, i), s2.substring(0, i)) && isScramble_recursive(s1.substring(i, len), s2.substring(i, len)))
        		return true;
        	if (isScramble_recursive(s1.substring(0, i), s2.substring(len - i, len)) && isScramble_recursive(s1.substring(i, len), s2.substring(0, len - i )))
        		return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("abc", "cba"));
		System.out.println(ss.isScramble("abcde", "edacb"));
		System.out.println(ss.isScramble("abced", "abc"));
		System.out.println(ss.isScramble("abcd", "bcsa"));
		System.out.println(ss.isScramble("abcd", "cadb"));
	}
}
