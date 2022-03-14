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
    public int minDepth(TreeNode root) {
        // if(root==null){
        //     //Tree is null. So, no depth -> 0 depth.
        //     return 0;
        // } else if (root.left==null && root.right==null){
        //     //Leaf Node.
        //     return 1;
        // } else if (root.left==null){
        //     //Only right child exists.
        //     return 1 + minDepth(root.right);
        // } else if (root.right==null){
        //     //Only left child exists.
        //     return 1 + minDepth(root.left);
        // } else {
        //     //2 - child node.
        //     return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        // }
        
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        int level = 1;
        
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                TreeNode curr = q.remove();
                if(curr.left == null && curr.right == null) return level;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            level++;
        }
        
        return level;
    }
}