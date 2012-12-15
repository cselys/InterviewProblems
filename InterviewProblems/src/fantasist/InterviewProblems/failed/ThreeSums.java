package fantasist.InterviewProblems.failed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSums {
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
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {        
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
    
    
    public static void main(String[] args) {
    	int[] nums = {-1, 0, 1, 2, -1, -4};
    	
    	ThreeSums s = new ThreeSums();
    	ArrayList<ArrayList<Integer>> result = s.threeSum(nums);
    	for(ArrayList<Integer> tuple : result) {
    		System.out.println("{" + tuple.get(0) + ", " + tuple.get(1) + ", " + tuple.get(2) + "}");
    	}
    }
}