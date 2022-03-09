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
    public String tree2str(TreeNode root) {
        String res = root.val + "";
        
        if(root.left != null && root.right != null){
            res += "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
        } else if (root.left != null){
            res += "(" + tree2str(root.left) + ")";
        } else if (root.right != null){
            res += "()" + "(" + tree2str(root.right) + ")";
        }
        
        return res;
    }
}