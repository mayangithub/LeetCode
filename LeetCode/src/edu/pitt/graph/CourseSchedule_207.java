/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;

/**
 * Course Schedule #207 --- Accepted 364ms
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
 * @author yanma
 * @since 2015-06-06
 * @version 2015-06-06
 */
public class CourseSchedule_207 {
	public class Vertex {
		int index;
		boolean explored; // when check is/not cyclic
		boolean reachable; //after checking all precourses, make it true
		ArrayList<Vertex> precourses;
		public Vertex(int i) {
			this.index = i;
			this.explored = false;
			precourses = new ArrayList<>();
			this.reachable = false;
		}
	}

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
        	return true;
        }
        
        java.util.HashMap<Integer, Vertex> hashMap = new java.util.HashMap<Integer, Vertex>();
        for (int i = 0; i < numCourses; i++) {
        	Vertex vertex = new Vertex(i);
        	hashMap.put(i, vertex);
        }
        
        for (int[] is : prerequisites) {
			Vertex totakecourse = hashMap.get(is[0]);
			Vertex precourse = hashMap.get(is[1]);
			totakecourse.precourses.add(precourse);
		}
        
        for (int i = 0; i < numCourses; i++) {
			if (!hashMap.get(i).reachable) {
				for (Vertex pre : hashMap.get(i).precourses) {
					if (iscyclic(hashMap, pre)) {
						return false;
					}
				}
				hashMap.get(i).reachable = true;
			}
		}
        
        return true;
    }
	
	public boolean iscyclic(java.util.HashMap<Integer, Vertex> hashMap, Vertex course) {
		if (course.reachable) { // no cycle, can be reached
			return false;
		}
		
		if (course.explored) { // visited in precourses
			return true;
		}
		
		course.explored = true;
		
		for (Vertex prec : course.precourses) {
			if (!prec.reachable) {
				if (iscyclic(hashMap, prec)) {
					return true;
				}
			}
		}
		
		course.explored = false;
		course.reachable = true;
		
		return false;
	}
    
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
