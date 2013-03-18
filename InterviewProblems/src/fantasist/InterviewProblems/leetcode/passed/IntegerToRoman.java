package fantasist.InterviewProblems.leetcode.passed;

public class IntegerToRoman {

	String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	int[] NUMS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String intToRoman(int num) {
    	if (num <= 0)
    		return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROMANS.length; i++) {
        	int repeat = num / NUMS[i];
        	while (repeat-- > 0)
        		sb.append(ROMANS[i]);
        	num = num % NUMS[i];
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		IntegerToRoman i = new IntegerToRoman();
		System.out.println("3490");
	}

}
