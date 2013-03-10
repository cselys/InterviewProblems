package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class PalindromePartitioning {
    
	public boolean isPalindrome(String s) {
		if (s.length() < 2)
			return true;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
	
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() < 1)
			return ans;
		
		for (int i = 1; i < s.length(); i++) {
			String firstSeg = s.substring(0, i);
			if (isPalindrome(firstSeg)) {
				ArrayList<ArrayList<String>> parts = partition(s.substring(i));
				for (ArrayList<String> part : parts) {
					ArrayList<String> sol = new ArrayList<String>();
					sol.add(firstSeg);
					sol.addAll(part);
					ans.add(sol);
				}
			}
		}
		
		if (isPalindrome(s)) {
			ArrayList<String> sol = new ArrayList<String>();
			sol.add(s);
			ans.add(sol);
		}
		
		return ans;
    }
    
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		ArrayList<ArrayList<String>> ans = pp.partition("abaa");
		for (ArrayList<String> part : ans) {
			for (String s : part)
				System.out.print(s + " ");
			System.out.println();
		}
	}

}
