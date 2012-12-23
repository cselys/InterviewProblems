package fantasist.InterviewProblems.leetcode.passed;

import java.util.Stack;

public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		if (s == null || s.isEmpty())
			return 0;
		
		char[] arr = s.toCharArray();
		Stack<Integer> idx = new Stack<Integer>();
		Stack<Integer> lastEnds = new Stack<Integer>();
		Stack<Integer> lastLens = new Stack<Integer>();
		int maxLen = 0;
		lastEnds.push(0);
		lastLens.push(0);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				idx.push(i);
			}
			else {
				if (!idx.empty()) {
					int first = idx.pop();
					int len = i - first + 1;
					while (true) {
						int lastEnd = lastEnds.peek();
						int lastLen = lastLens.peek();
						if (lastEnd > 0) {
							if (lastEnd > first) {
								lastEnds.pop();
								lastLens.pop();
							} else if (lastEnd == first - 1) {
								len += lastLen;
								lastEnds.pop();
								lastLens.pop();
							} else {
								break;
							}
						} else {
							break;
						}
					}
					lastEnds.push(i);
					lastLens.push(len);
					if (len > maxLen) {
						maxLen = len;
					}
				}
			}
		}
		
		return maxLen;
	}
	
    public int longestValidParentheses_naive(String s) {
    	if (s == null || s.length() == 0)
    		return 0;
        char[] arr = s.toCharArray();
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == ')')
        		continue;
        	else {
        		int count = 1;
        		for (int j = i + 1; j < arr.length; j++) {
        			if (arr[j] == '(') {
        				count++;
        			} else {
        				count--;
        				if (count < 0)
        					break;
        				else if (count == 0) {
        					int newLen = j - i + 1;
        					if (newLen > len)
        						len = newLen;
        				}
        			}
        		}
        	}
        }
        return len;
    }
    
	public static void main(String[] args) {
		LongestValidParentheses l = new LongestValidParentheses();
//		System.out.println(l.longestValidParentheses(")()())"));
//		System.out.println(l.longestValidParentheses("(()"));
		System.out.println(l.longestValidParentheses("()(())"));
	}

}
