package fantasist.InterviewProblems.leetcode.passed;

import java.util.Arrays;

public class MultiplyStrings {

    private void reverse(char[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[size-i-1];
            arr[size-i-1] = temp;
        }
    }
    
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "0";
        
        int len1 = num1.length(), len2 = num2.length();
        int len = 0;
        char[] res = new char[len1 + len2];
        Arrays.fill(res, '0');
        
        char[] num1str = num1.toCharArray();
        reverse(num1str, len1);
        char[] num2str = num2.toCharArray();
        reverse(num2str, len2);
        
        int carry = 0;
        for (int i = 0; i < len1; i++) {
            carry = 0;
            for (int j = 0; j < len2 || carry > 0; j++) {
                int n1 = num1str[i] - '0';
                int n2 = j < len2 ? (num2str[j] - '0') : 0;
                int r = res[i+j] - '0';
                r += n1 * n2 + carry;
                carry = r / 10;
                r %= 10;
                res[i+j] = (char) ('0' + r);
            }
        }
        
        for (len = len1+len2-1; len >= 1; len--)
            if (res[len] != '0') break;
        reverse(res, len+1);
        return new String(res, 0, len+1);
    }
    
    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply("123", "456"));
    }

}
