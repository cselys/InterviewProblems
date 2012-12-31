package fantasist.InterviewProblems.leetcode.passed;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
    	long dividendL = (long)dividend;
    	long divisorL = (long)divisor;
    	if (dividendL == 0)
    		return 0;
    	if (divisorL == 0)
    		return 0;
    	if (dividendL == divisorL)
    		return 1;
        long result = 0;
        boolean flag = (dividendL < 0 && divisorL > 0) || (dividendL > 0 && divisorL < 0);
        if (dividendL < 0)
        	dividendL = -dividendL;
        if (divisorL < 0)
        	divisorL = -divisorL;
        long temp = divisorL;
        while(temp << 1 <= dividendL && temp << 1 > 0)
        	temp <<= 1;
        while (temp >= divisorL) {
        	result <<= 1;
        	if (dividendL >= temp) {
	        	result += 1;
	        	dividendL -= temp;
        	}
        	temp >>= 1;
        }
        
        return flag ? (int)-result : (int)result;
    }
    
	public static void main(String[] args) {
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(-964839008, -2098244146));
	}

}
