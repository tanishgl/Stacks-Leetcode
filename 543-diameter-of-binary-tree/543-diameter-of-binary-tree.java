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
    static class Pair{
        int height = 0;
        int diameter = 0;
    }
    
    public Pair helper(TreeNode root){
        if(root == null) return new Pair();    
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        Pair curr = new Pair();
        curr.diameter = Math.max(left.height + right.height + 1, Math.max(left.diameter, right.diameter));
        
        curr.height = Math.max(left.height, right.height) + 1;
        
        return curr;
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return helper(root).diameter - 1;
    }
}