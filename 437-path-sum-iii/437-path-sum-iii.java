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
    
    public int mySum(TreeNode root, int targetSum){
        if(root==null) return 0;
        
        int count = 0;
        
        if(root.val == targetSum)
            count++;
        
        return count + mySum(root.left, targetSum-root.val) + mySum(root.right, targetSum - root.val);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        
        return mySum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        
    }
}