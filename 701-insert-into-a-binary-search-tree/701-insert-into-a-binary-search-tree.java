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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val, null, null);
        // if(root.val == val) return root;
        
        if(root.left == null && val < root.val){
            TreeNode temp = new TreeNode(val,null,null);
            root.left = temp;
            return root;
        } else if (root.right == null && val > root.val){
            TreeNode temp = new TreeNode(val,null,null);
            root.right = temp;
            return root;
        }
        
        if(val < root.val){
            insertIntoBST(root.left, val);
        } else if (val > root.val){
            insertIntoBST(root.right, val);
        }
        
        return root;
    }
}