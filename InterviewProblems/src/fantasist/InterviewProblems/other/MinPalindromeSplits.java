package fantasist.InterviewProblems.other;

public class MinPalindromeSplits {
    
    private int[][] dp;
    
    private boolean isPalindrome(String s) {
        if (s.length() < 2)
            return true;
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
    
    public int minSplits(String s) {
        dp = new int[s.length() + 1][s.length() + 1];
        
        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start + len <= s.length(); start++)
                dp[start][start + len] =
                    isPalindrome(s.substring(start, start + len)) ? 0 :
                        Math.min((dp[start][start + len - 1] + 1), dp[start + 1][start + len] + 1);
        }
        
        return dp[0][s.length()];
    }
    
    public static void main(String[] args) {
        MinPalindromeSplits m = new MinPalindromeSplits();
        System.out.println(m.minSplits("abcba"));
        System.out.println(m.minSplits("acbbc"));
    }

}
