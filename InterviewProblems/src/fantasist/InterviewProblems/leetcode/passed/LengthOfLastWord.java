package fantasist.InterviewProblems.leetcode.passed;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		if (s == null)
			return 0;
		
		int count = 0;
		for (int i = s.length() - 1; i >= 0; --i) {
			if (s.charAt(i) == ' ') {
				if (count > 0)
					return count;
			} else {
				++count;
			}
		}
		return count;
	}
	
    public int lengthOfLastWord_idiot(String s) {
        if (s == null || s.length() < 1)
        	return 0;
    	int len = 0;
    	int count = 0;;
    	char[] arr = s.toCharArray();
    	for (int i = 0; i < s.length(); i++) {
    		if (arr[i] == ' ') {
    			if (count > 0) {
    				len = count;
    				count = 0;
    			}
    		} else {
    			count++;
    		}
    	}
        if (count > 0)
        	return count;
        else
        	return len;
    }
    
	public static void main(String[] args) {
		LengthOfLastWord l = new LengthOfLastWord();
		
		System.out.println(l.lengthOfLastWord("Hello Worrld"));
	}

}
