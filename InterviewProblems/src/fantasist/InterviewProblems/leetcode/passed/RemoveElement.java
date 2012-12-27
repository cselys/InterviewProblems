package fantasist.InterviewProblems.leetcode.passed;

public class RemoveElement {

    public int removeElement(int[] A, int elem) {
    	if (A == null || A.length == 0)
    		return 0;
        int len = 0;
        int i = 0;
        while (i < A.length) {
        	while (A[i] == elem) {
        		i++;
        		if (i >= A.length)
        			return len;
        	}
        	int temp = A[len];
        	A[len++] = A[i];
        	A[i++] = temp;
        }
        
        return len;
    }
    
	public static void main(String[] args) {
//		int[] A = {1, 3, 2, 5, 4};
		int[] A = {1};
		int elem = 1;
		RemoveElement re = new RemoveElement();
		int newLen = re.removeElement(A, elem);
		for (int i = 0; i < newLen; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

}
