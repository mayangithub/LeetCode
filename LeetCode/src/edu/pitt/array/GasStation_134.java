/**
 * 
 */
package edu.pitt.array;

/**
 * Gas Station #134 --- Accepted 298ms
 *  There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *  You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 *  You begin the journey with an empty tank at one of the gas stations.
 *  Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *  Note:
 *  The solution is guaranteed to be unique. 
 * @author yanma
 * @since 2015-05-07
 * @version 2015-05-07
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
        	return -1;
        }
        
        int[] gap = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
        	gap[i] = gas[i] - cost[i];
        }
        
        int start = 0;
        while (start < gap.length) {
            if (gap[start] < 0) {
        		start++;
        	} else {
				int tank = gap[start];
				int end = (start + 1) % gap.length;
				while (end != start) {
				    tank += gap[end];
				    end = (end + 1) % gap.length;
				    if (start >= end && tank < 0) {
				        return -1;
				    } else if (start < end && tank < 0) {
				        start = end;
						end = (start + 1) % gap.length;
						break;
				    }
				}
				
				if (start == end && tank >= 0) {
				    return start;
				}
			}
        }    
        return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
