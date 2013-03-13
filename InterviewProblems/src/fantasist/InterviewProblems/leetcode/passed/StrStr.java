package fantasist.InterviewProblems.leetcode.passed;

public class StrStr {

	// KMP solution
	private int[] calcPreArray(String str) {
		char[] s = str.toCharArray();
		int[] ret = new int[s.length];
		ret[0] = -1;
		int last = -1;
		for (int i = 1; i < s.length; i++) {
			ret[i] = -1;
			if (s[i] == s[last + 1])
				ret[i] = ++last;
			else if (last > 0 && ret[last] != -1) {
				last = ret[last];
				i--;
			} else
				last = -1;
		}
		
		return ret;
	}
	
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return null;
		if (haystack.length() < needle.length())
			return null;
		else if (needle.length() == 0)
			return haystack;
		
		int[] pre = calcPreArray(needle);
		int cur = -1;
		for (int i = 0; i < haystack.length(); i++) {
			if (needle.charAt(cur + 1) == haystack.charAt(i))
				cur++;
			else if (cur > 0 && pre[cur] >= 0) {
				cur = pre[cur];
				i--;
			} else {
				if (cur >= 0)
					i--;
				cur = -1;
			}
			if (cur == needle.length() - 1)
				return haystack.substring(i - needle.length() + 1);
		}
		return null;
	}
	
    // Brute force solution with O(n^2) complexity
    public String strStr_BF(String haystack, String needle) {
    	if (haystack == null || needle == null)
    		return null;
        char[] h = haystack.toCharArray(), n = needle.toCharArray();
        if (h.length < n.length)
        	return null;
        if (n.length == 0)
        	return haystack;
        
        for (int i = 0; i + n.length <= h.length; i++) {
        	for (int j = 0; j < n.length; j++) {
        		if (n[j] != h[i + j])
        			break;
        		if (j == n.length - 1)
        			return haystack.substring(i); 
        	}
        }
        
        return null;
    }
    
	public static void main(String[] args) {
//		String haystack = "abcbca", needle = "cb";
		String haystack = "abcbca", needle = "bca";
//		String haystack = "a", needle = "a";
		
		StrStr strstr = new StrStr();
		System.out.println(strstr.strStr(haystack, needle));
	}

}
