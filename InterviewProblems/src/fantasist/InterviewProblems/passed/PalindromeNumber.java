package fantasist.InterviewProblems.passed;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int num = x, rev = 0;
        while (num > 0) {
        	rev *= 10;
        	rev += num % 10;
        	num /= 10;
        }
        return rev == x;
    }
    
	public static void main(String[] args) {

	}

}
