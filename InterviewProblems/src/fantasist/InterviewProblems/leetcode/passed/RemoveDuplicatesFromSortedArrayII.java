package fantasist.InterviewProblems.leetcode.passed;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] A) {
        if (A == null || A.length < 1)
        	return 0;
        if (A.length == 1)
        	return 1;
        
        int pos = 1;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] == A[i-1]) {
        		if (count > 1)
        			continue;
        		else {
        			A[pos++] = A[i];
        			count++;
        		}
        	} else {
        		A[pos++] = A[i];
        		count = 1;
        	}
        }
        return pos;
    }
    
	public static void main(String[] args) {

	}

}
