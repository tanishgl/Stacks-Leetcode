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
    
//     boolean flag = false;
    
//     public void helper(TreeNode root, int target){
//         if(root==null) return;
        
//         if(root.left==null && root.right==null){
//             flag = flag || (root.val == target);
//             return;
//         }
        
//         helper(root.left, target - root.val);
//         helper(root.right, target - root.val);
//     }
    
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if(root==null) return false;
//         helper(root, targetSum);
//         return flag;
//     }
    
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null) return false;
        
        if(root.left==null && root.right==null){
            //leaf node.
            return root.val==targetSum;
        }
        
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }
}