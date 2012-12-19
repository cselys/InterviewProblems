package fantasist.InterviewProblems.leetcode.passed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSums {
	
	class Tuple {
		private int a, b, c;
		public Tuple(int x, int y, int z) {
			int[] arr = new int[3];
			arr[0] = x;
			arr[1] = y;
			arr[2] = z;
			Arrays.sort(arr);
			a = arr[0];
			b = arr[1];
			c = arr[2];
		}
		
		@Override
		public boolean equals(Object o) {
			Tuple t = (Tuple)o;
			if (a == t.a && b == t.b && c == t.c)
				return true;
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return ((a * 13) + b) * 13 + c;
		}
		
		public ArrayList<Integer> toList() {
			ArrayList<Integer> list = new ArrayList<Integer>(3);
			list.add(a);
			list.add(b);
			list.add(c);
			return list;
		}
	}
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashSet<Tuple> dedup = new HashSet<Tuple>();
		
		if (num.length < 3)
			return result;
		Arrays.sort(num);
		int len = num.length;
		for (int i = 0; i < len; i++) {
			if (i > 0 && num[i] == num[i-1])
				continue;
			
			int target = -num[i];
			int left = 0, right = len - 1;
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				}
				if (right == i) {
					right--;
					continue;
				}
				int sum = num[left] + num[right];
				if (sum == target) {
					Tuple newTuple = new Tuple(num[i], num[left], num[right]);
					if (!dedup.contains(newTuple)) {
						dedup.add(newTuple);
						result.add(newTuple.toList());
					}
					left++;
					right--;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		return result;
	}
    
    public static void main(String[] args) {
    	int[] nums = {-1, 0, 1, 2, -1, -4};
    	
    	ThreeSums s = new ThreeSums();
    	ArrayList<ArrayList<Integer>> result = s.threeSum(nums);
    	for(ArrayList<Integer> tuple : result) {
    		System.out.println("{" + tuple.get(0) + ", " + tuple.get(1) + ", " + tuple.get(2) + "}");
    	}
    }

	public class Pair {
		Integer a;
		Integer idxA;
		Integer b;
		Integer idxB;
		
		public Pair(int a, int idxA, int b, int idxB) {
			this.a = Integer.valueOf(a);
			this.idxA = Integer.valueOf(idxA);
			this.b = Integer.valueOf(b);
			this.idxB = Integer.valueOf(idxB);
		}
	}
	
    public ArrayList<ArrayList<Integer>> threeSum_failed(int[] num) {        
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	HashSet<ArrayList<Integer>> dedup = new HashSet<ArrayList<Integer>>();
    	
    	if(num == null || num.length == 0) {
    		return result;
    	}
    	
    	HashMap<Integer, List<Pair>> entries = new HashMap<Integer, List<Pair>>();
    	for(int i = 0; i < num.length; i++) {
    		for(int j = i + 1; j < num.length; j++) {
    			boolean needToAdd = false;
    			int sum = num[i] + num[j];
    			if(sum < 0) {
    				continue;
    			}
    			List<Pair> entry = entries.get(Integer.valueOf(sum));
    			if(entry == null) {
    				entry = new ArrayList<Pair>();
    				needToAdd = true;
    			}
    			Pair newPair = new Pair(num[i], i, num[j], j);
    			entry.add(newPair);
    			if(needToAdd) {
    				entries.put(Integer.valueOf(sum), entry);
    			}
    		}
    	}
    	
    	for(int i = 0; i < num.length; i++) {
    		if(num[i] > 0) {
    			continue;
    		}
    		Integer key = Integer.valueOf(- num[i]);
    		List<Pair> entry = entries.get(key);
    		if(entry != null) {
	    		for(Pair p : entry) {
	    			if(p.idxA.intValue() != i && p.idxB.intValue() != i) {
	    				ArrayList<Integer> tuple = new ArrayList<Integer>();
	    				tuple.add(p.a);
	    				tuple.add(p.b);
	    				tuple.add(Integer.valueOf(num[i]));
	    				Collections.sort(tuple);
	    				if(!dedup.contains(tuple)) {
	    					dedup.add(tuple);
	    					result.add(tuple);
	    				}
	    			}
	    		}
    		}
    	}
    	
    	return result;
    }
}