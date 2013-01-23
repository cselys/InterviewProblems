package fantasist.InterviewProblems.leetcode.passed;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null)
        	return false;
        int start = 0, end = s.length() - 1;
        while (start <= end) {
        	while(start < s.length()) {
        		char c = s.charAt(start);
        		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
        				|| (c >= '0' && c <= '9'))
        			break;
        		start++;
        	}
        	if (start > end)
        		return true;
        	while (end >= 0) {
        		char c = s.charAt(end);
        		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
        				|| (c >= '0' && c <= '9'))
        			break;
        		end--;
        	}
        	if (start > end)
        		return true;
        	if (Character.toLowerCase(s.charAt(start)) != 
        			Character.toLowerCase(s.charAt(end)))
        		return false;
        	start++;
        	end--;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome("a."));
	}

}
