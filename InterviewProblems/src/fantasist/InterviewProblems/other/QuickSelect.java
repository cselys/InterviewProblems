package fantasist.InterviewProblems.other;

import java.util.Arrays;

public class QuickSelect {

	private int swapCount;
	public int getSwapCount() {
		return swapCount;
	}
	
	private void swap(int[] A, int i, int j) {
		swapCount++;
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private int select(int[] A, int k, int start, int end) {
		int last = end, i = 0;
		while (i < last) {
			if (A[i] > A[end]) {
				last--;
				swap(A, i, last);
			} else
				i++;
		}
		swap(A, last, end);
		if (last - start == k - 1)
			return A[last];
		else if (last - start > k - 1)
			return select(A, k, start, last - 1);
		else
			return select(A, k - 1 - (last - start), last + 1, end);
	}
	
	public int select(int[] A, int k) {
		swapCount = 0;
		if (A == null || A.length < k || k <= 0)
			return -1;
		
		return select(A, k, 0, A.length - 1);
	}
	
	public static void main(String[] args) {
		QuickSelect qs = new QuickSelect();
		int[] A = {2, 5, 3, 4, 6, 1};
		for (int k = 1; k <= A.length; k++) {
			int[] B = Arrays.copyOf(A, A.length);
			int ans = qs.select(B, k);
			System.out.println("Found the " + k + "th small number " + ans + " in " + qs.getSwapCount() + " swaps");
		}
	}

}
