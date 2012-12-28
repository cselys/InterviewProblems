package fantasist.InterviewProblems.leetcode.failed;

public class LongestCommonPrefix {

	// TLE on large wtf!
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
        	return null;
        if (strs.length == 0)
        	return "";
        if (strs.length == 1)
        	return strs[0];
        
        char[] first = strs[0].toCharArray();
        int commonLen = first.length;
        for (int i = 1; i < strs.length; i++)
        	commonLen = Math.min(commonLen, strs[i].length());
        for (int i = 1; i < strs.length; i++) {
        	String cur = strs[i];
        	for (int j = 0; j < commonLen; j++) {
        		if (cur.charAt(j) != first[j]) {
        			commonLen = j;
        			break;
        		}
        	}
        	if (commonLen < 1)
        		return "";
        }
        
        return String.copyValueOf(first, 0, commonLen);
    }

	public static void main(String[] args) {
		String[] strs = {"aa", "a"};
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(strs));
	}

}
