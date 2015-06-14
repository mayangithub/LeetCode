/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Dungeon Game #174 --- Accepted 348ms 
 * *******another solution available online judge
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
 * The dungeon consists of M x N rooms laid out in a 2D grid. 
 * Our valiant knight (K) was initially positioned in the top-left room and 
 * must fight his way through the dungeon to rescue the princess.
 * The knight has an initial health point represented by a positive integer. 
 * If at any point his health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, 
 * the knight decides to move only rightward or downward in each step.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * For example, given the dungeon below, the initial health of the knight must be at least 7 
 * if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *  ______________________
 * | -2 (K) | -3  | 3     |
 * |________|_____|_______|
 * | -5     | -10 |	1     |
 * |________|_____|_______|
 * | 10 	| 30  | -5 (P)|
 * |________|_____|_______|
 * Notes:
 *
 *  The knight's health has no upper bound.
 *  Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room 
 *  where the princess is imprisoned.
 * @author yanma
 * @since 2015-06-12
 * @version 2015-06-12
 */
public class DungeonGame_174 {
	
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
        	return 1;
        }
        
        int start = 1; int end = Integer.MAX_VALUE - 1;
        while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (isPossible(mid, dungeon)) {
				end = mid;
			} else {
				start = mid;
			}
		}
        if (isPossible(start, dungeon)) {
        	return start;
        }
        return end;
    }
    
    public static boolean isPossible(int health, int[][] dungeon) {
    	int rows = dungeon.length;
    	int cols = dungeon[0].length;
    	int[][] cal = new int[rows][cols];
    	
    	if (dungeon[0][0] + health <= 0) {
    		return false;
    	} else {
			cal[0][0] = dungeon[0][0] + health;
		}
    	
    	for (int col = 1; col < cal[0].length; col++) {
			cal[0][col] = (cal[0][col - 1] <= 0) ? -1: cal[0][col - 1] + dungeon[0][col];
		}
    	
    	for (int row = 1; row < cal.length; row++) {
			cal[row][0] = (cal[row - 1][0] <= 0) ? -1: cal[row - 1][0] + dungeon[row][0];
		}
    	
    	for (int row = 1; row < cal.length; row++) {
			for (int col = 1; col < cal[0].length; col++) {
				int base = Math.max(cal[row][col - 1], cal[row - 1][col]);
				if (base <= 0) {
					cal[row][col] = -1;
				} else {
					cal[row][col] = base + dungeon[row][col];
					cal[row][col] = (cal[row][col] <= 0) ? -1: cal[row][col];
				}
			}
		}
    	
    	return cal[rows - 1][cols - 1] > 0;
    }
    
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeon = {{2,1}, {1,-1}};
		
		System.out.println(calculateMinimumHP(dungeon));
	}

}
