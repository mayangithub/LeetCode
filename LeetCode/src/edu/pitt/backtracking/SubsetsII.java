/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LintCode SubsetsII --- Accepted 
 * @author yanma
 * @since 2015-06-13
 * @version 2015-06-13
 */
public class SubsetsII {

	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0) {
            list.add(new ArrayList<Integer>());
            return list;
        }
        
        Collections.sort(S);
        list.add(new ArrayList<Integer>());
        helper(S, 0, list);
        
        return list;
    }
    
    public static void helper(ArrayList<Integer> S, int start, ArrayList<ArrayList<Integer>> list) {
        if (start == S.size()) {
            return;
        }
        int size = 1;

        for (int i = start; i < S.size(); i++) {
            if (i > 0 && S.get(i).intValue() == S.get(i - 1).intValue()) {
                int newsize = list.size();
                for (int pos = size; pos < newsize; pos++) {
                    ArrayList<Integer> newinner = new ArrayList<Integer>(list.get(pos));
                    newinner.add(S.get(i));
                    list.add(newinner);
                }
                size = newsize;
            } else {
                size = list.size();
                for(int index = 0; index < size; index++) {
                    ArrayList<Integer> newinner = new ArrayList<Integer>(list.get(index));
                    newinner.add(S.get(i));
                    list.add(newinner);
                }
            }
        }
        
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> S = new ArrayList<Integer>();
		int[] array = {1,1};
		for (int i : array) {
			S.add(i);
		}
		
		ArrayList<ArrayList<Integer>> list = subsetsWithDup(S);
		System.out.println("[");
		for (List<Integer> inner: list) {
			System.out.print("[");
			for (int i = 0; i < inner.size(); i++) {
				System.out.print(inner.get(i));
				if (i < inner.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
		System.out.println("]");
		
	}

}
