package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Arrays;

public class TextJustification {

    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> ans = new ArrayList<String>();
        if (words == null || words.length < 1)
        	return ans;
        int start = 0, idx = -1;
        while (idx < words.length - 1) {
        	start = idx + 1;
        	int pos = words[start].length();
        	idx = start;
        	for (int i = start + 1; i < words.length; i++) {
        		if (pos + words[i].length() + 1 <= L) {
        			idx++;
        			pos = pos + words[i].length() + 1;
        		} else
        			break;
        	}
        	if (idx == start) {
        		char[] line = Arrays.copyOf(words[idx].toCharArray(), L);
        		while (pos < L)
        			line[pos++] = ' ';
        		ans.add(new String(line));
        	} else if (idx == words.length - 1) {
        		char[] line = Arrays.copyOf(words[start].toCharArray(), L);
        		pos = words[start].length();
        		while (++start <= idx) {
        			line[pos++] = ' ';
        			for (int i = 0; i < words[start].length(); i++) {
        				line[pos++] = words[start].charAt(i);
        			}
        		}
        		while (pos < L)
        			line[pos++] = ' ';
        		ans.add(new String(line));
        	} else {
        		int spaces = L - pos;
            	int fillEach = spaces / (idx - start);
            	int fillCount = spaces - (idx - start) * fillEach;
            	char[] line = Arrays.copyOf(words[start].toCharArray(), L);
            	pos = words[start].length();
            	while (++start <= idx) {
            		if (fillCount > 0) {
            			for (int i = 0; i < fillEach + 2; i++)
            				line[pos++] = ' ';
        				fillCount--;
            		} else {
            			for (int i = 0; i < fillEach + 1; i++)
            				line[pos++] = ' ';
            		}
            		for (int i = 0; i < words[start].length(); i++)
            			line[pos++] = words[start].charAt(i);
            	}
            	ans.add(new String(line));
        	}
    		if (idx == words.length - 1)
    			break;
        }
        
        return ans;
    }
    
	public static void main(String[] args) {
//		String[] sample = {"This"};
//		String[] sample = {"This", "is", "an", "example", "of", "text", "justification."};
//		String[] sample = {"a","b","c","d","e"};
		String[] sample = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
		TextJustification tj = new TextJustification();
		ArrayList<String> ans = tj.fullJustify(sample, 30);
		for (String line : ans)
			System.out.println(line + " Length: " + line.length());
	}

}
