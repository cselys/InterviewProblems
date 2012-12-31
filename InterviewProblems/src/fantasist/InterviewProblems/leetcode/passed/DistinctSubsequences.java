package fantasist.InterviewProblems.leetcode.passed;

public class DistinctSubsequences {

	
	// TLE
	private int numDistinctHelper_recursive(char[] S, int posS, char[] T, int posT) {
		if (posT == T.length)
			return 1;
		if (posS == S.length)
			return 0;
		int res = numDistinctHelper_recursive(S, posS + 1, T, posT);
		if (S[posS] == T[posT]) {
			res += numDistinctHelper_recursive(S, posS + 1, T, posT + 1);
		}
		return res;
	}
	
    public int numDistinct(String S, String T) {
    	if (S == null || T == null || S.length() < 1 || T.length() < 1)
    		return 0;
    	
    	int lenS = S.length(), lenT = T.length();
    	int[] temp1 = new int[lenS];
    	int[] temp2 = new int[lenS];
    	
    	for (int i = 0; i < lenT; i++) {
    		for (int j = 0; j < lenS; j++) {
    			temp2[j] = 0;
				if (S.charAt(j) == T.charAt(i)) {
					if (i == 0) {
						if (j == 0)
							temp2[j] = 1;
						else
							temp2[j] = temp2[j-1] + 1;
					} else {
						if (j > 0)
							temp2[j] = temp1[j-1] + temp2[j-1];
					}
				} else {
					if (j > 0)
						temp2[j] = temp2[j - 1];
				}
    		}
    		for (int j = 0; j < lenS; j++)
    			temp1[j] = temp2[j];
    	}
    	
    	return temp2[lenS - 1];
    }
    
	public static void main(String[] args) {
		DistinctSubsequences d = new DistinctSubsequences();
		System.out.println(d.numDistinct("abcccde", "bc"));
	}

}
