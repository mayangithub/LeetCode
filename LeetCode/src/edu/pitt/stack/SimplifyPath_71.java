/**
 * 
 */
package edu.pitt.stack;

/**
 * Simplify Path #71 --- Accepted 316ms
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
 * @author yanma
 * @since 2015-05-23
 * @version 2015-05-23
 * Root Directory 	Directory Separator 	Current Directory 	Parent Directory
 *       /                 /                      .                   ..
 */
public class SimplifyPath_71 {

    public static String simplifyPath(String path) {
        /**
         * 1. remove last duplicate / 
         * 2. remove front duplicate /, only leave 1 /
         * 3. start from 0, start < length, 
         * 	  end from start + 1, to end char is /
         * 	  if substring is /. no move, start = end
         * 	  if substring is /.. dequeue pop last
         *    else, dequeue push last
         * 4. dequeue pop first, use string buffer append
         * 
         */
    	
    	if (path == null || path.length() == 0) {
    		return "";
    	} 
    	
    	path = cleanSlash(path);
    	
    	if (path.length() == 1) {
    		return path;
    	}
    	
    	int start = 0;
    	int end = start + 1;
    	java.util.Deque<String> deque = new java.util.LinkedList<String>();
    	
    	while (start < path.length()) {
    		while (end < path.length() && path.charAt(end) == '/') {
				start = end;
				end = start + 1;
			}
    		
			while (end < path.length() && path.charAt(end) != '/') {
				end++;
			}
			
			
			
			if (path.substring(start, end).equals("/..")) {
				if (!deque.isEmpty()) {
					deque.pollLast();
				}
			} else if (!path.substring(start, end).equals("/.")) {
				deque.offerLast(path.substring(start, end));
			}
			start = end;
			end = start + 1;
		}
    	
    	if (deque.isEmpty()) {
    		return "/";
    	}
    	
    	StringBuffer stringBuffer = new StringBuffer();
    	
    	while (!deque.isEmpty()) {
			stringBuffer.append(deque.pollFirst());
		}
    	
    	path = stringBuffer.toString();
    	return path;
    }
	
	public static String cleanSlash(String path) {
		/**
		 * 1. remove last duplicate / 
         * 2. remove front duplicate /, only leave 1 /
		 */
		
		//trim front
		int i = 0;
		while (i < path.length() && path.charAt(i) == '/') {
			i++;
		}
		
		path = i > 0 ? path.substring(i - 1): path.substring(i);
		
		//trim last
		i = path.length() - 1;
		while (i >= 0 && path.charAt(i) == '/') {
			i--;
		}
		path = path.substring(0, i + 1);
		
		return path;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path1 = "///../..";
		String path2 = "../..//";
		String path3 = "/.././";
		String path4 = "/home/";
		String path5 = "/a/./b/../../c/";
		String path6 = "/../";
		String path7 = "/home//foo/";
		
		System.out.println(simplifyPath(path1));
		System.out.println(simplifyPath(path2));
		System.out.println(simplifyPath(path3));
		System.out.println(simplifyPath(path4));
		System.out.println(simplifyPath(path5));
		System.out.println(simplifyPath(path6));
		System.out.println(simplifyPath(path7));
	}

}
