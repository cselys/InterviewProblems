package fantasist.InterviewProblems.leetcode.passed;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null)
    		return false;
    	int rows = matrix.length, cols = matrix[0].length;
    	if (rows == 0 || cols == 0)
    		return false;
        int start = 0, end = rows - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
        	if (matrix[mid][0] > target) {
        		end = mid - 1;
        	} else if (matrix[mid][0] < target) {
        		if (target > matrix[mid][cols - 1])
        			start = mid + 1;
        		else {
        			start = mid;
        			break;
        		}
        	} else {
        		return true;
        	}
        }
        if (start >= rows)
        	return false;
        int row = start;
        start = 0;
        end = cols - 1;
        while(start <= end) {
        	int mid = (start + end) / 2;
        	if (matrix[row][mid] > target) {
        		end = mid - 1;
        	} else if (matrix[row][mid] < target) {
        		start = mid + 1;
        	} else
        		return true;
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		Search2DMatrix s = new Search2DMatrix();
//		int[][] matrix = {
//				{1, 3, 5, 7},
//				{10, 11, 16, 20},
//				{23, 30, 34, 50}};
		int[][] matrix = {{1}, {3}};
		int target = 2;
		
		System.out.println(s.searchMatrix(matrix, target) == true ? "True" : "False");
	}

}
