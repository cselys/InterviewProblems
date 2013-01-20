package fantasist.InterviewProblems.leetcode.failed;

public class ScrambleString {

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
		System.out.println(ss.isScramble_recursive("abcde", "edacb") ? "true" : "false");
		System.out.println(ss.isScramble_recursive("abced", "abc") ? "true" : "false");
		System.out.println(ss.isScramble_recursive("abcd", "bcsa") ? "true" : "false");
		System.out.println(ss.isScramble_recursive("abcd", "cadb") ? "true" : "false");
	}
}
