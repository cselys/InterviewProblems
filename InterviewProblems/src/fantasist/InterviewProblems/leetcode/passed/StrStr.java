package fantasist.InterviewProblems.leetcode.passed;

public class StrStr {

    // Brute force solution with O(n^2) complexity
    public String strStr(String haystack, String needle) {
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
		String haystack = "abcbca", needle = "cba";
		
		StrStr strstr = new StrStr();
		System.out.println(strstr.strStr(haystack, needle));
	}

}
