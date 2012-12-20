package fantasist.InterviewProblems.leetcode.passed;

public class SortColors {
    
	private void swap(int[] A, int i, int j) {
		int x = A[i];
		A[i] = A[j];
		A[j] = x;
	}
	
	public void sortColors(int[] A) {
        if (A == null || A.length < 2)
        	return;
        
        int idx0 = 0, idx1 = 0, idx2 = A.length - 1;
        while(idx1 <= idx2) {
        	switch(A[idx1]) {
        	case 0:
        		swap(A, idx0, idx1);
        		idx0++;
        		idx1++;
        		break;
        	case 1:
        		idx1++;
        		break;
        	case 2:
        		swap(A, idx1, idx2);
        		idx2--;
        		break;
    		default:
    			System.out.println("Invalid color!");
    			break;
        	}
        }
    }
    
	public static void main(String[] args) {
		SortColors sc = new SortColors();
		
//		int[] A = {1, 0, 2, 2, 2, 1, 0, 1};
		int[] A = {1, 0};
		sc.sortColors(A);
		
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

}
