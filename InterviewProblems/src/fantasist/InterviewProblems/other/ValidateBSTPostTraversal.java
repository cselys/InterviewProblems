package fantasist.InterviewProblems.other;

public class ValidateBSTPostTraversal {

	private boolean verifyPart(int[] arr, int start, int end, int max, int min) {
		if (start > end)
			return true;
		if (arr[end] <= max && arr[end] >= min) {
			if (start == end)
				return true;
			
			int smaller;
			for (smaller = start; smaller < end; smaller++) {
				if (arr[smaller] > arr[end])
					break;
				else if (arr[smaller] == arr[end] || arr[smaller] < min)
					return false;
			}
			return verifyPart(arr, start, smaller-1, arr[end]-1, min) &&
					verifyPart(arr, smaller, end-1, max, arr[end]+1);
		} else {
			return false;
		}
	}
	
	public boolean verify(int[] arr) {
		if (arr == null || arr.length == 0)
			return false;
		
		return verifyPart(arr, 0, arr.length-1, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public static void main(String[] args) {
		ValidateBSTPostTraversal v = new ValidateBSTPostTraversal();
		int[] a = {2, 4, 6, 8, 7, 5};
		int[] b = {2, 4, 9, 6, 8, 7, 5};
		System.out.println(v.verify(a) ? "true" : "false");
		System.out.println(v.verify(b) ? "true" : "false");
	}

}
