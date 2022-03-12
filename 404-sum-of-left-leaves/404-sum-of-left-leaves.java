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
    int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root.left, 0);
        helper(root.right, 1);
        return sum;
    }
    
    public void helper(TreeNode node, int dir){
        if(node == null) return;
        if(node.left == null && node.right == null && dir == 0) sum += node.val;
        
        helper(node.left, 0);
        helper(node.right, 1);
        return;
    }
}