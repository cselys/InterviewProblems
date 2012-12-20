package fantasist.InterviewProblems.leetcode.passed;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
    	if (A == null || A.length == 0)
    		return 1;
    	int len = A.length;
        for (int i = 0; i < len; i++) {
        	int num = A[i];
        	if (num > 0 && num <= len) {
        		A[i] = A[num-1];
        		A[num-1] = num;
        		if (num-1 != i && A[i] != num)
        			i--;
        	}
        	else
        		A[i] = -1;
        }
        for (int i = 0; i < len; i++) {
        	if (A[i] != i + 1)
        		return i + 1;
        }
        
        return len + 1;
    }
    
	public static void main(String[] args) {
//		int[] A = {1, 2, 0, -1};
//		int[] A = {2};
//		int[] A = {1};
		int[] A = {1, 1};
		
		FirstMissingPositive f = new FirstMissingPositive();
		System.out.println(f.firstMissingPositive(A));
	}

}
