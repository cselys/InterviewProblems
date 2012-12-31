package fantasist.InterviewProblems.leetcode.passed;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
    	if (n < 1)
    		return new int[0][0];
    	int[][] matrix = new int[n][n];
    	
        int cur = 1;
        int[] edge = new int[4];
        edge[0] = n - 1;
        edge[1] = n - 1;
        edge[2] = 0;
        edge[3] = 1;
        int dir = 0;
        int max = n * n;
        int x = 0, y = 0;
        while (cur <= max) {
        	switch (dir) {
        	case 0:
        		while (y <= edge[0]) {
        			matrix[x][y] = cur;
        			cur++;
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
        			matrix[x][y] = cur;
        			cur++;
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
        			matrix[x][y] = cur;
        			cur++;
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
        			matrix[x][y] = cur;
        			cur++;
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
        
        return matrix;
    }
    
	public static void main(String[] args) {
		SpiralMatrixII s = new SpiralMatrixII();
		int n = 4;
		int[][] matrix = s.generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
