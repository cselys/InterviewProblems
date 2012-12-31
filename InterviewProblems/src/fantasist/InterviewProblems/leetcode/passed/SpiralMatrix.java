package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class SpiralMatrix {
	
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return res;
    	
    	int m = matrix.length, n = matrix[0].length;
    	int max = m * n;
    	int idx = 0;
    	int[] edge = new int[4];
    	int dir = 0;
    	edge[0] = n - 1;
    	edge[1] = m - 1;
    	edge[2] = 0;
    	edge[3] = 1;
    	int x = 0, y = 0;
    	while (idx < max) {
    		switch(dir) {
    		case 0:
    			while (y <= edge[0]) {
    				res.add(matrix[x][y]);
    				idx++;
    				if (y == edge[0]) {
    					edge[0]--;
    					x++;
    					break;
    				}
    				y++;
    			}
    			dir = 1;
    			break;
    		case 1:
    			while (x <= edge[1]) {
    				res.add(matrix[x][y]);
    				idx++;
    				if (x == edge[1]) {
    					edge[1]--;
    					y--;
    					break;
    				}
    				x++;
    			}
    			dir = 2;
    			break;
    		case 2:
    			while (y >= edge[2]) {
    				idx++;
    				res.add(matrix[x][y]);
    				if (y == edge[2]) {
    					edge[2]++;
    					x--;
    					break;
    				}
        			y--;
    			}
    			dir = 3;
    			break;
    		case 3:
    			while (x >= edge[3]) {
    				idx++;
    				res.add(matrix[x][y]);
    				if (x == edge[3]) {
    					edge[3]++;
    					y++;
    					break;
    				}
    				x--;
    			}
    			dir = 0;
    			break;
    		}
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		SpiralMatrix s = new SpiralMatrix();
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
		ArrayList<Integer> res = s.spiralOrder(matrix);
		for (Integer i : res)
			System.out.print(i + " ");
		System.out.println();
	}

}
