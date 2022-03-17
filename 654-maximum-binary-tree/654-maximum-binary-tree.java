/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return function(nums, 0, nums.length-1);
    }
    
    public TreeNode function(int[] nums, int l, int r){
        if(l > r) return null;
        
        if(l == r){
            return new TreeNode(nums[l], null, null);
        } 
        
        //find index of max element.
        int idx = find(nums, l, r);
        
        TreeNode root = new TreeNode(nums[idx]);
        root.left = function(nums, l, idx - 1);
        root.right = function(nums, idx + 1, r);
        return root;
    }
    
    public static int find(int[] arr, int l, int r){
        int idx = l;
        for(int i=l+1;i<=r;i++){
            if(arr[i]>arr[idx]){
                idx = i;
            }
        }
        
        return idx;
    }
}