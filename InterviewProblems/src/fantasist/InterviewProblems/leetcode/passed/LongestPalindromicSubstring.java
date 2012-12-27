package fantasist.InterviewProblems.leetcode.passed;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
        	return null;
        
        char[] arr = s.toCharArray();
        int startIdx = 0, maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
        	int len = 1;
        	for (int j = 1; i-j >= 0 && i+j < arr.length; j++) {
        		if (arr[i-j] == arr[i+j])
        			len += 2;
        		else
        			break;
        		
        		if (len > maxLen) {
        			startIdx = i-j;
        			maxLen = len;
        		}
        	}
        	if (i+1 < arr.length && arr[i+1] == arr[i]) {
        		len = 2;
        		if (len > maxLen) {
        			startIdx = i;
        			maxLen = len;
        		}
        		for (int j = 1; i-j >= 0 && i+j+1 < arr.length; j++) {
        			if (arr[i-j] == arr[i+j+1])
        				len += 2;
        			else
        				break;
        			
        			if (len > maxLen) {
        				startIdx = i-j;
        				maxLen = len;
        			}
        		}
        	}
        }
        return s.substring(startIdx, startIdx + maxLen);
    }
    
	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		
		String s = "aabccbaaaaaaaaaaaaa";
		String s2 = "dwaabccbaaa";
		
		System.out.println(lps.longestPalindrome(s));
		System.out.println(lps.longestPalindrome(s2));
	}

}
