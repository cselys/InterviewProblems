package fantasist.InterviewProblems.failed;

public class InterleavingString {
	
	public boolean isInterleave(char[] ca1, int p1, char[] ca2, int p2, char[] ca3, int p3) {
		if (p3 == ca3.length)
			return true;
		if (ca1.length > p1 && ca2.length > p2) {
			if (ca1[p1] == ca3[p3] && ca2[p2] == ca3[p3])
				return isInterleave(ca1, p1 + 1, ca2, p2, ca3, p3 + 1)
						|| isInterleave(ca1, p1, ca2, p2 + 1, ca3, p3 + 1);
			else if (ca1[p1] == ca3[p3])
				return isInterleave(ca1, p1 + 1, ca2, p2, ca3, p3 + 1);
			else if (ca2[p2] == ca3[p3])
				return isInterleave(ca1, p1, ca2, p2 + 1, ca3, p3 + 1);
			else
				return false;
		} else if (ca1.length > p1) {
			for (int i = 0; i + p1 < ca1.length; i++) {
				if (ca1[p1 + i] != ca3[p3 + i])
					return false;
			}
			return true;
		} else {
			for (int i = 0; i + p2 < ca2.length; i++) {
				if (ca2[p2 + i] != ca3[p3 + i])
					return false;
			}
			return true;
		}
	}
	
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1 == null || s2 == null || s3 == null)
    		return false;
    	if (s1.length() + s2.length() != s3.length())
    		return false;
    	
    	char[] ca1 = s1.toCharArray();
    	char[] ca2 = s2.toCharArray();
    	char[] ca3 = s3.toCharArray();
    	
    	return isInterleave(ca1, 0, ca2, 0, ca3, 0);
    }
	
	public static void main(String[] args) {
		InterleavingString is = new InterleavingString();
		if  //(is.isInterleave("a", "a", "aa"))
			//(is.isInterleave("aa", "aba", "aabaa"))
			//(is.isInterleave("aa", "aba", "aabab"))
			(is.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"))
			System.out.println("true");
		else
			System.out.println("false");
	}

}
