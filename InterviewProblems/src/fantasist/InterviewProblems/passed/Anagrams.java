package fantasist.InterviewProblems.passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

    public ArrayList<String> anagrams(String[] strs) {
    	ArrayList<String> result = new ArrayList<String>();
    	
    	String[] sorted= new String[strs.length];
    	for (int i = 0; i < strs.length; i++) {
    		char[] char_array = strs[i].toCharArray();
    		Arrays.sort(char_array);
    		sorted[i] = new String(char_array);
    	}
    	
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	HashMap<String, Integer> starts = new HashMap<String, Integer>();
    	for (int i = 0; i < strs.length; i++) {
    		if (map.containsKey(sorted[i])) {
    			result.add(strs[i]);
    			if (!starts.containsKey(sorted[i]))
    				starts.put(sorted[i], map.get(sorted[i]));
    		} else {
    			map.put(sorted[i], i);
    		}
    	}
    	for (Integer idx : starts.values()) {
    		result.add(strs[idx]);
    	}
    	
        return result;
    }
    
	public static void main(String[] args) {
		String[] strs = {"tea","and","ace","ad","eat","dans"};
		
		Anagrams a = new Anagrams();
		ArrayList<String> ans = a.anagrams(strs);
		
		for (String str : ans) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

}
