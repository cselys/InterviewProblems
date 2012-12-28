package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fantasist.InterviewProblems.leetcode.utils.Interval;

public class MergeIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty())
        	return res;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
        	@Override
        	public int compare(Interval i1, Interval i2) {
        		if (i1.start < i2.start)
        			return -1;
        		else if (i1.start > i2.start)
        			return 1;
        		else {
        			if (i1.end < i2.end)
        				return -1;
        			else if (i1.end > i2.end)
        				return 1;
        			else
        				return 0;
        		}
        	}
        };
        Collections.sort(intervals, comparator);
        
        for (int i = 0; i < intervals.size(); i++) {
        	Interval cur = intervals.get(i);
        	if (res.isEmpty()) {
        		res.add(cur);
        	} else {
        		Interval last = res.get(res.size() - 1);
        		if (last.end >= cur.start) {
        			last.end = Math.max(last.end, cur.end);
        		} else {
        			res.add(cur);
        		}
        	}
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		MergeIntervals m = new MergeIntervals();
		ArrayList<Interval> req = new ArrayList<Interval>();
		req.add(new Interval(1, 3));
		req.add(new Interval(2, 6));
		req.add(new Interval(8, 10));
		req.add(new Interval(15, 18));
		ArrayList<Interval> res = m.merge(req);
		for (int i = 0; i < res.size(); i++) {
			if (i != 0)
				System.out.print(", ");
			Interval cur = res.get(i);
			System.out.print("[" + cur.start + ", " + cur.end + "]");
		}
		System.out.println();
	}

}
