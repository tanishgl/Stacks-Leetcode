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
    int longestzz = 0;
    
    public int longestZigZag(TreeNode root) {
        helper(root, 0);
        helper(root, 1);
        return longestzz - 1;
    }
    
    public int helper(TreeNode node, int dir){
        if(node==null) return 0;
        
        int zig = helper(node.left, 0);
        int zag = helper(node.right, 1);
        
        longestzz = Math.max(longestzz, Math.max(zig+1, zag+1));
        
        if(dir==0){
            return zag + 1;
        } else {
            return zig + 1;
        }
    }
}