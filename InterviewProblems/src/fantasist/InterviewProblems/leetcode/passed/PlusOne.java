package fantasist.InterviewProblems.leetcode.passed;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        if (digits == null || digits.length == 0) {
        	int[] result = new int[1];
        	result[0] = 1;
        	return result;
        } else {
        	digits[digits.length - 1] += 1;
        	for (int i = digits.length - 1; i >= 0; i--) {
        		digits[i] += carry;
        		if (digits[i] >= 10) {
        			digits[i] -= 10;
        			carry = 1;
        		} else {
        			carry = 0;
        		}
        	}
        	if (carry == 0) {
        		return digits;
        	} else {
        		int[] result = new int[digits.length + 1];
        		result[0] = 1;
        		for (int i = 1; i < result.length; i++) {
        			result[i] = digits[i - 1];
        		}
        		
        		return result;
        	}
        }
    }

	public static void main(String[] args) {
		int[] digits = {1, 2, 3, 4, 5};
//		int[] digits = {9, 9};
		
		PlusOne po = new PlusOne();
		int[] result = po.plusOne(digits);
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}

}
