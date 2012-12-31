package fantasist.InterviewProblems.leetcode.passed;

public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
    	if (S == null || T == null || S.length() == 0 || T.length() == 0 || S.length() < T.length())
    		return "";
        int[] hashT = new int[256];
        int[] hashS = new int[256];
        int count = 0;
        for (int i = 0; i < T.length(); i++)
        	hashT[T.charAt(i)] ++;
        
        int start = 0;
        int minStart = -1, minEnd = -1;
        for (int i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
        	hashS[c]++;
        	if (hashT[c] > 0) {
        		if (hashS[c] <= hashT[c])
        			count++;
        		if (count == T.length()) {
        			while (true) {
        				char r = S.charAt(start);
        				if (hashT[r] == 0) {
        					hashS[r]--;
        					start++;
        				} else if (hashT[r] < hashS[r]) {
        					hashS[r]--;
        					start++;
        				} else {
        					break;
        				}
        			}
        			int newLen = i - start;
        			if (minStart == -1 || newLen < minEnd - minStart) {
        				minStart = start;
        				minEnd = i;
        			}
        		}
        	}
        }
        
        if (minStart == -1)
        	return "";
        else
        	return S.substring(minStart, minEnd + 1);
    }
    
	public static void main(String[] args) {
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
	}

}
