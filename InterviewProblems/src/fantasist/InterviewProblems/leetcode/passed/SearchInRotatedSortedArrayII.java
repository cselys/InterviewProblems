package fantasist.InterviewProblems.leetcode.passed;

public class SearchInRotatedSortedArrayII {

	private boolean search_helper(int[] A, int start, int end, int target) {
		if (start > end)
			return false;
		
		if (start == end)
			return A[start] == target;
		
		int mid = (start + end) / 2;
		if (A[mid] == target)
			return true;
		else if (target < A[mid]) {
			boolean right = false;
			if (A[mid] >= A[end])
				right = search_helper(A, mid+1, end, target);
			return right || search_helper(A, start, mid-1, target);
		} else {
			boolean left = false;
			if (A[start] >= A[mid])
				left = search_helper(A, start, mid-1, target);
			return left || search_helper(A, mid+1, end, target);
		}
	}
	
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0)
			return false;
		
		return search_helper(A, 0, A.length-1, target);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
