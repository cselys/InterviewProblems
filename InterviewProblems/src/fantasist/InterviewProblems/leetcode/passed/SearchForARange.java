package fantasist.InterviewProblems.leetcode.passed;

public class SearchForARange {

    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
    	res[0] = -1;
    	res[1] = -1;
        if (A == null || A.length == 0) {
        	return res;
        }
        
        int start = 0, end = A.length - 1;
        int mid;
        // Search left end
        while (start <= end) {
        	mid = (start + end) / 2;
        	if (A[mid] == target) {
        		res[0] = mid;
        		end = mid - 1;
        	} else if (target < A[mid]) {
        		end = mid - 1;
        	} else {
        		start = mid + 1;
        	}
        }
        start = 0;
        end = A.length - 1;
        // Search right end
        while (start <= end) {
        	mid = (start + end) / 2;
        	if (A[mid] == target) {
        		res[1] = mid;
        		start = mid + 1;
        	} else if (target < A[mid]) {
        		end = mid - 1;
        	} else {
        		start = mid + 1;
        	}
        }
        
        return res;
    }
    
	public static void main(String[] args) {
	}

}
