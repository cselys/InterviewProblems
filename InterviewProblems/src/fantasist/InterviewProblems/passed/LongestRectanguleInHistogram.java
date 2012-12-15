package fantasist.InterviewProblems.passed;

import java.util.Stack;

public class LongestRectanguleInHistogram {
    
    public int largestRectangleArea(int[] height) {    	
        int maxarea = 0;
        int len = height.length;
        Stack<Integer> heights = new Stack<Integer>();
        Stack<Integer> indices = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
        	int val = height[i];
        	if (heights.empty() || val > heights.peek()) {
        		heights.push(val);
        		indices.push(i);
        	} else if (heights.peek() > val) {
        		int prev = 0;
        		while (!heights.empty() && heights.peek() > val) {
        			prev = indices.peek();
        			int area = heights.pop().intValue() * (i - indices.pop().intValue());
            		maxarea = Math.max(maxarea, area);
        		}
        		heights.push(val);
        		indices.push(prev);
        	}
        }
    	while (!heights.empty()) {
    		int area = (len - indices.pop().intValue()) * heights.pop().intValue();
    		maxarea = Math.max(maxarea, area);
    	}
        
        return maxarea;
    }

    public int largestRectangleAreaBF(int[] height) {
        int area;
        int maxarea = 0;

        for (int i = 0; i < height.length; i++) {
        	if (i > 0 && height[i] == height[i-1])
        		continue;
        	area = height[i];
        	// Expand to left
        	for (int j = i - 1; j >= 0; j--) {
        		if (height[j] >= height[i])
        			area += height[i];
        		else
        			break;
        	}
        	for (int j = i + 1; j < height.length; j++) {
        		if (height[j] >= height[i])
        			area += height[i];
        		else
        			break;
        	}
        	if (area > maxarea)
        		maxarea = area;
        }
        return maxarea;
    }
    
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
//		int[] a = {2, 1, 5, 6, 2, 3};
//		int[] a = {5, 4, 1, 2};
		LongestRectanguleInHistogram l = new LongestRectanguleInHistogram();
		System.out.println(l.largestRectangleArea(a));
	}

}
