package fantasist.InterviewProblems.leetcode.passed;

public class SearchInRotatedSortedArray {
    
	public int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		
		int last = A.length - 1;
		int start = 0, end = last;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (target == A[mid]) {
				return mid;
			} else if (target < A[mid]) {
				if (A[mid] > A[last] && A[0] > target)
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				if (A[0] > A[mid] && A[last] < target)
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		
		return -1;
    }
    
	public static void main(String[] args) {
	
	}

}
