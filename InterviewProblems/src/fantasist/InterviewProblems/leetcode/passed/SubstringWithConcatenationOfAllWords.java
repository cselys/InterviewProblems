package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {

	private int len = 0;
	
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		if (S == null || L == null || S.length() == 0 || L.length == 0)
			return ans;
		HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
		len = L[0].length();
		if (len < 1 || S.length() < len)
			return ans;
		int wordCount = 0;
		int[] expecting = new int[L.length];
		for (String str : L) {
			Integer idx = indexMap.get(str);
			if (idx == null) {
				expecting[wordCount] = 1;
				indexMap.put(str, wordCount);
				wordCount++;
			} else {
				expecting[idx.intValue()]++;
			}
		}
//		System.out.println("WordCount: " + wordCount);
		
		int[] indexArray = new int[S.length() - len + 1];
		for (int i = 0; i + len <= S.length(); i++) {
			indexArray[i] = -1;
			String seg = S.substring(i, i + len);
			Integer idx = indexMap.get(seg);
			if (idx != null)
				indexArray[i] = idx.intValue();
			
//			System.out.print(indexArray[i] + " ");
		}
		
		for (int k = 0; k < len; k++) {
			int toFind = L.length;
			int start = k;
			for (int i = k; i + len <= S.length(); i = i + len) {
				int cur = indexArray[i];
				if (cur < 0) {
					toFind = L.length;
					for (int j = start; j < i; j += len) {
						int release = indexArray[j];
						if (release >= 0)
							expecting[release]++;
					}
					start = i + len;
				} else if (expecting[cur] <= 0) {
					for (int j = start; j < i; j += len) {
						int release = indexArray[j];
						if (release == cur) {
							start = j + len;
							if (toFind == 0)
								ans.add(start);
							break;
						} else if (release >= 0) {
							expecting[release]++;
							toFind++;
						}
					}
				} else {
					expecting[cur]--;
					toFind--;
					if (toFind == 0)
						ans.add(start);
				}
			}
			while (start + len <= S.length()) {
				int release = indexArray[start];
				if (release >= 0)
					expecting[release]++;
				start = start + len;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
//		String[] L = {"a", "a"};
//		String S = "aaa";
		String[] L = {"ba","ab","ab"};
		String S = "abaababbaba";
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		ArrayList<Integer> ans = s.findSubstring(S, L);
		System.out.println();
		for (Integer i : ans) {
			System.out.print(i + " ");
		}
	}

}
