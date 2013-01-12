package fantasist.InterviewProblems.leetcode.passed;

public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0)
        	return 0;
        
        int start = 0, end = A.length - 1;
        if (target < A[start])
        	return 0;
        if (target > A[end])
        	return end + 1;
        
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == A[mid])
            	return mid;
            else if (target < A[mid]) {
            	if (mid > 0 && target > A[mid-1])
            		return mid;
            	end = mid;
            } else {
            	if (mid < A.length - 1 && target <= A[mid+1])
            		return mid + 1;
            	start = mid + 1;
            }
        }
        
        return mid;
    }
    
	public static void main(String[] args) {
		SearchInsertPosition s = new SearchInsertPosition();
		int[] arr = {1, 3, 5};
		System.out.println(s.searchInsert(arr, 2));
	}

}
