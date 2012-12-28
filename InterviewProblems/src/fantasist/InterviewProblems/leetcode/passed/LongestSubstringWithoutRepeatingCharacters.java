package fantasist.InterviewProblems.leetcode.passed;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, len = 0, start = 0;
        boolean[] hashTable = new boolean[128]; 
        for (int i = 0; i < s.length(); i++) {
        	if (hashTable[(int)s.charAt(i)] == false) {
        		len++;
        		if (len > maxLen)
        			maxLen = len;
        	} else {
    			char t = s.charAt(i);
        		while (true) {
        			char c = s.charAt(start);
    				hashTable[(int)c] = false;
        			if (c != t) {
        				start++;
        			} else {
        				start++;
        				break;
        			}
        		}
        		len = i - start + 1;
        	}
    		hashTable[(int)s.charAt(i)] = true;
        }
        
        return maxLen;
    }
    
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(l.lengthOfLongestSubstring("aabcadefgaa"));
		System.out.println(l.lengthOfLongestSubstring("bbbbb"));
	}

}
