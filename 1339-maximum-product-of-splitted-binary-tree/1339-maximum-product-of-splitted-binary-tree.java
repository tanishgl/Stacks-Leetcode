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
    
    public int subtreeSum(TreeNode root){
        if(root==null) return 0;
        
        root.val += subtreeSum(root.left) + subtreeSum(root.right);
        return root.val;
    }
    
    long maxProduct = 0;
    long total = 0;
    
    public int maxProduct(TreeNode root) {
        if(root==null) return 0;
        total = subtreeSum(root);
        helper(root);
        return (int)(maxProduct % 1000000007);
    }
    
    public void helper(TreeNode root){
        if(root==null) return;
        
        helper(root.left);
        helper(root.right);
        
        long leftSubtreeSum = (root.left==null) ? 0l : root.left.val;
        long leftProduct = leftSubtreeSum * (total - leftSubtreeSum);
        
        long rightSubtreeSum = (root.right==null) ? 0l : root.right.val;
        long rightProduct = rightSubtreeSum * (total - rightSubtreeSum);
        
        maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        
    }
}