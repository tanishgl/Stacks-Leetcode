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
   public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
       
        return sum(root, 0);
    }
    
    public int sum(TreeNode root, int sof){
        if(root==null) return sof;
        
        int curr = sof*10 + root.val;
        
        if(root.left==null && root.right==null){
            return curr;
        } else if (root.left==null){
            return sum(root.right, curr);
        } else if (root.right==null){
            return sum(root.left, curr);
        } else {
            return sum(root.left, curr) + sum(root.right, curr);
        }
    }
    
}