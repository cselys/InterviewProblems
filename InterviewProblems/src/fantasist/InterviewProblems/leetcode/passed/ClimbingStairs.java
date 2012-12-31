package fantasist.InterviewProblems.leetcode.passed;

public class ClimbingStairs {

    public int climbStairs(int n) {
    	if (n < 1)
    		return 0;
    	if (n == 1)
    		return 1;
    	if (n == 2)
    		return 2;
        int ways = 0;
        int pre1 = 2, pre2 = 1;
        while (n-- >= 3) {
        	ways = pre1 + pre2;
        	pre2 = pre1;
        	pre1 = ways;
        }
        return ways;
    }
    
	public static void main(String[] args) {
		
	}

}
