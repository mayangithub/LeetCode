/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals #56 --- Accepted 400ms
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18]. 
 * @author yanma
 * @since 2015-06-22
 * @version 2015-06-22
 */
public class MergeIntervals_56 {
	
	
    public List<Interval> merge(List<Interval> intervals) {
    	
        if (intervals == null || intervals.size() <= 1) {
        	return intervals;
        }
        
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new NewComparator());
        Interval lastInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
        	Interval currentInterval = intervals.get(i);
			if (currentInterval.start <= lastInterval.end) { // compare two ends, merge
				lastInterval.end = Math.max(lastInterval.end, currentInterval.end);
			} else { // not overlap, add last interval into result list
				result.add(lastInterval);
				lastInterval = currentInterval;
			}
		}
        
        result.add(lastInterval);
        return result;
        
    }
    
    private class NewComparator implements Comparator<Interval> {
    	public int compare(Interval first, Interval second) {
    		return first.start - second.start;
    	}
    }
    
    
}
