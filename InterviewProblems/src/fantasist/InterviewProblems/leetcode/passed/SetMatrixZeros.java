package fantasist.InterviewProblems.leetcode.passed;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return;
        
        int rownum = matrix.length;
        int colnum = matrix[0].length;
        boolean[] toSetZero = new boolean[rownum + colnum];
        
        for (int i = 0; i < rownum; i++) {
        	for (int j = 0; j < colnum; j++) {
        		if (matrix[i][j] == 0) {
        			toSetZero[i] = true;
        			toSetZero[rownum + j] = true;
        		}
        	}
        }
        for (int i = 0; i < rownum; i++) {
        	if (toSetZero[i]) {
        		for (int j = 0; j < colnum; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        for (int j = 0; j < colnum; j++) {
        	if (toSetZero[rownum + j]) {
        		for (int i = 0; i < rownum; i++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
    
	public static void main(String[] args) {
	}

}
