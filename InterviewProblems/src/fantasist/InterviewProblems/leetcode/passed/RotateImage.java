package fantasist.InterviewProblems.leetcode.passed;

public class RotateImage {

    public void rotate(int[][] matrix) {
    	int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
        	for (int j = i; j < n - i - 1; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[n-j-1][i];
        		matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
        		matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
        		matrix[j][n-i-1] = temp;
        	}
        }
    }
    
	public static void main(String[] args) {
		RotateImage r = new RotateImage();
		
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}};
		
		r.rotate(matrix);
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) 
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

}
