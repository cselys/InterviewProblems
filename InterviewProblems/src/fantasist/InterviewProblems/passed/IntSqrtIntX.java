package fantasist.InterviewProblems.passed;

public class IntSqrtIntX {
    public int sqrt(int x) {
        if (x <= 0)
            return 0;
        if (x == 1)
            return 1;
        int lower = 0;
        int upper = x / 2;
        int num = upper;
        while(lower < upper) {
            if (x / num < num) {
                upper = num;
                num = (upper + lower) / 2;
            } else {
                if (x / (num+1) < num + 1)
                    return num;
                lower = num;
                num = (upper + lower) / 2;
            }
        }
        return num;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
