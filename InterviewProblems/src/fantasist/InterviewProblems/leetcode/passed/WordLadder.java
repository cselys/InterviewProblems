package fantasist.InterviewProblems.leetcode.passed;

import java.util.HashSet;

public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start == null || end == null || start.length() != end.length())
            return 0;
        int dist = 1;
        HashSet<String> used = new HashSet<String>();
        HashSet<String> cur = new HashSet<String>();
        cur.add(start);
        while(!cur.isEmpty()) {
            HashSet<String> newCur = new HashSet<String>();
            dist++;
            for (String s : cur) {
                char[] str = s.toCharArray();
                for (int i = 0; i < str.length; i++) {
                    for (int j = 0; j < 26; j++) {
                        if (str[i] != (char)('a' + j)) {
                            char temp = str[i];
                            str[i] = (char)('a' + j);
                            String candidate = new String(str);
                            if (candidate.equals(end))
                                return dist;
                            if (!used.contains(candidate) && dict.contains(candidate)) {
                                newCur.add(candidate);
                                used.add(candidate);
                            }
                            str[i] = temp;
                        }
                    }
                }
            }
            
            cur = newCur;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        testCase1();
    }

    public static void testCase1() {
        WordLadder w = new WordLadder();
        HashSet<String> dict = new HashSet<String>();
        dict.add("dot");
        System.out.println(w.ladderLength("dog", "hot", dict));
    }
}
