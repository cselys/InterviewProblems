package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1)
        	return 0;
        
        int min = Integer.MAX_VALUE;
        int[][] buff = new int[2][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
        	ArrayList<Integer> row = triangle.get(i);
        	if (i == 0)
        		buff[1][0] = row.get(0);
        	else {
        		for (int j = 0; j <= i; j++) {
        			if (j == 0)
        				buff[1][j] = buff[0][j] + row.get(j);
        			else if (j == i)
        				buff[1][j] = buff[0][j-1] + row.get(j);
        			else
        				buff[1][j] = Math.min(buff[0][j-1], buff[0][j]) + row.get(j);
        		}
        	}
        	
        	int[] b0 = buff[0];
        	buff[0] = buff[1];
        	buff[1] = b0;
        }
        
        for (int i = 0; i < triangle.size(); i++)
        	min = Math.min(min, buff[0][i]);
        
        return min;
    }
    
	public static void main(String[] args) {
		
	}

}
