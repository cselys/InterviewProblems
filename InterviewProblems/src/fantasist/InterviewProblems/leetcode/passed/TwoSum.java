package fantasist.InterviewProblems.leetcode.passed;

import java.util.Arrays;

public class TwoSum {

	class Pair implements Comparable<Pair> {
		int idx, val;
		public Pair(int i, int v) {
			idx = i;
			val = v;
		}
		
		@Override
		public int compareTo(Pair p) {
			if (val < p.val)
				return -1;
			else if (val == p.val)
				return 0;
			else
				return 1;
		}
	}
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2)
        	return null;
    	Pair[] pairs = new Pair[numbers.length];
    	for (int i = 0; i < numbers.length; i++) {
    		Pair newPair = new Pair(i, numbers[i]);
    		pairs[i] = newPair;
    	}
    	
    	Arrays.sort(pairs);
    	
    	int[] ans = new int[2];
        int left = 0, right = pairs.length - 1;
        while (left < right) {
        	int sum = pairs[left].val + pairs[right].val;
        	if (sum == target) {
        		int idx1 = pairs[left].idx + 1;
        		int idx2 = pairs[right].idx + 1;
        		ans[0] = Math.min(idx1, idx2);
        		ans[1] = Math.max(idx1, idx2);
        		return ans;
        	} else if (sum < target) {
        		left++;
        	} else {
        		right--;
        	}
        }
        
        return null;
    }
    
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		
//		int[] numbers = {3, 0, 2, 4, -1, 8};
//		int target = 6;
		
		int[] numbers = {2, 1};
		int target = 3;
		
		int[] ans = ts.twoSum(numbers, target);
		if (ans != null) {
			System.out.println(numbers[ans[0]-1] + " + " + numbers[ans[1]-1] + " = " + target);
		}
	}

}
