package fantasist.InterviewProblems.leetcode.passed;

import java.util.HashMap;

public class ValidNumber {
	
    public boolean isNumber(String s) {
    	HashMap<Integer, HashMap<Character, Integer>> transitions = new HashMap<Integer, HashMap<Character, Integer>>();
    	HashMap<Character, Integer> temp = null;
    	temp = new HashMap<Character, Integer>();
    	temp.put('-', 2);
    	temp.put('0', 3);
    	temp.put(' ', 1);
    	temp.put('.', 10);
    	transitions.put(1, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put('0', 3);
    	temp.put('.', 10);
    	transitions.put(2, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put('e', 6);
    	temp.put('.', 4);
    	temp.put('0', 3);
    	temp.put(' ', 9);
    	transitions.put(3, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put('0', 5);
    	temp.put(' ', 9);
    	temp.put('e', 6);
    	transitions.put(4, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put('0', 5);
    	temp.put('e', 6);
    	temp.put(' ', 9);
    	transitions.put(5, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put('0', 8);
    	temp.put('-', 7);
    	transitions.put(6, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put('0', 8);
    	transitions.put(7, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put('0', 8);
    	temp.put(' ', 9);
    	transitions.put(8, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put(' ', 9);
    	transitions.put(9, temp);
    	
    	temp = new HashMap<Character, Integer>();
    	temp.put('0', 11);
    	transitions.put(10, temp);

    	temp = new HashMap<Character, Integer>();
    	temp.put('0', 11);
    	temp.put('e', 6);
    	temp.put(' ', 9);
    	transitions.put(11, temp);
    	
    	int state = 1;
    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		HashMap<Character, Integer> validTransitions = transitions.get(state);
    		if (ch >= '0' && ch <= '9') {
    			if (validTransitions.containsKey(Character.valueOf('0')))
    				state = validTransitions.get(Character.valueOf('0'));
    			else
    				return false;
    		} else if (ch == '-' || ch == '+') {
    			if (validTransitions.containsKey(Character.valueOf('-')))
    				state = validTransitions.get(Character.valueOf('-'));
    			else
    				return false;
    		}else if (validTransitions.containsKey(Character.valueOf(ch)))
    			state = validTransitions.get(Character.valueOf(ch));
    		else
    			return false;
    	}
    	
    	if (state == 3 || state == 8 || state == 5 || state == 9 || state == 4 || state == 11)
    		return true;
    	else
    		return false;
    }
    
	public static void main(String[] args) {
		ValidNumber v = new ValidNumber();
		
		// True cases
		System.out.println(v.isNumber("0"));
		System.out.println(v.isNumber("0.1"));
		System.out.println(v.isNumber("-2"));
		System.out.println(v.isNumber("  +12345.6789  "));
		System.out.println(v.isNumber("  12345e5  "));
		System.out.println(v.isNumber(".2e81"));
		
		// False cases
		System.out.println(v.isNumber("  12 345e5  "));
		System.out.println(v.isNumber("  1a345e5  "));
		System.out.println(v.isNumber("  123e45e5  "));
		System.out.println(v.isNumber("  .1.5  "));
		System.out.println(v.isNumber("  -12345-5  "));
	}

}
