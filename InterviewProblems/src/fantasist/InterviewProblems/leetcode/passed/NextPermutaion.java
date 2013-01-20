package fantasist.InterviewProblems.leetcode.passed;

public class NextPermutaion {

	private void reverse(int[] num, int start, int end) {
		for (int i = 0; i <= (end - start) / 2; i++) {
			int temp = num[i + start];
			num[i + start] = num[end - i];
			num[end - i] = temp;
		}
	}
	
	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1)
        	return;
        
        int len = num.length;
        int smaller = len - 2;
        while (smaller >= 0) {
        	if (num[smaller] < num[smaller+1])
        		break;
        	smaller--;
        }
        if (smaller < 0)
        	reverse(num, 0, num.length-1);
        else {
        	int larger = len - 1;
        	while (true) {
        		if (num[larger] > num[smaller])
        			break;
        		larger--;
        	}
        	swap(num, smaller, larger);
        	reverse(num, smaller+1, num.length-1);
        }
    }
    
	public static void main(String[] args) {
		NextPermutaion np = new NextPermutaion();
		int[] num = {2, 3, 1};
		np.nextPermutation(num);
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");
	}

}
