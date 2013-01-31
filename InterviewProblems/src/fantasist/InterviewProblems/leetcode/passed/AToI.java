package fantasist.InterviewProblems.leetcode.passed;

public class AToI {

    public int atoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        else if (str.equals(Integer.toString(Integer.MAX_VALUE)))
            return Integer.MAX_VALUE;
        else if (str.equals(Integer.toString(Integer.MIN_VALUE)))
            return Integer.MIN_VALUE;
        
        int start = 0;
        boolean neg = false;
        int num = 0;
        while (start < str.length()) {
            char c = str.charAt(start);
            if (c == ' ')
                start++;
            else if (c == '-' || c == '+')
                break;
            else if (c >= '0' && c <= '9')
                break;
            else
                return 0;
        }
        if (str.charAt(start) == '-') {
            neg = true;
            start++;
        } else if (str.charAt(start) == '+') {
            neg = false;
            start++;
        }
        
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9')
                return neg ? -num : num;
            int pre = num;
            num *= 10;
            num += c - '0';
            if (Math.abs(num / 10 - pre) > 9)
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        return neg ? -num : num;
    }
    
    public static void main(String[] args) {
        AToI a = new AToI();
        System.out.println(a.atoi("         +10523538441s"));
    }

}
