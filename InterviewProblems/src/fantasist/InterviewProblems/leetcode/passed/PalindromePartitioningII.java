package fantasist.InterviewProblems.leetcode.passed;

public class PalindromePartitioningII {

    public int minCut(String s) {
        if (s == null || s.length() < 2)
        	return 0;
        
        int len = s.length();
        char[] str = s.toCharArray();
        int[] dp = new int[len];
        boolean[][] p = new boolean[len][len];
        for (int i = 0; i < len; i++) {
        	dp[i] = i;
        	for (int j = 0; j <= i; j++) {
        		p[j][i] = false;
        		if (j == i)
        			p[j][i] = true;
        		else if (str[i] == str[j])
        			p[j][i] = (i - j == 1) || p[j + 1][i - 1];
        		
        		if (j > 0 && p[j][i])
        			dp[i] = Math.min(dp[i], dp[j - 1] + 1);
        	}
    		if (p[0][i])
    			dp[i] = 0;
        }
        
        return dp[len - 1];
    }
    
	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
//		System.out.println(pp.minCut("aaba"));
		System.out.println(pp.minCut("aa"));
	}

}
