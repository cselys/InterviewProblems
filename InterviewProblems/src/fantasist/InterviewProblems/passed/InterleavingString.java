package fantasist.InterviewProblems.passed;

public class InterleavingString {
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null)
			return false;

		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (len1 + len2 != len3)
			return false;
		if (len1 == 0)
			return s2.equals(s3);
		if (len2 == 0)
			return s1.equals(s3);
		
		boolean[][] matrix = new boolean[len1 + 1][len2 + 1];
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		char[] arr3 = s3.toCharArray();
		for (int i = 0; i < len1 + 1; i++) {
			for (int j = 0; j < len2 + 1; j++) {
				if (i == 0 && j == 0) {
					matrix[i][j] = true;
				} else {
					if (i > 0 && matrix[i-1][j] == true && arr1[i-1] == arr3[i+j-1])
						matrix[i][j] = true;
					else if (j > 0 && matrix[i][j-1] == true && arr2[j-1] == arr3[i+j-1])
						matrix[i][j] = true;
					else
						matrix[i][j] = false;
				}
			}
		}
		
		return matrix[len1][len2];
	}
	
	public static void main(String[] args) {
		InterleavingString is = new InterleavingString();
		if  //(is.isInterleave("a", "a", "aa"))
//			(is.isInterleave("aa", "aba", "aabaa"))
//			(is.isInterleave("aa", "aba", "aabab"))
			(is.isInterleave_recursive("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"))
			System.out.println("true");
		else
			System.out.println("false");
	}
	
	public boolean isInterleave_recursive(char[] ca1, int p1, char[] ca2, int p2, char[] ca3, int p3) {
		if (p3 == ca3.length)
			return true;
		if (ca1.length > p1 && ca2.length > p2) {
			if (ca1[p1] == ca3[p3] && ca2[p2] == ca3[p3])
				return isInterleave_recursive(ca1, p1 + 1, ca2, p2, ca3, p3 + 1)
						|| isInterleave_recursive(ca1, p1, ca2, p2 + 1, ca3, p3 + 1);
			else if (ca1[p1] == ca3[p3])
				return isInterleave_recursive(ca1, p1 + 1, ca2, p2, ca3, p3 + 1);
			else if (ca2[p2] == ca3[p3])
				return isInterleave_recursive(ca1, p1, ca2, p2 + 1, ca3, p3 + 1);
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
	
    public boolean isInterleave_recursive(String s1, String s2, String s3) {
    	if (s1 == null || s2 == null || s3 == null)
    		return false;
    	if (s1.length() + s2.length() != s3.length())
    		return false;
    	
    	char[] ca1 = s1.toCharArray();
    	char[] ca2 = s2.toCharArray();
    	char[] ca3 = s3.toCharArray();
    	
    	return isInterleave_recursive(ca1, 0, ca2, 0, ca3, 0);
    }
}
