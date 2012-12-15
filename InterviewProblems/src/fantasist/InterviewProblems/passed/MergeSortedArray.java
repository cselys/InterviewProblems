package fantasist.InterviewProblems.passed;

public class MergeSortedArray {
    
	public void merge(int A[], int m, int B[], int n) {
		m--;
		n--;
        for (int i = A.length - 1; i >= 0; i--) {
        	if (m >= 0 && n >= 0) {
        		if (A[m] > B[n]) {
        			A[i] = A[m--];
        		} else {
        			A[i] = B[n--];
        		}
        	} else if (m >= 0) {
        		A[i] = A[m--];
        	} else {
        		A[i] = B[n--];
        	}
        }
    }
    
	public static void main(String[] args) {
		int[] A = new int[10];
		for (int i = 1; i <= 5; i++) {
			A[i-1] = i * 3;
		}
		int[] B = {2, 5, 7, 10, 11};
		
		MergeSortedArray msa = new MergeSortedArray();
		msa.merge(A, 5, B, 5);
		
		for (int i = 0; i < 10; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

}
