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
    public int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return diameter - 1;
    }
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        
        int lh = helper(root.left);
        int rh = helper(root.right);
        
        diameter = Math.max(diameter, lh + rh + 1);
        
        return Math.max(lh, rh) + 1;
    }
}