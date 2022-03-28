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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            //case 1 :- No child Node.
            if(root.left == null && root.right == null){
                return null;
            } 
            //case 2 :- Single child
            else if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            } 
            //case 3 :- Binary Node
            else {
                int justSmaller = maxF(root.left);
                root.val = justSmaller;
                root.left = deleteNode(root.left, justSmaller);
                return root;
            }
        }
    }
    
    public int maxF(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        int ans = Math.max(root.val, maxF(root.right));
        return ans;
    }
}