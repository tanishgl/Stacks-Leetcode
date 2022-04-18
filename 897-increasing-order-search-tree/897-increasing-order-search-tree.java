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
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        rec(root, res);
        for(int i=0;i<res.size();i++){
            res.get(i).left = null;
            res.get(i).right = null;
        }
        
        TreeNode nroot = res.get(0);
        for(int i=0;i<res.size();i++){
            res.get(i).right = (i+1 < res.size()) ? res.get(i+1) : null;
        }
        return nroot;
    }
    
    public void rec(TreeNode root, List<TreeNode> res){
        if(root == null) return;
        rec(root.left, res);
        res.add(root);
        rec(root.right, res);
    }
}