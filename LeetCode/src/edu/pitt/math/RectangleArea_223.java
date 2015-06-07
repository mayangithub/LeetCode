/**
 * 
 */
package edu.pitt.math;

/**
 * Rectangle Area #223 --- Accepted 196ms
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 * @author yanma
 * @since 2015-06-07
 * @version 2015-06-07
 */
public class RectangleArea_223 {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        /**
         * total area = area1 + area2 - overlap area
         * find the overlap rectangle left bottom corner and right top corner position
         * left bottom corner: 
         * x1: Math.max(A, E); y1: Math.max(B, F)
         * right top corner:
         * x2: Math.min(C, G); y2: Math.min(D, H)
         * if (x1 >= x2) || (y1 >= y2), overlap area = 0
         * 
         */
    	int area1 = (C - A) * (D - B);
    	int area2 = (G - E) * (H - F);
    	if (area1 == 0) {
    		return area2;
    	} else if (area2 == 0) {
    		return area1;
    	}
    	
    	int x1 = 0;
    	int y1 = 0;
    	int x2 = 0;
    	int y2 = 0;
    	int areaoverlap = 0;
    	
    	x1 = Math.max(A, E); y1 = Math.max(B, F);
    	x2 = Math.min(C, G); y2 = Math.min(D, H);
    	
    	if (x1 >= x2 || y1 >= y2) {
    		areaoverlap = 0;
    	} else {
    		areaoverlap = (x2 - x1) * (y2 - y1);
    	}
    	
    	return area1 + area2 - areaoverlap;
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = -3; int B = 0; int C = 3; int D = 4;
		int E = 0;  int F = -1;int G = 9; int H = 2;
		
		
		System.out.println(computeArea(A, B, C, D, E, F, G, H));
		
		System.out.println(computeArea(0, 0, 0, 0, -1, -1, 1, 1));
		System.out.println(computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
		
	}

}
