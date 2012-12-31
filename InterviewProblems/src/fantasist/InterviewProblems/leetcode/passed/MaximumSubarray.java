package fantasist.InterviewProblems.leetcode.passed;

public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
        	return 0;
        
        int max = Integer.MIN_VALUE;
        int[] buff = new int[A.length];
        for (int i = 0; i < A.length; i++) {
        	buff[i] = Math.max(A[i], A[i] + (i > 0 ? buff[i-1] : 0));
        	max = Math.max(buff[i], max);
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		MaximumSubarray m = new MaximumSubarray();
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(m.maxSubArray(A));
	}

}
