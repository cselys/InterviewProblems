package fantasist.InterviewProblems.other;

public class MinSwaps {

	public int minSwap(int[] array) {
		if (array == null || array.length < 2)
			return 0;
		
		int minSwap = 0;
		int target = 1, index = 0;
		while (index < array.length) {
			if (array[index] == target) {
				index++;
				target++;
			} else {
				minSwap++;
				index++;
			}
		}
		
		return minSwap;
	}
	
	public static void main(String[] args) {
		MinSwaps m = new MinSwaps();
		
		int[] array = {3, 1, 2, 4};
//		int[] array = {4, 3, 2, 1};
//		int[] array = {4, 1, 2, 3};
//		int[] array = {2, 3, 4, 1};
		System.out.println(m.minSwap(array));
	}

}
