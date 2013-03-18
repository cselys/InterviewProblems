package fantasist.InterviewProblems.leetcode.passed;

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
    	if (s == null || s.length() < 1)
    		return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int pre = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
        	int cur = map.get(s.charAt(i));
        	ans += cur;
        	if (cur > pre)
        		ans -= pre * 2;
        	pre = cur;
        }
        return ans;
    }
    
	public static void main(String[] args) {
		RomanToInteger r = new RomanToInteger();
		System.out.println(r.romanToInt("XXIV"));
	}

}
