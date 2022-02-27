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
    public boolean fromMe(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        else if (root==null || subRoot==null) return false;
        
        //Compare root node.
        if(root.val == subRoot.val) {
            return fromMe(root.left, subRoot.left) && fromMe(root.right, subRoot.right);
        }
        
        return false;
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        else if (root==null || subRoot==null) return false;
        
        return fromMe(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}