/**
 * 
 */
package edu.pitt.tree;

/**
 * Convert Sorted Array to Binary Search Tree #108 --- Accepted 323ms
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author yanma
 * @since 2015-05-09
 * @version 2015-05-09
 */
public class ConvertSortedArraytoBinarySearchTree_108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return null;
        } else if (nums.length == 1) {
        	TreeNode rootNode = new TreeNode(nums[0]);
        	return rootNode;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        buildTree(root, start, mid - 1, nums, 0); // direction = 0, left; direction = 1, right;
        buildTree(root, mid + 1, end, nums, 1);
        
        return root;
    }
    
    public static void buildTree(TreeNode root, int start, int end, int[] nums, int direction) {
    	if (start > end) {
    		return;
    	}
    	
    	int mid = (start + end) / 2;
    	
    	if (direction == 0) {
    		TreeNode leftNode = new TreeNode(nums[mid]);
    		root.left = leftNode;
    		buildTree(leftNode, start, mid - 1, nums, 0);
        	buildTree(leftNode, mid + 1, end, nums, 1);
    	} else if (direction == 1) {
    		TreeNode rightNode = new TreeNode(nums[mid]);
    		root.right = rightNode;
    		buildTree(rightNode, start, mid - 1, nums, 0);
        	buildTree(rightNode, mid + 1, end, nums, 1);
    	}
    	
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,4,5,6,7,8,9};
		TreeNode rootNode = sortedArrayToBST(nums);
		
		System.out.println(rootNode.val);
	}

}
