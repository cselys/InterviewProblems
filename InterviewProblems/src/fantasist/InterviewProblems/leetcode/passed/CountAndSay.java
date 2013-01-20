package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class CountAndSay {

    public String countAndSay(int n) {
    	if (n < 1)
    		return "";
    	
    	ArrayList<Character> res = new ArrayList<Character>();
    	res.add('1');
    	while (n > 1) {
    		ArrayList<Character> newSeq = new ArrayList<Character>();
    		int len = res.size();
    		for (int i = 0; i < len; i++) {
    			char cur = res.get(i);
    			int more = i + 1;
    			while (more < len) {
    				if (cur != res.get(more))
    					break;
    				more++;
    			}
    			newSeq.add((char)('0' + (more - i)));   // Here is a problem if the number grows to 10 or above
    			newSeq.add(cur);
    			i = more - 1;
    		}
    		res = newSeq;
    		n--;
    	}
    	
    	char[] str = new char[res.size()];
    	for (int i = 0; i < str.length; i++)
    		str[i] = res.get(i);
    	return new String(str);
    }
    
	public static void main(String[] args) {

	}

}
