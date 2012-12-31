package fantasist.InterviewProblems.leetcode.passed;

public class EditDistance {

	// Memory usage not optimal but still accepted
    public int minDistance(String word1, String word2) {
    	if (word1 == null || word2 == null)
    		return 0;
    	int len1 = word1.length(), len2 = word2.length();
    	if (len1 == 0)
    		return len2;
    	if (len2 == 0)
    		return len1;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1+1; i++) {
        	for (int j = 0; j < len2+1; j++) {
        		if (i == 0) {
        			dp[i][j] = j;
        		} else if (j == 0) {
        			dp[i][j] = i;
        		} else {
        			dp[i][j] = Integer.MAX_VALUE;
        			if (word1.charAt(i-1) == word2.charAt(j-1)) {
        				dp[i][j] = dp[i-1][j-1];
        			} else {
        				dp[i][j] = 1 + dp[i-1][j-1];
        			}
        			dp[i][j] = Math.min(dp[i][j], 1 + dp[i-1][j]);
        			dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j-1]);
        		}
        	}
        }
        
        return dp[len1][len2];
    }
    
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance("a", "a"));
		System.out.print(ed.minDistance("ab", "bac"));
	}

}
