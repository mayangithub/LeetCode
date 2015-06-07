/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;

/**
 * Course Schedule II #210 --- accepted 460ms
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. 
 * ******* If it is impossible to finish all courses, return an empty array. ********
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
 * So the correct course order is [0,1]
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
 * Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. 
 * Another correct ordering is[0,2,1,3].
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
 * @author yanma
 * @since 2015-06-06
 * @version 2015-06-06
 */
public class CourseScheduleII_210 {

	private static class Vertex {
		private int index;
		private boolean explored;
		private boolean reachable;
		private ArrayList<Vertex> pres;
		
		public Vertex(int i) {
			this.index = i;
			this.explored = false;
			this.reachable = false;
			this.pres = new ArrayList<>();
		}
	}
	
	
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] orderlist = new int[numCourses];
        if (numCourses == 0) {
        	return orderlist;
        } else if (prerequisites == null || prerequisites.length == 0) {
        	for (int i = 0; i < numCourses; i++) {
        		orderlist[i] = i;
        	}
        	return orderlist;
        }
        
        ArrayList<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
        	Vertex vertice = new Vertex(i);
        	vertices.add(vertice);
        }
        
        //pre-request list construction
        for (int[] edge : prerequisites) {
			int later = edge[0];
			int former = edge[1];//pre-request
			vertices.get(later).pres.add(vertices.get(former));
		}
        int size = 0;
        for (Vertex vertex : vertices) {
			if (!vertex.reachable) {
				size = iscycle(vertex, orderlist, size);
				if (size == -1) {
					orderlist = new int[0];
					return orderlist;
				}
			}
		}
        
        return orderlist;
    }
	
	
    public static int iscycle(Vertex vertice, int[] order, int size) {
    	if (vertice.explored) {
    		return -1;
    	}
    	if (vertice.reachable) {
    		return size;
    	} 
    	vertice.explored = true;
    	for (Vertex pre : vertice.pres) {
			if (!pre.reachable) {
				size = iscycle(pre, order, size);
				if (size == -1) {
					return -1;
				}
				
			}
		}
    	
    	vertice.explored = false;
    	vertice.reachable = true;
    	order[size] = vertice.index;
    	size++;
    	return size;
    }
    
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		
		int[] list1 = findOrder(numCourses, prerequisites);
		System.out.print("[");
		for (int i : list1) {
			System.out.print(i + ", ");
		}
		System.out.println("]");
		
		
	}

}
