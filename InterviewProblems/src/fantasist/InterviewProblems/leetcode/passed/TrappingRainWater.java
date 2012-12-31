package fantasist.InterviewProblems.leetcode.passed;

public class TrappingRainWater {

    public int trap(int[] A) {
        if (A == null || A.length < 3)
        	return 0;
        int top = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] > A[top])
        		top = i;
        }
        
        int water = 0;
        int cur = 0;
        for (int i = 0; i < top; i++) {
        	if (i == 0)
        		cur = A[i];
        	else {
        		if (A[i] >= cur)
        			cur = A[i];
        		else
        			water += cur - A[i];
        	}
        }
        for (int i = A.length - 1; i > top; i--) {
        	if (i == A.length - 1)
        		cur = A[i];
        	else {
        		if (A[i] >= cur)
        			cur = A[i];
        		else
        			water += cur - A[i];
        	}
        }
        return water;
    }
    
	public static void main(String[] args) {
		TrappingRainWater t = new TrappingRainWater();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(t.trap(A));
	}

}
