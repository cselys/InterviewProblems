package fantasist.InterviewProblems.leetcode.passed;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    class Boundary {
        public int left;
        public int right;
    }
    
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        if (num.length == 1)
            return 1;
        HashMap<Integer, Boundary> map = new HashMap<Integer, Boundary>();
        int maxlen = 0;
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i]))
                continue;
            else {
                Boundary left = map.get(num[i] - 1);
                Boundary right = map.get(num[i] + 1);
                Boundary cur = new Boundary();
                if (left != null)
                    cur.left = left.left;
                else
                    cur.left = num[i];
                if (right != null)
                    cur.right = right.right;
                else
                    cur.right = num[i];
                if (left != null)
                    map.get(left.left).right = cur.right;
                if (right != null)
                    map.get(right.right).left = cur.left;
                maxlen = Math.max(maxlen, cur.right - cur.left + 1);
                map.put(num[i], cur);
            }
        }
        
        return maxlen;
    }
    
    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(l.longestConsecutive(nums));
    }

}
