/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval #57 --- Accepted 412ms
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 * @author yanma
 * @since 2015-06-15
 * @version 2015-06-15
 */
public class InsertInterval_57 {
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> list = new ArrayList<Interval>();
        if (newInterval == null) {
        	return intervals;
        }
        if (intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }
        int index = 0;
        boolean added = false;
        int start = newInterval.start;
        int end = newInterval.end;
        while (index < intervals.size()) {
        	Interval interval = intervals.get(index);
			if (interval.end < start) {
				list.add(interval);
				index++;
			} else if (interval.start > end) {
				list.add(new Interval(start, end));
				added = true;
				break;
			} else {
			    start = Math.min(start, interval.start);
			    end = Math.max(end, interval.end);
			    index++;
			}
        	
		}
        
        while (added && index < intervals.size()) {
			list.add(intervals.get(index));
			index++;
		}
		if (!added) {
		    list.add(new Interval(start, end));
		}
        
    	return list;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
